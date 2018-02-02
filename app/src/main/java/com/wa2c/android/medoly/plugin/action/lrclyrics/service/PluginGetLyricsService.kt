package com.wa2c.android.medoly.plugin.action.lrclyrics.service

import android.content.Intent
import android.net.Uri
import android.support.v4.content.FileProvider
import com.cybozu.labs.langdetect.DetectorFactoryUtil
import com.cybozu.labs.langdetect.LangDetectException
import com.wa2c.android.medoly.library.LyricsProperty
import com.wa2c.android.medoly.library.MediaPluginIntent
import com.wa2c.android.medoly.library.MediaProperty
import com.wa2c.android.medoly.library.PropertyData
import com.wa2c.android.medoly.plugin.action.lrclyrics.BuildConfig
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ViewLyricsSearcher
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger
import java.io.File
import java.io.FileOutputStream
import java.util.*


/**
 * Download intent service.
 */
/**
 * Constructor.
 */
//@EIntentService
class PluginGetLyricsService : AbstractPluginService(PluginGetLyricsService::class.java.simpleName) {

    private val creatorThread = Thread(ProfileCreator())

    override fun onHandleIntent(intent: Intent?) {
        super.onHandleIntent(intent)

        try {
            getLyrics(pluginIntent)
        } catch (e: Exception) {
            Logger.e(e)
            //AppUtils.showToast(this, R.string.error_app);
        }
    }

//
//    @ServiceAction
//    override fun process(intent: Intent?) {
//        super.process(intent)
//        if (intent == null)
//            return
//
//        try {
//            getLyrics(pluginIntent)
//        } catch (e: Exception) {
//            Logger.e(e)
//            sendResult(null)
//            AppUtils.showToast(this, R.string.error_app)
//        }
//
//    }

    /**
     * Get lyrics.
     * @param pluginIntent A plugin intent.
     */
    private fun getLyrics(pluginIntent: MediaPluginIntent) {
        val resultItem = findLyrics(pluginIntent)
        sendLyricsResult(pluginIntent, resultItem)
        if (resultItem == null) {
            if (prefs.getBoolean(R.string.pref_failure_message_show)) {
                AppUtils.showToast(this, R.string.message_lyrics_failure)
            }
//            if (appPrefs!!.pref_failure_message_show().get()) {
//                AppUtils.showToast(this, R.string.message_lyrics_failure)
//            }
        } else {
            if (prefs.getBoolean(R.string.pref_success_message_show)) {
                AppUtils.showToast(this, R.string.message_lyrics_success)
            }
//            if (appPrefs!!.pref_success_message_show().get()) {
//                AppUtils.showToast(this, R.string.message_lyrics_success)
//            }
        }
    }

    /**
     * Get lyrics info.
     * @param pluginIntent Plugin intent.
     * @return lyrics info.
     */
    private fun findLyrics(pluginIntent: MediaPluginIntent): ResultItem? {

//        // No media data
//        val propertyData = pluginIntent.propertyData
//        if (propertyData == null || propertyData.isMediaEmpty) {
//            return null
//        }
//
//        // No property info
//        val titleText = propertyData.getFirst(MediaProperty.TITLE)
//        val artistText = propertyData.getFirst(MediaProperty.ARTIST)
//        if (TextUtils.isEmpty(titleText) || TextUtils.isEmpty(artistText)) {
//            return null
//        }

        val titleText = propertyData.getFirst(MediaProperty.TITLE) ?: ""
        val artistText = propertyData.getFirst(MediaProperty.ARTIST) ?: ""

        var resultItem: ResultItem? = null

        // search cache
//        if (appPrefs!!.pref_use_cache().get()) {
        if (prefs.getBoolean(R.string.pref_use_cache, true)) {
            val cacheHelper = SearchCacheHelper(this)
            val cache = cacheHelper.select(titleText, artistText)
            if (cache != null) {
                resultItem = cache.makeResultItem()
                //if (resultItem == null && appPrefs!!.pref_cache_non_result().get()) {
                if (resultItem == null && prefs.getBoolean(R.string.pref_cache_non_result, true)) {
                    return null // returns even if it is null
                }
            }
        }

        // search lyrics
        if (resultItem == null) {

            // detect result item
            resultItem = detectResultItem(titleText, artistText)

            // save to cache.
//            if (appPrefs!!.pref_cache_result().get()) {
            if (prefs.getBoolean(R.string.pref_cache_result)) {
                if (resultItem != null) {
                    saveCache(pluginIntent, resultItem)
//                } else if (appPrefs!!.pref_cache_non_result().get()) {
                } else if (prefs.getBoolean(R.string.pref_cache_non_result, true)) {
                    saveCache(pluginIntent, null)
                }
            }
        }

        return resultItem
    }

    /**
     * Detect language.
     * @return result item.
     */
    private fun detectResultItem(titleText: String, artistText: String): ResultItem? {
        var resultItem: ResultItem? = null

        try {
            // pre-creation profiles
//            if (!TextUtils.isEmpty(appPrefs!!.pref_search_first_language().get())) {
            if (!prefs.getString(R.string.pref_search_first_language).isNullOrEmpty()) {
                synchronized(creatorThread) {
                    creatorThread.start() // start profiles creating
                }
            }

            // search
            val result = ViewLyricsSearcher.search(titleText, artistText, 0)

            // sort
            val itemList = result?.infoList
            if (itemList == null || itemList.size == 0)
                return null

            Collections.sort(itemList, Comparator { o1, o2 ->
                // order by rating
                val o1Rating = o1.lyricRate!!
                val o2Rating = o2.lyricRate!!
                if (o1Rating != o2Rating)
                    return@Comparator -java.lang.Double.compare(o1Rating, o2Rating)
                // order by rating count
                val o1RatingCount = o1.lyricRatesCount!!
                val o2RatingCount = o2.lyricRatesCount!!
                if (o1RatingCount != o2RatingCount)
                    return@Comparator -Integer.compare(o1RatingCount, o2RatingCount)
                // order by download count
                val o1Download = o1.lyricDownloadsCount!!
                val o2Download = o2.lyricDownloadsCount!!
                -Integer.compare(o1Download, o2Download)
            })

            // detect language
//            if (TextUtils.isEmpty(appPrefs!!.pref_search_first_language().get())) {
            if (prefs.getString(R.string.pref_search_first_language).isNullOrEmpty()) {
                // not exists preferred language
                resultItem = itemList[0]
                resultItem.language = null
                resultItem.lyrics = ViewLyricsSearcher.downloadLyricsText(resultItem.lyricURL)
            } else {
                // preferred language
//                val threshold = appPrefs!!.pref_search_language_threshold().get()
                val threshold = prefs.getInt(R.string.pref_search_language_threshold, 50)
                val selectedResult = arrayOfNulls<ResultItem>(3) // language 0: first, 1:second: 2: third
                for (item in itemList) {
                    try {
                        val text = ViewLyricsSearcher.downloadLyricsText(item.lyricURL)
                        creatorThread.join() // finish profiles creating

                        val detector = DetectorFactoryUtil.createDetectorAll(this)
                        detector.append(text)
                        val langList = detector.probabilities
                        for (l in langList) {
                            if (l.prob * 100 < threshold)
                                continue
//                            if (TextUtils.isEmpty(appPrefs!!.pref_search_first_language().get()) && selectedResult[0] == null)
                            if (prefs.getString(R.string.pref_search_first_language).isNullOrEmpty() && selectedResult[0] == null)
                                continue
//                            if (l.lang == appPrefs!!.pref_search_first_language().get()) {
                            if (l.lang == prefs.getString(R.string.pref_search_first_language)) {
                                item.language = l.lang
                                item.lyrics = text
                                selectedResult[0] = item
                            }
//                            if (TextUtils.isEmpty(appPrefs!!.pref_search_second_language().get()))
                            if (prefs.getString(R.string.pref_search_second_language).isNullOrEmpty())
                                continue
//                            if (l.lang == appPrefs!!.pref_search_second_language().get() && selectedResult[1] == null) {
                            if (l.lang == prefs.getString(R.string.pref_search_second_language) && selectedResult[1] == null) {
                                item.language = l.lang
                                item.lyrics = text
                                selectedResult[1] = item
                            }
//                            if (TextUtils.isEmpty(appPrefs!!.pref_search_third_language().get()))
                            if (prefs.getString(R.string.pref_search_second_language).isNullOrEmpty())
                                continue
//                            if (l.lang == appPrefs!!.pref_search_third_language().get() && selectedResult[2] == null) {
                            if (l.lang == prefs.getString(R.string.pref_search_second_language) && selectedResult[2] == null) {
                                item.language = l.lang
                                item.lyrics = text
                                selectedResult[2] = item
                            }
                        }

                        if (selectedResult[0] != null) {
                            resultItem = selectedResult[0]
                            break
                        }
                    } catch (e: LangDetectException) {
                        Logger.e(e)
                    }

                }
                if (resultItem == null)
                    resultItem = selectedResult[1]
                if (resultItem == null)
                    resultItem = selectedResult[2]
            }

            // no lyrics
//            if (resultItem == null && appPrefs!!.pref_search_non_preferred_language().get()) {
            if (resultItem == null && prefs.getBoolean(R.string.pref_search_non_preferred_language, true)) {
                resultItem = itemList[0]
                resultItem.language = null
                resultItem.lyrics = null
            }

        } catch (e: Exception) {
            Logger.d(e)
        }


        return resultItem
    }


    inner class ProfileCreator : Runnable {
        override fun run() {
            try {
                DetectorFactoryUtil.createDetectorAll(applicationContext)
            } catch (e: LangDetectException) {
                Logger.d(e)
            }
        }
    }

    /**
     * Send lyrics info.
     * @param pluginIntent parameters.
     * @param resultItem search result.
     */
    private fun sendLyricsResult(pluginIntent: MediaPluginIntent, resultItem: ResultItem?) {
        val propertyData = PropertyData()
        val fileUri: Uri?
        if (resultItem?.lyricURL != null) {
            fileUri = saveLyricsFile(resultItem) // save lyrics and get uri
            propertyData[LyricsProperty.DATA_URI] = fileUri?.toString()
            propertyData[LyricsProperty.SOURCE_TITLE] = getString(R.string.lyrics_source_name)
            propertyData[LyricsProperty.SOURCE_URI] = resultItem.lyricURL
            applicationContext.grantUriPermission(pluginIntent.srcPackage, fileUri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        sendResult(propertyData)
        val returnIntent = pluginIntent.createResultIntent(propertyData)
        sendBroadcast(returnIntent)
    }

    /**
     * Save lyrics file.
     * @param resultItem Lyrics info.
     * @return Saved lyrics URI.
     */
    private fun saveLyricsFile(resultItem: ResultItem?): Uri? {
        if (resultItem == null)
            return null

        val lyricsBytes = ViewLyricsSearcher.downloadLyricsBytes(resultItem.lyricURL) ?: return null

        // Create folder
        val sharedLyricsDir = File(this.filesDir, SHARED_DIR_NAME)
        if (!sharedLyricsDir.exists()) {

            sharedLyricsDir.mkdir()
        }
        val sharedLyricsFile = File(sharedLyricsDir, SHARED_FILE_NAME)
        FileOutputStream(sharedLyricsFile).use { outputStream ->
            outputStream.write(lyricsBytes)
            outputStream.flush()
        }

        return FileProvider.getUriForFile(this, PROVIDER_AUTHORITIES, sharedLyricsFile)

        // file://
        //        // Create folder
        //        File lyricsDir = new File(getExternalCacheDir(), "lyrics");
        //        if (!lyricsDir.exists()) {
        //            //noinspection ResultOfMethodCallIgnored
        //            lyricsDir.mkdir();
        //        }
        //
        //        // Write lyrics.
        //        File lyricsFile = new File(lyricsDir, "lyrics.txt");
        //        try (FileOutputStream outputStream = new FileOutputStream(lyricsFile)) {
        //            outputStream.write(lyricsBytes);
        //            outputStream.flush();
        //        }
        //
        //        return Uri.fromFile(lyricsFile);
    }

    /**
     * Save lyrics info to cache.
     * @param pluginIntent Parameter.
     * @param resultItem Result item.
     */
    private fun saveCache(pluginIntent: MediaPluginIntent?, resultItem: ResultItem?) {
        if (pluginIntent == null)
            return
        val propertyData = pluginIntent.propertyData ?: return

        val title = propertyData.getFirst(MediaProperty.TITLE)
        val artist = propertyData.getFirst(MediaProperty.ARTIST)
        val searchCacheHelper = SearchCacheHelper(this)
        searchCacheHelper.insertOrUpdate(title!!, artist, resultItem)
    }



    companion object {

        private const val SHARED_DIR_NAME = "lyrics"
        private const val SHARED_FILE_NAME = "lyrics.lrc"
        private const val PROVIDER_AUTHORITIES = BuildConfig.APPLICATION_ID + ".fileprovider"
    }

}

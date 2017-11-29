package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactoryUtil;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.Language;
import com.wa2c.android.medoly.library.LyricsProperty;
import com.wa2c.android.medoly.library.MediaPluginIntent;
import com.wa2c.android.medoly.library.MediaProperty;
import com.wa2c.android.medoly.library.PluginOperationCategory;
import com.wa2c.android.medoly.library.PluginTypeCategory;
import com.wa2c.android.medoly.library.PropertyData;
import com.wa2c.android.medoly.plugin.action.lrclyrics.BuildConfig;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache;
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper;
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.Result;
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem;
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ViewLyricsSearcher;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppPrefs_;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;


/**
 *  Download intent service.
 */
@EIntentService
public class PluginGetLyricsService extends AbstractPluginService {

    private static final String SHARED_DIR_NAME = "lyrics";
    private static final String SHARED_FILE_NAME = "lyrics.lrc";
    private static final String PROVIDER_AUTHORITIES = BuildConfig.APPLICATION_ID + ".fileprovider";

    @Pref
    protected AppPrefs_ appPrefs;


    /**
     * Constructor.
     */
    public PluginGetLyricsService() {
        super(PluginGetLyricsService.class.getSimpleName());
    }


    @ServiceAction
    protected void process(Intent intent) {
        super.process(intent);
        if (intent == null)
            return;

        try {
            getLyrics(pluginIntent);
       } catch (Exception e) {
            Logger.e(e);
            sendResult(null);
            AppUtils.showToast(this, R.string.error_app);
        }
    }

    /**
     * Get lyrics.
     * @param pluginIntent A plugin intent.
     */
    private void getLyrics(MediaPluginIntent pluginIntent) throws SAXException, NoSuchAlgorithmException, ParserConfigurationException, IOException {
        ResultItem resultItem = findLyrics(pluginIntent);
        sendLyricsResult(pluginIntent, resultItem);
        if (resultItem == null) {
            if (appPrefs.pref_failure_message_show().get()) {
                AppUtils.showToast(this, R.string.message_lyrics_failure);
            }
        } else {
            if (appPrefs.pref_success_message_show().get()) {
                AppUtils.showToast(this, R.string.message_lyrics_success);
            }
        }
    }

    /**
     * Get lyrics info.
     * @param pluginIntent Plugin intent.
     * @return lyrics info.
     */
    private ResultItem findLyrics(MediaPluginIntent pluginIntent) throws SAXException, NoSuchAlgorithmException, ParserConfigurationException, IOException {

        // No media data
        PropertyData propertyData = pluginIntent.getPropertyData();
        if (propertyData == null || propertyData.isMediaEmpty()) {
            return null;
        }

        // No property info
        String titleText = propertyData.getFirst(MediaProperty.TITLE);
        String artistText = propertyData.getFirst(MediaProperty.ARTIST);
        if (TextUtils.isEmpty(titleText) || TextUtils.isEmpty(artistText)) {
            return null;
        }


        ResultItem resultItem = null;

        // search cache
        if (appPrefs.pref_use_cache().get()) {
            SearchCacheHelper cacheHelper = new SearchCacheHelper(this);
            SearchCache cache = cacheHelper.select(titleText, artistText);
            if (cache != null) {
                resultItem = cache.makeResultItem();
                if (resultItem == null && appPrefs.pref_cache_non_result().get()) {
                    return null; // returns even if it is null
                }
            }
        }

        // search lyrics
        if (resultItem == null) {

            // detect result item
            resultItem = detectResultItem(titleText, artistText);

            // save to cache.
            if (appPrefs.pref_cache_result().get()) {
                if (resultItem != null) {
                    saveCache(pluginIntent, resultItem);
                } else if (appPrefs.pref_cache_non_result().get()) {
                    saveCache(pluginIntent, null);
                }
            }
        }

        return resultItem;
    }


    private final Thread creatorThread = new Thread(new ProfileCreator());

    /**
     * Detect language.
     * @return result item.
     */
    private ResultItem detectResultItem(String titleText, String artistText) {
        ResultItem resultItem = null;

        try {
            // pre-creation profiles
            if (!TextUtils.isEmpty(appPrefs.pref_search_first_language().get())) {
                synchronized (creatorThread) {
                    creatorThread.start(); // start profiles creating
                }
            }

            // search
            Result result = ViewLyricsSearcher.search(titleText, artistText, 0);

            // sort
            List<ResultItem> itemList = result.getInfoList();
            if (itemList == null || itemList.size() == 0)
                return null;

            Collections.sort(itemList, new Comparator<ResultItem>() {
                @Override
                public int compare(ResultItem o1, ResultItem o2) {
                    // order by rating
                    double o1Rating = o1.getLyricRate();
                    double o2Rating = o2.getLyricRate();
                    if (o1Rating != o2Rating)
                        return -Double.compare(o1Rating, o2Rating);
                    // order by rating count
                    int o1RatingCount = o1.getLyricRatesCount();
                    int o2RatingCount = o2.getLyricRatesCount();
                    if (o1RatingCount != o2RatingCount)
                        return -Integer.compare(o1RatingCount, o2RatingCount);
                    // order by download count
                    int o1Download = o1.getLyricDownloadsCount();
                    int o2Download = o2.getLyricDownloadsCount();
                    return -Integer.compare(o1Download, o2Download);
                }
            });

            // detect language
            if (TextUtils.isEmpty(appPrefs.pref_search_first_language().get())) {
                // not exists preferred language
                resultItem = itemList.get(0);
                resultItem.setLanguage(null);
                resultItem.setLyrics(ViewLyricsSearcher.downloadLyricsText(resultItem.getLyricURL()));
            } else {
                // preferred language
                int threshold = appPrefs.pref_search_language_threshold().get();
                ResultItem[] selectedResult = new ResultItem[3]; // language 0: first, 1:second: 2: third
                for (ResultItem item : itemList) {
                    try {
                        String text = ViewLyricsSearcher.downloadLyricsText(item.getLyricURL());
                        creatorThread.join(); // finish profiles creating

                        Detector detector = DetectorFactoryUtil.createDetectorAll(this);
                        detector.append(text);
                        List<Language> langList = detector.getProbabilities();
                        for (Language l : langList) {
                            if (l.prob * 100 < threshold)
                                continue;
                            if (TextUtils.isEmpty(appPrefs.pref_search_first_language().get()) && selectedResult[0] == null)
                                continue;
                            if (l.lang.equals(appPrefs.pref_search_first_language().get())) {
                                selectedResult[0] = item;
                                selectedResult[0].setLanguage(l.lang);
                                selectedResult[0].setLyrics(text);
                            }
                            if (TextUtils.isEmpty(appPrefs.pref_search_second_language().get()))
                                continue;
                            if (l.lang.equals(appPrefs.pref_search_second_language().get()) && selectedResult[1] == null) {
                                selectedResult[1] = item;
                                selectedResult[1].setLanguage(l.lang);
                                selectedResult[1].setLyrics(text);
                            }
                            if (TextUtils.isEmpty(appPrefs.pref_search_third_language().get()))
                                continue;
                            if (l.lang.equals(appPrefs.pref_search_third_language().get()) && selectedResult[2] == null) {
                                selectedResult[2] = item;
                                selectedResult[2].setLanguage(l.lang);
                                selectedResult[2].setLyrics(text);
                            }
                        }

                        if (selectedResult[0] != null) {
                            resultItem = selectedResult[0];
                            break;
                        }
                    } catch (LangDetectException e) {
                        Logger.e(e);
                    }
                }
                if (resultItem == null)
                    resultItem = selectedResult[1];
                if (resultItem == null)
                    resultItem = selectedResult[2];
            }

            // no lyrics
            if (resultItem == null && appPrefs.pref_search_non_preferred_language().get()) {
                resultItem = itemList.get(0);
                resultItem.setLanguage(null);
                resultItem.setLyrics(null);
            }

        } catch (Exception e) {
            Logger.d(e);
        }


        return resultItem;
    }


    public class ProfileCreator implements Runnable {
        @Override
        public void run() {
            try {
                DetectorFactoryUtil.createDetectorAll(getApplicationContext());
            } catch (LangDetectException e) {
                Logger.d(e);
            }
        }
    }

    /**
     * Send lyrics info.
     * @param pluginIntent parameters.
     * @param resultItem search result.
     */
    private void sendLyricsResult(@NonNull MediaPluginIntent pluginIntent, ResultItem resultItem) throws IOException {
        PropertyData propertyData = new PropertyData();
        Uri fileUri;
        if (resultItem != null && resultItem.getLyricURL() != null) {
            fileUri = saveLyricsFile(resultItem); // save lyrics and get uri
            propertyData.put(LyricsProperty.DATA_URI, (fileUri == null) ? null : fileUri.toString());
            propertyData.put(LyricsProperty.SOURCE_TITLE, getString(R.string.lyrics_source_name));
            propertyData.put(LyricsProperty.SOURCE_URI, resultItem.getLyricURL());
            getApplicationContext().grantUriPermission(pluginIntent.getSrcPackage(), fileUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        sendResult(propertyData);
        MediaPluginIntent returnIntent = pluginIntent.createResultIntent(propertyData);
        sendBroadcast(returnIntent);
    }

    /**
     * Save lyrics file.
     * @param resultItem Lyrics info.
     * @return Saved lyrics URI.
     */
    private Uri saveLyricsFile(ResultItem resultItem) throws IOException {
        if (resultItem == null)
            return null;

        byte[] lyricsBytes = ViewLyricsSearcher.downloadLyricsBytes(resultItem.getLyricURL());
        if (lyricsBytes == null)
            return null;

        // Create folder
        File sharedLyricsDir = new File(this.getFilesDir(), SHARED_DIR_NAME);
        if (!sharedLyricsDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            sharedLyricsDir.mkdir();
        }
        File sharedLyricsFile = new File(sharedLyricsDir, SHARED_FILE_NAME);
        try (FileOutputStream outputStream = new FileOutputStream(sharedLyricsFile)) {
            outputStream.write(lyricsBytes);
            outputStream.flush();
        }

        return FileProvider.getUriForFile(this, PROVIDER_AUTHORITIES, sharedLyricsFile);

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
    private void saveCache(MediaPluginIntent pluginIntent, ResultItem resultItem) {
        if (pluginIntent == null)
            return;
        PropertyData propertyData = pluginIntent.getPropertyData();
        if (propertyData == null)
            return;

        String title = propertyData.getFirst(MediaProperty.TITLE);
        String artist = propertyData.getFirst(MediaProperty.ARTIST);
        SearchCacheHelper searchCacheHelper = new SearchCacheHelper(this);
        searchCacheHelper.insertOrUpdate(title, artist, resultItem);
    }

}

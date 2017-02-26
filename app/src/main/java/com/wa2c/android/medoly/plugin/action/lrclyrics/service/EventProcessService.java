package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.Language;
import com.wa2c.android.medoly.library.LyricsProperty;
import com.wa2c.android.medoly.library.MediaProperty;
import com.wa2c.android.medoly.library.MedolyEnvironment;
import com.wa2c.android.medoly.library.MedolyIntentParam;
import com.wa2c.android.medoly.library.PluginOperationCategory;
import com.wa2c.android.medoly.library.PluginTypeCategory;
import com.wa2c.android.medoly.library.PropertyData;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.activity.SearchActivity;
import com.wa2c.android.medoly.plugin.action.lrclyrics.activity.SearchActivity_;
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
public class EventProcessService extends IntentService {

    private static final String SHARED_DIR_NAME = "lyrics";
    private static final String SHARED_FILE_NAME = "lyrics.lrc";
    private static final String PROVIDER_AUTHORITIES = "com.wa2c.android.medoly.plugin.action.lrclyrics.fileprovider";

    @Pref
    AppPrefs_ appPrefs;

    /**
     * Constructor.
     */
    public EventProcessService() {
        super(EventProcessService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do nothing here

    }

    @ServiceAction
    synchronized void search(Intent intent) {
        MedolyIntentParam param = new MedolyIntentParam(intent);
        try {

            if ((param.hasCategories(PluginOperationCategory.OPERATION_MEDIA_OPEN) && appPrefs.pref_plugin_event().get() == 1) ||
                (param.hasCategories(PluginOperationCategory.OPERATION_PLAY_START) && appPrefs.pref_plugin_event().get() == 2)) {
                // MEDIA_OPEN / PLAY_START
                executeSearch(param);
                return;
            } else if (param.hasCategories(PluginOperationCategory.OPERATION_EXECUTE)) {
                // Execute
                if (param.hasExecuteId("execute_id_get_lyrics")) {
                    // Get Lyrics
                    executeSearch(param);
                    return;
                } else if (param.hasExecuteId("execute_id_search_lyrics")) {
                    // Search lyrics
                    Intent searchIntent =  new Intent(this, SearchActivity_.class);
                    searchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PropertyData propertyData = param.getPropertyData();
                    if (propertyData != null) {
                        searchIntent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, propertyData.getFirst(MediaProperty.TITLE));
                        searchIntent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, propertyData.getFirst(MediaProperty.ARTIST));
                    }
                    startActivity(searchIntent);
                    return;
                }
            }
            sendLyricsResult(param, null);
        } catch (Exception e) {
            Logger.e(e);
            AppUtils.showToast(this, R.string.error_app);

            // Error
            try {
                sendLyricsResult(param, null);
            } catch (Exception e1) {
                Logger.e(e1);
            }
        }
    }

    private boolean executeSearch(MedolyIntentParam param) throws SAXException, NoSuchAlgorithmException, ParserConfigurationException, IOException {
        ResultItem resultItem = getLyrics(param);
        sendLyricsResult(param, resultItem);
        if (resultItem == null) {
            if (appPrefs.pref_failure_message_show().get()) {
                AppUtils.showToast(this, R.string.message_lyrics_failure);
            }
        } else {
            if (appPrefs.pref_success_message_show().get()) {
                AppUtils.showToast(this, R.string.message_lyrics_success);
            }
        }
        return true;
    }

    /**
     * Get lyrics info.
     * @param param parameters.
     * @return lyrics info.
     * @throws SAXException
     * @throws NoSuchAlgorithmException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    private ResultItem getLyrics(MedolyIntentParam param) throws SAXException, NoSuchAlgorithmException, ParserConfigurationException, IOException {
        // media info are not exists
        if (param.getMediaUri() == null) {
            AppUtils.showToast(getApplicationContext(), R.string.message_no_media);
            return null;
        }

        // indispensable info are not exists
        if (param.getPropertyData() == null || TextUtils.isEmpty(param.getPropertyData().getFirst(MediaProperty.TITLE))) {
            return null;
        }

        String title = param.getPropertyData().getFirst(MediaProperty.TITLE);
        String artist = param.getPropertyData().getFirst(MediaProperty.ARTIST);

        ResultItem resultItem = null;

        // search cache
        if (appPrefs.pref_use_cache().get()) {
            SearchCacheHelper cacheHelper = new SearchCacheHelper(this);
            SearchCache cache = cacheHelper.select(title, artist);
            if (cache != null) {
                resultItem = cache.makeResultItem();
                if (resultItem == null && appPrefs.pref_cache_non_result().get()) {
                    return null; // returns even if it is null
                }
            }
        }

        // search lyrics
        if (resultItem == null) {
            // search
            Result result = ViewLyricsSearcher.search(title, artist, 0);

            // detect result item
            resultItem = detectResultItem(result);

            // save to cache.
            if (appPrefs.pref_cache_result().get()) {
                if (resultItem != null) {
                    saveCache(param, resultItem);
                } else if (appPrefs.pref_cache_non_result().get()) {
                    saveCache(param, null);
                }
            }
        }

        return resultItem;
    }


    /**
     * Detect language.
     * @param result result.
     * @return result item.
     */
    private ResultItem detectResultItem(Result result) {
        // sort
        List<ResultItem> itemList = result.getInfoList();
        if (itemList == null || itemList.size() == 0)
            return null;

        ResultItem resultItem = null;
        try {

            Collections.sort(itemList, new Comparator<ResultItem>() {
                @Override
                public int compare(ResultItem o1, ResultItem o2) {
                    // order by rating
                    double o1Rating = o1.getLyricRate();
                    double o2Rating = o2.getLyricRate();
                    if (o1Rating != o2Rating)
                        return Double.compare(o1Rating, o2Rating);
                    // order by rating count
                    int o1RatingCount = o1.getLyricRatesCount();
                    int o2RatingCount = o2.getLyricRatesCount();
                    if (o1RatingCount != o2RatingCount)
                        return Integer.compare(o1RatingCount, o2RatingCount);
                    // order by download count
                    int o1Download = o1.getLyricDownloadsCount();
                    int o2Download = o2.getLyricDownloadsCount();
                    return Integer.compare(o1Download, o2Download);
                }
            });

            // detect language
            if (TextUtils.isEmpty(appPrefs.pref_search_first_language().get())) {
                // not exists preferred language
                resultItem = itemList.get(0);
            } else {
                // preferred language
                int threshold = appPrefs.pref_search_language_threshold().get();
                ResultItem[] selectedResult = new ResultItem[3]; // language 0: first, 1:second: 2: third
                for (ResultItem item : itemList) {
                    try {
                        String text = ViewLyricsSearcher.downloadLyricsText(item.getLyricURL());
                        Detector detector = AppUtils.createDetectorAll(this);
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
                            resultItem.setLanguage(appPrefs.pref_search_first_language().get());
                            break;
                        }
                    } catch (LangDetectException e) {
                        Logger.e(e);
                    }
                }
                if (resultItem == null)
                    resultItem = selectedResult[2];
                if (resultItem == null)
                    resultItem = selectedResult[3];
            }
        } catch (Exception e) {
            Logger.d(e);
        }

        // get non-preferred language
        if (resultItem == null && appPrefs.pref_search_non_preferred_language().get()) {
            resultItem = itemList.get(0);
        }

        return resultItem;
    }


    /**
     * Send lyrics info.
     * @param param parameters.
     * @param resultItem search result.
     */
    private void sendLyricsResult(@NonNull MedolyIntentParam param, ResultItem resultItem) throws IOException {
        PropertyData propertyData = new PropertyData();
        Uri fileUri = null;
        if (resultItem != null && resultItem.getLyricURL() != null) {
            fileUri = saveLyricsFile(resultItem); // save lyrics and get uri
            propertyData.put(LyricsProperty.DATA_URI, (fileUri == null) ? null : fileUri.toString());
            propertyData.put(LyricsProperty.SOURCE_TITLE, getString(R.string.lyrics_source_name));
            propertyData.put(LyricsProperty.SOURCE_URI, resultItem.getLyricURL());
            getApplicationContext().grantUriPermission(param.getSrcPackage(), fileUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        Intent returnIntent = param.createReturnIntent();
        returnIntent.addCategory(PluginTypeCategory.TYPE_PUT_LYRICS.getCategoryValue()); // カテゴリ
        returnIntent.putExtra(MedolyEnvironment.PLUGIN_VALUE_KEY, propertyData);
        returnIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
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
     * @param param Parameter.
     * @param resultItem Result item.
     */
    private void saveCache(MedolyIntentParam param, ResultItem resultItem) {
        if (param == null || param.getPropertyData() == null)
            return;

        String title = param.getPropertyData().getFirst(MediaProperty.TITLE);
        String artist = param.getPropertyData().getFirst(MediaProperty.ARTIST);
        SearchCacheHelper searchCacheHelper = new SearchCacheHelper(this);
        searchCacheHelper.insertOrUpdate(title, artist, resultItem);
    }

}

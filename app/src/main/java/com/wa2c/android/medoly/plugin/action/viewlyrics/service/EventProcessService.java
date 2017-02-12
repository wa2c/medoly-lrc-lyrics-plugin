package com.wa2c.android.medoly.plugin.action.viewlyrics.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
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
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.activity.SearchActivity;
import com.wa2c.android.medoly.plugin.action.viewlyrics.activity.SearchActivity_;
import com.wa2c.android.medoly.plugin.action.viewlyrics.db.SearchCache;
import com.wa2c.android.medoly.plugin.action.viewlyrics.db.SearchCacheHelper;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.Result;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ResultItem;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ViewLyricsSearcher;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppPrefs_;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.Logger;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;


/**
 *  Download intent service.
 */
@EIntentService
public class EventProcessService extends IntentService {

    private SharedPreferences pref;


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
    void search(Intent intent) {
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        MedolyIntentParam param = new MedolyIntentParam(intent);
        try {

            if ((param.hasCategories(PluginOperationCategory.OPERATION_MEDIA_OPEN) && appPrefs.prefPluginEvent().get() == 1) ||
                (param.hasCategories(PluginOperationCategory.OPERATION_PLAY_START) && appPrefs.prefPluginEvent().get() == 2)) {
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
        if (resultItem == null) {
            if (pref.getBoolean(getString(R.string.prefkey_failure_message_show), false)) {
                AppUtils.showToast(this, R.string.message_lyrics_failure);
            }
        }
        sendLyricsResult(param, resultItem);
        if (pref.getBoolean(getString(R.string.prefkey_success_message_show), false)) {
            AppUtils.showToast(this, R.string.message_lyrics_success);
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
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

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

        // use cache
        if (appPrefs.pref_use_cache().get()) {
            SearchCacheHelper cacheHelper = new SearchCacheHelper(this);
            SearchCache cache = cacheHelper.select(title, artist);
            if (cache != null) {
                resultItem = cache.getResultItem();
            }
        }

        // search lyrics
        if (resultItem == null) {
            // search
            Result result = ViewLyricsSearcher.search(title, artist, 0);

            // sort
            List<ResultItem> itemList= result.getInfoList();
            Collections.sort(itemList, new Comparator<ResultItem>() {
                @Override
                public int compare(ResultItem o1, ResultItem o2) {
                    double o1Rating = o1.getLyricRate();
                    double o2Rating = o2.getLyricRate();
                    if (o1Rating != o2Rating)
                        return Double.compare(o1Rating, o2Rating);

                    int o1RatingCount = o1.getLyricRatesCount();
                    int o2RatingCount = o2.getLyricRatesCount();
                    if (o1RatingCount != o2RatingCount)
                        return Integer.compare(o1RatingCount, o2RatingCount);

                    int o1Download = o1.getLyricDownloadsCount();
                    int o2Download = o2.getLyricDownloadsCount();
                    return Integer.compare(o1Download, o2Download);
                }
            });

            // detect language
            for (ResultItem item : result.getInfoList()) {
                try {
                    String text = ViewLyricsSearcher.downloadLyricsText(item.getLyricURL());

                    Language lang = detectLanguage(text);
                    if (lang == null)
                        continue;
                    Locale locale = new Locale(lang.lang);
                    if (Locale.JAPANESE.equals(locale)) {
                        item.setLyrics(text);
                        resultItem = item;
                        break;
                    }
                } catch (LangDetectException e) {
                    Logger.e(e);
                }
            }

            // set first item if not found
            if (resultItem == null && result.getInfoList().size() > 0)
                resultItem = result.getInfoList().get(0);

            // save to cache.
            if (resultItem != null && appPrefs.pref_cache_event().get()) {
                saveCache(param, Locale.JAPAN, resultItem);
            }
        }


        return resultItem;
    }


    /**
     * Detect language.
     * @param lyricsText Lyrics text.
     * @return Language
     */
    private Language detectLanguage(String lyricsText) throws LangDetectException {
        Detector detector = AppUtils.createDetector(this);
        detector.append(lyricsText);
        ArrayList<Language> languages = detector.getProbabilities();
        if (languages != null && languages.size() != 0)
            return languages.get(0);
        else
            return null;
    }


    /**
     * Send lyrics info.
     * @param param parameters.
     * @param resultItem search result.
     */
    private void sendLyricsResult(@NonNull MedolyIntentParam param, ResultItem resultItem) throws IOException {
        PropertyData propertyData = new PropertyData();
        if (resultItem != null && resultItem.getLyricURL() != null) {
            Uri fileUri = saveLyricsFile(resultItem); // save lyrics and get uri
            propertyData.put(LyricsProperty.DATA_URI, (fileUri == null) ? null : fileUri.toString());
            propertyData.put(LyricsProperty.SOURCE_TITLE, getString(R.string.lyrics_source_name));
            propertyData.put(LyricsProperty.SOURCE_URI, resultItem.getLyricURL());
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
        File lyricsDir = new File(getExternalCacheDir(), "lyrics");
        if (!lyricsDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            lyricsDir.mkdir();
        }

        // Write lyrics.
        File lyricsFile = new File(lyricsDir, "lyrics.txt");
        try (FileOutputStream outputStream = new FileOutputStream(lyricsFile)) {
            outputStream.write(lyricsBytes);
            outputStream.flush();
        }

        return Uri.fromFile(lyricsFile);
    }

    /**
     * Save lyrics info to cache.
     * @param param Parameter.
     * @param locale Locale.
     * @param resultItem Result item.
     */
    private void saveCache(MedolyIntentParam param, Locale locale,  ResultItem resultItem) {
        if (param == null || param.getPropertyData() == null || resultItem == null)
            return;

        String title = param.getPropertyData().getFirst(MediaProperty.TITLE);
        String artist = param.getPropertyData().getFirst(MediaProperty.ARTIST);
        SearchCacheHelper searchCacheHelper = new SearchCacheHelper(this);
        searchCacheHelper.insertOrUpdate(title, artist, locale, resultItem);
    }

}

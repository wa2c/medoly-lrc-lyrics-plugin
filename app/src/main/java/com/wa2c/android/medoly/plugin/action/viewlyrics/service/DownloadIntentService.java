package com.wa2c.android.medoly.plugin.action.viewlyrics.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.wa2c.android.medoly.library.LyricsProperty;
import com.wa2c.android.medoly.library.MediaProperty;
import com.wa2c.android.medoly.library.MedolyEnvironment;
import com.wa2c.android.medoly.library.MedolyIntentParam;
import com.wa2c.android.medoly.library.PluginOperationCategory;
import com.wa2c.android.medoly.library.PluginTypeCategory;
import com.wa2c.android.medoly.library.PropertyData;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.activity.MainActivity;
import com.wa2c.android.medoly.plugin.action.viewlyrics.activity.SearchActivity;
import com.wa2c.android.medoly.plugin.action.viewlyrics.activity.SearchActivity_;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.Result;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ResultItem;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ViewLyricsSearcher;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.Logger;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;
import org.xml.sax.SAXException;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;


/**
 *  Download intent service.
 */
@EIntentService
public class DownloadIntentService extends IntentService {
    /** 前回のファイルパス設定キー。 */
    private static final String PREFKEY_PREVIOUS_MEDIA_URI = "previous_media_uri";
    /** 前回の歌詞テキスト設定キー。 */
    private static final String PREFKEY_PREVIOUS_LYRICS_TEXT = "previous_lyrics_text";
    /** 前回のサイトタイトル設定キー。 */
    private static final String PREFKEY_PREVIOUS_SITE_TITLE = "previous_site_text";
    /** 前回のサイトURI設定キー。 */
    private static final String PREFKEY_PREVIOUS_SITE_URI = "previous_site_uri";



    /**
     * Constructor.
     */
    public DownloadIntentService() {
        super(DownloadIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do nothing here
    }

    @ServiceAction
    void search(Intent intent) {
        MedolyIntentParam param = null;
        try {
            param = new MedolyIntentParam(intent);
            if (param.hasCategories(PluginOperationCategory.OPERATION_MEDIA_OPEN)) {
//                // Open
//                if (!param.isEvent() || sharedPreferences.getBoolean(getApplicationContext().getString(R.string.prefkey_operation_media_open_enabled), false)) {
//                    downloadLyrics(param);
//                    return;
//                }
            } else if (param.hasCategories(PluginOperationCategory.OPERATION_EXECUTE)) {
                // Execute
                if (param.hasExecuteId("execute_id_get_lyrics")) {
                    // Get Lyrics
                    searchLyrics(param);
                    return;
                } else if (param.hasExecuteId("execute_id_search_lyrics")) {


                    // Get Lyrics
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
            sendLyricsResult(param, Uri.EMPTY);
        } catch (Exception e) {
            Logger.e(e);
            AppUtils.showToast(this, R.string.error_app);
            sendLyricsResult(param, null);
        }

    }


    @ServiceAction
    void searchLyrics(MedolyIntentParam param) {

        // 音楽データ無し
        if (param.getMediaUri() == null) {
            AppUtils.showToast(getApplicationContext(), R.string.message_no_media);
            sendLyricsResult(param, Uri.EMPTY);
            return;
        }

        // 必須情報無し
        if (param.getPropertyData() == null) {
            sendLyricsResult(param, null);
            return;
        }
        String title = param.getPropertyData().getFirst(MediaProperty.TITLE);
        String artist = param.getPropertyData().getFirst(MediaProperty.ARTIST);
        if ( (TextUtils.isEmpty(title) && TextUtils.isEmpty(artist)) ) {
            sendLyricsResult(param, null);
            return;
        }


//        // 前回メディア確認
//        final String mediaUriText = param.getMediaUri().toString();
//        final String previousMediaUri = sharedPreferences.getString(PREFKEY_PREVIOUS_MEDIA_URI, "");
//        boolean previousMediaEnabled = sharedPreferences.getBoolean(getApplicationContext().getString(R.string.prefkey_previous_media_enabled), false);
//        if (!previousMediaEnabled && !TextUtils.isEmpty(mediaUriText) && !TextUtils.isEmpty(previousMediaUri) && mediaUriText.equals(previousMediaUri)) {
//            // 前回と同じメディアは保存データを返す
//            String lyrics = sharedPreferences.getString(PREFKEY_PREVIOUS_LYRICS_TEXT, null);
//            String title = sharedPreferences.getString(PREFKEY_PREVIOUS_SITE_TITLE, null);
//            String uri = sharedPreferences.getString(PREFKEY_PREVIOUS_SITE_URI, null);
//            sendLyricsResult(param, getLyricsUri(lyrics), title, uri);
//            return;
//        }


        try {
            // 検索
            Result result = ViewLyricsSearcher.search(title, artist, 0);
            if (result.getInfoList().size() == 0) {
                sendLyricsResult(param, null);
                return;
            }

            // ファイル保存
            ResultItem info = result.getInfoList().get(0);
            Uri uri = saveLyricsFile(info);
            sendLyricsResult(param, uri, "ViewLyrics.com", info.getLyricURL());
        } catch (IOException | NoSuchAlgorithmException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Uri saveLyricsFile(ResultItem info) throws IOException {
        HttpURLConnection con;
        final URL url = new URL(info.getLyricURL());
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        final int status = con.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            final InputStream inputStream = con.getInputStream();

            // フォルダ作成
            File lyricsDir = new File(getExternalCacheDir(), "lyrics");
            if (!lyricsDir.exists()) {
                //noinspection ResultOfMethodCallIgnored
                lyricsDir.mkdir();
            }
            File lyricsFile = new File(lyricsDir, "lyrics.txt");


            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            while(true) {
                int len = inputStream.read(buffer);
                if(len < 0) {
                    break;
                }
                bout.write(buffer, 0, len);
            }
            byte[] lyricsBytes = bout.toByteArray();

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(lyricsFile);
                outputStream.write(lyricsBytes);
                outputStream.flush();
                return Uri.fromFile(lyricsFile);
            } finally {
                if (outputStream != null)
                    outputStream.close();
            }


//
//
//            final OutputStream outputStream = new FileOutputStream(lyricsFile);
//            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
//            int size = -1;
//            while (-1 != (size = inputStream.read(buffer))) {
//                outputStream.write(buffer, 0, size);
//            }
//
//
//
//            PrintWriter pw = null;
//            try {
//                pw = new PrintWriter(new BufferedWriter(new FileWriter(lyricsFile)));
//                pw.println(lyrics);
//                return Uri.fromFile(lyricsFile);
//            } catch(Exception e) {
//                Logger.e(e);
//                return null;
//            } finally {
//                if (pw != null)
//                    pw.close();
//            }
//
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                builder.append(line).append(System.getProperty("line.separator"));
//            }
//            reader.close();
        }
        return null;
    }



    /**
     * 歌詞の取得を開始。
     * @param intent インテント。
     */
    private synchronized void startScraping(final Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        MedolyIntentParam param = null;

        try {
            param = new MedolyIntentParam(intent);
            if (param.hasCategories(PluginOperationCategory.OPERATION_MEDIA_OPEN)) {
                // Open
                if (!param.isEvent() || sharedPreferences.getBoolean(getApplicationContext().getString(R.string.prefkey_operation_media_open_enabled), false)) {
                    downloadLyrics(param);
                    return;
                }
            } else if (param.hasCategories(PluginOperationCategory.OPERATION_EXECUTE)) {
               // Execute
                if (param.hasExecuteId("execute_id_get_lyrics")) {
                    // Get Lyrics
                    downloadLyrics(param);
                    return;
               }
            }
            sendLyricsResult(param, Uri.EMPTY);
        } catch (Exception e) {
            AppUtils.showToast(this, R.string.error_app);
            sendLyricsResult(param, null);
        }
    }

    /**
     * 歌詞取得。
     */
    private void downloadLyrics(final MedolyIntentParam param) {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // 音楽データ無し
        if (param.getMediaUri() == null) {
            AppUtils.showToast(getApplicationContext(), R.string.message_no_media);
            sendLyricsResult(param, Uri.EMPTY);
            return;
        }

        // 必須情報無し
        if (param.getPropertyData() == null ||
            param.getPropertyData().isEmpty(MediaProperty.TITLE) ||
            param.getPropertyData().isEmpty(MediaProperty.ARTIST)) {
            sendLyricsResult(param, null);
            return;
        }

        // 前回メディア確認
        final String mediaUriText = param.getMediaUri().toString();
        final String previousMediaUri = sharedPreferences.getString(PREFKEY_PREVIOUS_MEDIA_URI, "");
        boolean previousMediaEnabled = sharedPreferences.getBoolean(getApplicationContext().getString(R.string.prefkey_previous_media_enabled), false);
        if (!previousMediaEnabled && !TextUtils.isEmpty(mediaUriText) && !TextUtils.isEmpty(previousMediaUri) && mediaUriText.equals(previousMediaUri)) {
            // 前回と同じメディアは保存データを返す
            String lyrics = sharedPreferences.getString(PREFKEY_PREVIOUS_LYRICS_TEXT, null);
            String title = sharedPreferences.getString(PREFKEY_PREVIOUS_SITE_TITLE, null);
            String uri = sharedPreferences.getString(PREFKEY_PREVIOUS_SITE_URI, null);
            sendLyricsResult(param, getLyricsUri(lyrics), title, uri);
            return;
        }

        try {

            Result result = ViewLyricsSearcher.search(
                    param.getPropertyData().getFirst(MediaProperty.ARTIST),
                    param.getPropertyData().getFirst(MediaProperty.TITLE),
                    0);

            List<ResultItem> infoList = result.getInfoList();
            for (ResultItem info : infoList) {
                Logger.d(info.getMusicTitle());
            }

//            // 歌詞取得
//            LyricsObtainClient obtainClient = new LyricsObtainClient(getApplicationContext(), param.getPropertyData());
//            obtainClient.obtainLyrics(new LyricsObtainClient.LyricsObtainListener() {
//                @Override
//                public void onLyricsObtain(String lyrics, String title, String uri) {
//                    // 送信
//                    sharedPreferences.edit().putString(PREFKEY_PREVIOUS_MEDIA_URI, param.getMediaUri().toString()).apply();
//                    sharedPreferences.edit().putString(PREFKEY_PREVIOUS_LYRICS_TEXT, lyrics).apply();
//                    sharedPreferences.edit().putString(PREFKEY_PREVIOUS_SITE_TITLE, title).apply();
//                    sharedPreferences.edit().putString(PREFKEY_PREVIOUS_SITE_URI, uri).apply();
//                    sendLyricsResult(param, getLyricsUri(lyrics), title, uri);
//                }
//            });
        } catch (Exception e) {
            Logger.e(e);
            sendLyricsResult(param, null);
        }

    }

    /**
     * 歌詞を保存したファイルのURIを取得する。
     * @param lyrics 歌詞テキスト。
     * @return 歌詞ファイルのURI。
     */
    private Uri getLyricsUri(String lyrics) {
        if (TextUtils.isEmpty(lyrics)) {
            return null;
        }

        // フォルダ作成
        File lyricsDir = new File(getExternalCacheDir(), "lyrics");
        if (!lyricsDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            lyricsDir.mkdir();
        }

        // ファイル作成、URL取得
        File lyricsFile = new File(lyricsDir, "lyrics.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(lyricsFile)));
            pw.println(lyrics);
            return Uri.fromFile(lyricsFile);
        } catch(Exception e) {
            Logger.e(e);
            return null;
        } finally {
            if (pw != null)
                pw.close();
        }
    }



    /**
     * 歌詞を送り返す。
     * @param param 送信元パラメータ。
     * @param lyricsUri 歌詞データのURI。取得できない場合はUri.EMPTY、取得失敗の場合はnull (メッセージ有り)。
     */
    private void sendLyricsResult(MedolyIntentParam param, Uri lyricsUri) {
        sendLyricsResult(param, lyricsUri, null, null);
    }

    /**
     * 歌詞を送り返す。
     * @param param 送信元パラメータ。
     * @param lyricsUri 歌詞データのURI。無視の場合はUri.EMPTY、取得失敗の場合はnull (メッセージ有り)。
     * @param siteTitle サイトのタイトル。
     * @param siteUri  サイトのURI。
     */
    private void sendLyricsResult(MedolyIntentParam param, Uri lyricsUri, String siteTitle, String siteUri) {
        if (param == null)
            return;

        PropertyData propertyData = new PropertyData();
        propertyData.put(LyricsProperty.DATA_URI, (lyricsUri == null) ? null : lyricsUri.toString());
        propertyData.put(LyricsProperty.SOURCE_TITLE, siteTitle);
        propertyData.put(LyricsProperty.SOURCE_URI, siteUri);

        Intent returnIntent = param.createReturnIntent();
        returnIntent.addCategory(PluginTypeCategory.TYPE_PUT_LYRICS.getCategoryValue()); // カテゴリ
        returnIntent.putExtra(MedolyEnvironment.PLUGIN_VALUE_KEY, propertyData);
        returnIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        sendBroadcast(returnIntent);

        // Message
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (lyricsUri != null) {
            if (lyricsUri == Uri.EMPTY)
                return; // EMPTYは無視
            if (pref.getBoolean(getString(R.string.prefkey_success_message_show), false)) {
                AppUtils.showToast(this, R.string.message_lyrics_success);
            }
        } else {
            if (pref.getBoolean(getString(R.string.prefkey_failure_message_show), false)) {
                AppUtils.showToast(this, R.string.message_lyrics_failure);
            }
        }
    }
}

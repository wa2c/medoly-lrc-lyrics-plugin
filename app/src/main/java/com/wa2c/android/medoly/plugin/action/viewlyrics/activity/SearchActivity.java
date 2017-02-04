package com.wa2c.android.medoly.plugin.action.viewlyrics.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.Language;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.db.SearchCacheHelper;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.Result;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ResultItem;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ViewLyricsSearcher;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.Logger;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Search Activity.
 */
@EActivity(R.layout.activity_search)
@OptionsMenu(R.menu.activity_search)
public class SearchActivity extends Activity {

    private static final int REQUEST_CODE_SAVE_FILE = 1;
    public static final String INTENT_SEARCH_TITLE = "INTENT_SEARCH_TITLE";
    public static final String INTENT_SEARCH_ARTIST = "INTENT_SEARCH_ARTIST";

    /** Search list adapter. */
    private SearchResultAdapter searchResultAdapter;
    /** Search cache helper. */
    private SearchCacheHelper searchCacheHelper;
    /** Selected ResultItem object. */
    private ResultItem currentResultItem;

    /** Language names. */
    private String[] languageNames;
    /** Language profiles. */
    private String[] languageProfiles;

    @Extra(INTENT_SEARCH_TITLE)
    String intentSearchTitle;
    @Extra(INTENT_SEARCH_ARTIST)
    String intentSearchArtist;

    /**
     * Get language names.
     * @return language names.
     */
    private synchronized String[] getLanguageNames() {
        if (this.languageNames == null)
            this.languageNames = getResources().getStringArray(R.array.language_names);
        return this.languageNames;
    }

    /**
     * Get language profiles.
     * @return language profiles.
     */
    private synchronized  String[] getLanguageProfiels() {
        if (this.languageProfiles == null)
            this.languageProfiles = getResources().getStringArray(R.array.language_profiles);
        return this.languageProfiles;
    }


    @ViewById
    Button searchTitleButton;
    @ViewById
    EditText searchTitleEditText;
    @ViewById
    Button searchArtistButton;
    @ViewById
    EditText searchArtistEditText;
    @ViewById
    ImageButton searchClearButton;
    @ViewById
    ImageButton searchStartButton;
    @ViewById
    ListView searchResultListView;
    @ViewById
    TextView searchLyricsTextView;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @AfterViews
    void afterViews() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        searchCacheHelper = new SearchCacheHelper(this);
        searchResultAdapter = new SearchResultAdapter(this);
        searchResultListView.setAdapter(searchResultAdapter);

        searchTitleEditText.setText(intentSearchTitle);
        searchArtistEditText.setText(intentSearchArtist);
    }

    @OptionsItem(android.R.id.home)
    void menuHomeClick() {
        startActivity(new Intent(this, MainActivity_.class));
    }

    @OptionsItem(R.id.menu_search_save_file)
    void menuSaveFileClick() {
        if (!existsLyrics()) {
            AppUtils.showToast(this, R.string.error_exists_lyrics);
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TITLE, currentResultItem.getMusicTitle() + ".lrc");
        startActivityForResult(intent, REQUEST_CODE_SAVE_FILE);
    }

    @OptionsItem(R.id.menu_search_save_cache)
    void menuSaveCacheClick() {
        if (!existsLyrics()) {
            AppUtils.showToast(this, R.string.error_exists_lyrics);
            return;
        }

        String title = searchTitleEditText.getText().toString();
        String artist = searchArtistEditText.getText().toString();
        saveBackground(title, artist, currentResultItem);
    }

    @OptionsItem(R.id.menu_search_open_cache)
    void menuOpenCacheClick() {
        Intent intent = new Intent(this, CacheActivity_.class);
        intent.putExtra(CacheActivity.INTENT_SEARCH_TITLE, searchTitleEditText.getText().toString());
        intent.putExtra(CacheActivity.INTENT_SEARCH_ARTIST, searchArtistEditText.getText().toString());
        startActivity(intent);
    }

    @Background
    void saveBackground(String title, String artist, ResultItem item) {
        Locale locale = Locale.getDefault();
        try {
            // Language profile
            if (DetectorFactory.getLangList() == null || DetectorFactory.getLangList().size() == 0) {
                // initialize
                DetectorFactory.clear();
                DetectorFactory.loadProfile(Arrays.asList(getLanguageProfiels()));
            }
            Detector detector = DetectorFactory.create();
            detector.append(item.getLyrics());
            ArrayList<Language> languages = detector.getProbabilities();
            if (languages != null || languages.size() != 0)
                locale = new Locale(languages.get(0).lang);
        } catch (LangDetectException e) {
            Logger.e(e);
        }

        if (searchCacheHelper.insertOrUpdate(title, artist, locale, item))
            AppUtils.showToast(this, R.string.message_save_cache);
    }

    @Click(R.id.searchTitleButton)
    void searchTitleButtonClick(View view) {

    }

    @Click(R.id.searchArtistButton)
    void searchArtistButtonClick(View view) {

    }

    @Click(R.id.searchClearButton)
    void searchClearButtonClick(View view) {
        searchTitleEditText.setText(null);
        searchArtistEditText.setText(null);
    }

    @Click(R.id.searchStartButton)
    void searchStartButtonClick(View view) {
        // Hide keyboard
        InputMethodManager inputMethodMgr = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodMgr.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        // Clear view
        showSearchResult(null);
        showLyrics(null);

        String title = searchTitleEditText.getText().toString();
        String artist = searchArtistEditText.getText().toString();
        searchLyrics(title, artist);
    }

    @ItemClick(R.id.searchResultListView)
    void searchResultListViewItemClick(ResultItem item) {
        currentResultItem = null;
        downloadLyrics(item);
        currentResultItem = item;
    }

    @Background
    void searchLyrics(String title, String artist) {
        try {
            Result result = ViewLyricsSearcher.search(title, artist, 0);
            showSearchResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void showSearchResult(Result result) {
        searchResultAdapter.clear();
        if (result != null)
            searchResultAdapter.addAll(result.getInfoList());
        searchResultAdapter.notifyDataSetChanged();
    }

    @Background
    void downloadLyrics(ResultItem info) {
        StringBuilder builder = new StringBuilder();
        HttpURLConnection con;
        try {
            final URL url = new URL(info.getLyricURL());
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                final InputStream inputStream = con.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append(System.getProperty("line.separator"));
                }
                reader.close();
            }
            info.setLyrics(builder.toString());
            showLyrics(info.getLyrics());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void showLyrics(CharSequence lyrics) {
        if (lyrics != null) {
            searchLyricsTextView.setText(lyrics);
        } else {
            searchLyricsTextView.setText(null);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == REQUEST_CODE_SAVE_FILE) {
            // 歌詞のファイル保存
            if (resultCode == RESULT_OK) {
                if (!existsLyrics()) {
                    AppUtils.showToast(this, R.string.error_exists_lyrics);
                    return;
                }

                Uri uri = resultData.getData();
                try (OutputStream stream = getContentResolver().openOutputStream(uri);
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream,  "UTF-8"))) {
                    writer.write(currentResultItem.getLyrics());
                    writer.flush();
                    AppUtils.showToast(this, R.string.message_lyrics_save_succeeded);
                } catch (IOException e) {
                    Logger.e(e);
                    AppUtils.showToast(this, R.string.message_lyrics_save_failed);
                }
            }
        }

        // Hide keyboard
        InputMethodManager inputMethodMgr = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodMgr.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Check existence of lyrics
     * @return true if exists lyrics.
     */
    private synchronized boolean existsLyrics() {
        return (currentResultItem != null) && !TextUtils.isEmpty(currentResultItem.getLyricURL());
    }

    /**
     * Search result adapter.
     */
    private static class SearchResultAdapter extends ArrayAdapter<ResultItem> {

        SearchResultAdapter(Context context) {
            super(context, R.layout.layout_search_item);
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, @NonNull final ViewGroup parent) {
            // ビュー作成
            final ListItemViewHolder holder;
            if (convertView == null) {
                final View view = View.inflate(parent.getContext(), R.layout.layout_search_item, null);
                holder = new ListItemViewHolder();
                holder.searchItemTitleTextView  = (TextView)view.findViewById(R.id.searchItemTitleTextView);
                holder.searchItemArtistTextView = (TextView)view.findViewById(R.id.searchItemArtistTextView);
                holder.searchItemAlbumTextView  = (TextView)view.findViewById(R.id.searchItemAlbumTextView);
                holder.searchItemDownloadTextView = (TextView)view.findViewById(R.id.searchItemDownloadTextView);
                holder.searchItemRatingTextView = (TextView)view.findViewById(R.id.searchItemRatingTextView);
                holder.searchItemFromTextView   = (TextView)view.findViewById(R.id.searchItemFromTextView);
//                holder.searchItemUrlTextView    = (TextView)view.findViewById(R.id.searchItemUrlTextView);
                view.setTag(holder);
                convertView = view;
            } else {
                holder = (ListItemViewHolder) convertView.getTag();
            }

            // データ設定
            ResultItem item = getItem(position);
            if (item == null)
                item = new ResultItem();
            holder.searchItemTitleTextView.setText(item.getMusicTitle());
            holder.searchItemArtistTextView.setText(AppUtils.nvl(item.getMusicArtist(), "-"));
            holder.searchItemAlbumTextView.setText(AppUtils.nvl(item.getMusicAlbum(), "-"));
            holder.searchItemDownloadTextView.setText("Download:" + String.valueOf(item.getLyricDownloadsCount()));
            holder.searchItemRatingTextView.setText("Rate:" + String.valueOf(item.getLyricRate()) + "(" + String.valueOf(item.getLyricRatesCount()) + ")" );
            holder.searchItemFromTextView.setText("From:" + item.getLyricUploader());
//            holder.searchItemUrlTextView.setText(item.getLyricURL());

            return convertView;
        }

    }

    /** リスト項目のビュー情報を保持するHolder。 */
    private static class ListItemViewHolder {
        TextView searchItemTitleTextView;
        TextView searchItemArtistTextView;
        TextView searchItemAlbumTextView;
        TextView searchItemDownloadTextView;
        TextView searchItemRatingTextView;
        TextView searchItemFromTextView;
//        TextView searchItemUrlTextView;
    }

}

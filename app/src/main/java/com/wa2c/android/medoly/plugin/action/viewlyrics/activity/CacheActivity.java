package com.wa2c.android.medoly.plugin.action.viewlyrics.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.db.SearchCache;
import com.wa2c.android.medoly.plugin.action.viewlyrics.db.SearchCacheHelper;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ResultItem;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@EActivity(R.layout.activity_cache)
@OptionsMenu(R.menu.activity_cache)
public class CacheActivity extends Activity {

    public static final String INTENT_SEARCH_TITLE = "INTENT_SEARCH_TITLE";
    public static final String INTENT_SEARCH_ARTIST = "INTENT_SEARCH_ARTIST";

    /** Search list adapter. */
    private CacheAdapter cacheAdapter;
    /** Search cache helper. */
    private SearchCacheHelper searchCacheHelper;
    /** SearchCache list. */
    private List<SearchCache> cacheList = new ArrayList<>();

    @Extra(INTENT_SEARCH_TITLE)
    String intentSearchTitle;
    @Extra(INTENT_SEARCH_ARTIST)
    String intentSearchArtist;

    @ViewById
    EditText cacheTitleEditText;
    @ViewById
    EditText cacheArtistEditText;
    @ViewById
    ListView cacheListView;

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
        cacheAdapter = new CacheAdapter(this);
        cacheListView.setAdapter(cacheAdapter);

        cacheTitleEditText.setText(intentSearchTitle);
        cacheArtistEditText.setText(intentSearchArtist);
    }

    @OptionsItem(android.R.id.home)
    void menuHomeClick() {
        startActivity(new Intent(this, MainActivity_.class));
    }

    @OptionsItem(R.id.menu_cache_delete)
    void menuDeleteClick() {
        if (cacheAdapter.getCheckedSet().size() == 0) {
            AppUtils.showToast(this, R.string.error_delete_cache_check);
            return;
        }
        deleteCache(cacheAdapter.getCheckedSet());
    }

    @OptionsItem(R.id.menu_cache_open_search)
    void menuOpenCacheClick() {
        Intent intent = new Intent(this, SearchActivity_.class);
        intent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, cacheTitleEditText.getText().toString());
        intent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, cacheArtistEditText.getText().toString());
        startActivity(intent);
    }

    @Background
    void deleteCache(Collection<SearchCache> caches) {
        if (searchCacheHelper.delete(cacheAdapter.getCheckedSet())) {
            cacheList.removeAll(caches);
            AppUtils.showToast(this, R.string.message_delete_cache);
            showCacheList();
        }
    }


    @Click(R.id.cacheInputClearButton)
    void cacheInputClearButtonClick() {
        cacheTitleEditText.setText(null);
        cacheArtistEditText.setText(null);
    }

    @Click(R.id.cacheInputSearchButton)
    void cacheInputSearchButtonClick(View view) {
        // Hide keyboard
        InputMethodManager inputMethodMgr = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodMgr.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        String title = cacheTitleEditText.getText().toString();
        String artist = cacheArtistEditText.getText().toString();
        searchCache(title, artist);
    }

    @ItemClick(R.id.cacheListView)
    void cacheListViewItemClick(SearchCache item) {

    }

    @Background
    void searchCache(String title, String artist) {
        try {
            cacheList = searchCacheHelper.search(title, artist);
            showCacheList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void showCacheList() {
        cacheAdapter.clear();
        cacheAdapter.addAll(cacheList);
        cacheAdapter.notifyDataSetChanged();
    }



    /**
     * Search result adapter.
     */
    private static class CacheAdapter extends ArrayAdapter<SearchCache> {

        CacheAdapter(Context context) {
            super(context, R.layout.layout_search_item);
        }

        private HashSet<SearchCache> checkedSet = new HashSet<>();

        /**
         * Get checked item positions.
         * @return Checked position.
         */
        public HashSet<SearchCache> getCheckedSet() {
            return checkedSet;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, @NonNull final ViewGroup parent) {
            // view
            final ListItemViewHolder holder;
            if (convertView == null) {
                final View view = View.inflate(parent.getContext(), R.layout.layout_cache_item, null);
                holder = new ListItemViewHolder();
                holder.checkBox = (CheckBox)view.findViewById(R.id.cacheCheckBox);
                holder.titleTextView  = (TextView)view.findViewById(R.id.cacheItemTitleTextView);
                holder.artistTextView = (TextView)view.findViewById(R.id.cacheItemArtistTextView);
                holder.fromTextView  = (TextView)view.findViewById(R.id.cacheItemFromTextView);
                holder.fileTextView = (TextView)view.findViewById(R.id.cacheItemFileTextView);
                holder.langTextView = (TextView)view.findViewById(R.id.cacheItemLangTextView);
                view.setTag(holder);
                convertView = view;
            } else {
                holder = (ListItemViewHolder) convertView.getTag();
            }

            // data
            final SearchCache item = getItem(position);
            holder.checkBox.setChecked(checkedSet.contains(item));
            holder.titleTextView.setText("Title:" + AppUtils.nvl(item.title, ""));
            holder.artistTextView.setText("Artist:" + AppUtils.nvl(item.artist, ""));
            holder.fromTextView.setText("From:" + AppUtils.nvl(item.from, "-"));
            holder.fileTextView.setText("Name:" + AppUtils.nvl(item.file_name, "-"));
            holder.langTextView.setText("Lang:" + AppUtils.nvl(item.language, "-"));

            // event
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        checkedSet.add(item);
                    else
                        checkedSet.remove(item);
                }
            });

            return convertView;
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            checkedSet.clear();
        }

    }

    /** List item view holder. */
    private static class ListItemViewHolder {
        CheckBox checkBox;
        TextView titleTextView;
        TextView artistTextView;
        TextView fromTextView;
        TextView fileTextView;
        TextView langTextView;
    }


}

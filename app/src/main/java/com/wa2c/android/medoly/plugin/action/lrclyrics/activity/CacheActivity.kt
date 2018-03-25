package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.CacheDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.ConfirmDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Prefs
import kotlinx.android.synthetic.main.activity_cache.*
import kotlinx.android.synthetic.main.layout_cache_item.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.*

/**
 * Cache activity
 */
class CacheActivity : Activity() {

    /** Search list adapter.  */
    private lateinit var cacheAdapter: CacheAdapter
    /** Search cache helper.  */
    private lateinit var searchCacheHelper: SearchCacheHelper
    /** Preferences.  */
    private lateinit var prefs: Prefs
    /** Current cache item. */
    private var currentCacheItem: SearchCache? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
        prefs = Prefs(this)

        // Action Bar
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)

        searchCacheHelper = SearchCacheHelper(this)
        cacheAdapter = CacheAdapter(this)
        cacheListView.adapter = cacheAdapter

        cacheTitleEditText.setText(intent.getStringExtra(INTENT_SEARCH_TITLE))
        cacheArtistEditText.setText(intent.getStringExtra(INTENT_SEARCH_ARTIST))

        cacheInputClearButton.setOnClickListener {
            cacheTitleEditText.text = null
            cacheArtistEditText.text = null
        }

        cacheInputSearchButton.setOnClickListener {
            // Hide keyboard
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            val title = cacheTitleEditText.text.toString()
            val artist = cacheArtistEditText.text.toString()


            searchCache(title, artist)
            cacheTitleEditText.tag = title
            cacheArtistEditText.tag = artist
        }

        cacheListView.setOnItemClickListener { _, _, position, _ ->
            val item  = cacheAdapter.getItem(position)
            val dialog = CacheDialogFragment.newInstance(item)
            dialog.clickListener = DialogInterface.OnClickListener { _, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    // Save
                    currentCacheItem = item
                    AppUtils.saveFile(this@CacheActivity, item.title, item.artist)
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    // Research
                    currentCacheItem = item
                    val intent = Intent(this@CacheActivity, SearchActivity::class.java)
                    intent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, item.title)
                    intent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, item.artist)
                    startActivity(intent)
                } else if (which == CacheDialogFragment.DIALOG_RESULT_DELETE_LYRICS) {
                    searchCache(cacheTitleEditText.tag as String, cacheArtistEditText.tag as String)
                } else if (which == CacheDialogFragment.DIALOG_RESULT_DELETE_CACHE) {
                    searchCache(cacheTitleEditText.tag as String, cacheArtistEditText.tag as String)
                }
            }
            dialog.show(this)
        }

    }

    /**
     * On New Intent
     */
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    /**
     * On create options menu.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_cache, menu)
        return true
    }

    /**
     * On options item selected.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.menu_cache_delete -> {
                if (cacheAdapter.checkedSet.size == 0) {
                    AppUtils.showToast(this, R.string.error_delete_cache_check)
                    return true
                }

                val dialog = ConfirmDialogFragment.newInstance(
                        getString(R.string.message_dialog_cache_delete),
                        getString(R.string.label_confirmation),
                        getString(R.string.label_dialog_cache_delete),
                        null,
                        getString(android.R.string.cancel)
                )

                dialog.clickListener = DialogInterface.OnClickListener { _, which ->
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        launch(UI) {
                            val result = async {
                                return@async searchCacheHelper.delete(cacheAdapter.checkedSet)
                            }
                            if (result.await()) {
                                cacheAdapter.removeCheckedItem()
                                AppUtils.showToast(this@CacheActivity, R.string.message_delete_cache)
                            }
                        }
                    }
                }
                dialog.show(this)
            }
            R.id.menu_cache_open_search -> {
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, cacheTitleEditText.text.toString())
                intent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, cacheArtistEditText.text.toString())
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * On activity result
     */
    public override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent) {
        if (requestCode == AppUtils.REQUEST_CODE_SAVE_FILE) {
            // 歌詞のファイル保存
            if (resultCode == Activity.RESULT_OK) {
                val uri = resultData.data
                try {
                    contentResolver.openOutputStream(uri!!)!!.use { stream ->
                        BufferedWriter(OutputStreamWriter(stream, "UTF-8")).use { writer ->
                            writer.write(currentCacheItem!!.makeResultItem()!!.lyrics)
                            writer.flush()
                            AppUtils.showToast(this, R.string.message_lyrics_save_succeeded)
                            val p = PreferenceManager.getDefaultSharedPreferences(this)
                            p.edit().putString("pref_prev_file_uri", uri.toString()).apply()
                        }
                    }
                } catch (e: IOException) {
                    Logger.e(e)
                    AppUtils.showToast(this, R.string.message_lyrics_save_failed)
                }

            }
        }

        currentCacheItem = null

        // Hide keyboard
        if (currentFocus != null) {
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    private fun searchCache(title: String, artist: String) {
        launch(UI) {
            val result = async {
                return@async searchCacheHelper.search(title, artist)
            }
            cacheAdapter.setList(result.await().toMutableList())
        }
    }



    /**
     * Search result adapter.
     */
    private class CacheAdapter internal constructor(context: Context) : ArrayAdapter<SearchCache>(context, R.layout.layout_search_item) {
        /** Checked item. */
        val checkedSet = HashSet<SearchCache>()
        /** SearchCache list.  */
        private var cacheList: MutableList<SearchCache> = ArrayList()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var itemView = convertView
            // itemView
            val holder: ListItemViewHolder
            if (itemView == null) {
                holder = ListItemViewHolder(parent.context)
                itemView = holder.itemView
            } else {
                holder = itemView.tag as ListItemViewHolder
            }

            holder.bind(getItem(position), checkedSet)

            return itemView
        }

        fun setList(list: MutableList<SearchCache>) {
            cacheList = list
            showCacheList()
        }

        fun removeCheckedItem() {
            cacheList.removeAll(checkedSet)
            showCacheList()
        }

        fun showCacheList() {
            clear()
            addAll(cacheList)
            notifyDataSetChanged()
        }

        override fun notifyDataSetChanged() {
            super.notifyDataSetChanged()
            checkedSet.clear()
        }

        /** List item view holder.  */
        private class ListItemViewHolder(val context: Context) {
            val itemView = View.inflate(context, R.layout.layout_cache_item, null)!!
            init {
                itemView.tag = this
            }

            fun bind(item: SearchCache, checkedSet: HashSet<SearchCache>) {
                itemView.cacheItemCheckBox.isChecked = checkedSet.contains(item)
                itemView.cacheItemTitleTextView.text = context.getString(R.string.label_cache_item_title, AppUtils.coalesce(item.title))
                itemView.cacheItemArtistTextView.text = context.getString(R.string.label_cache_item_artist, AppUtils.coalesce(item.artist))
                itemView.cacheItemFromTextView.text = context.getString(R.string.label_cache_item_from, AppUtils.coalesce(item.from))
                itemView.cacheItemFileTextView.text = context.getString(R.string.label_cache_item_file, AppUtils.coalesce(item.file_name))
                itemView.cacheItemLangTextView.text = context.getString(R.string.label_cache_item_lang, AppUtils.coalesce(item.language))
                if (item.has_lyrics == true) {
                    itemView.cacheItemHasLyricsImageView.visibility = View.VISIBLE
                } else {
                    itemView.cacheItemHasLyricsImageView.visibility = View.GONE
                }

                // event
                itemView.cacheItemCheckBox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked)
                        checkedSet.add(item)
                    else
                        checkedSet.remove(item)
                }
            }
        }
    }



    companion object {
        const val INTENT_SEARCH_TITLE = "INTENT_SEARCH_TITLE"
        const val INTENT_SEARCH_ARTIST = "INTENT_SEARCH_ARTIST"
    }

}
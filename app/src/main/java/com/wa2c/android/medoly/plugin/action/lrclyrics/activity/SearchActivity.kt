package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ListView
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.ConfirmDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.NormalizeDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.Result
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ViewLyricsSearcher
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Prefs
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.layout_search_item.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter

/**
 * Search Activity.
 */
class SearchActivity : Activity() {

    /** Search list adapter.  */
    private lateinit var searchResultAdapter: SearchResultAdapter
    /** Search cache helper.  */
    private lateinit var searchCacheHelper: SearchCacheHelper

    /** Preferences.  */
    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        prefs = Prefs(this)

        val intentSearchTitle : String? = intent.getStringExtra(INTENT_SEARCH_TITLE)
        val intentSearchArtist : String? = intent.getStringExtra(INTENT_SEARCH_ARTIST)


        searchTitleEditText.setText(intentSearchTitle)
        searchArtistEditText.setText(intentSearchArtist)

        // Action Bar
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)

        searchCacheHelper = SearchCacheHelper(this)
        searchResultAdapter = SearchResultAdapter(this)
        searchResultListView.adapter = searchResultAdapter

        val searchResultHeight = resources.getDimensionPixelSize(R.dimen.search_result_height)

        // adjust size
        searchLyricsScrollView.post(Runnable {
            // adjust height
            val heightResult = searchResultListView.measuredHeight
            val heightLyrics = searchLyricsScrollView.measuredHeight
            val heightSum = heightResult + heightLyrics
            if (heightResult == 0)
                return@Runnable
            if (heightSum < searchResultHeight * 2) {
                val params = searchResultListView!!.layoutParams
                params.height = heightSum / 2
                searchResultListView.layoutParams = params
            }
        })


        searchTitleButton.setOnClickListener {
            val dialogFragment = NormalizeDialogFragment.newInstance(searchTitleEditText.text.toString(), intentSearchTitle)
            dialogFragment.clickListener = DialogInterface.OnClickListener { _, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    searchTitleEditText.setText(dialogFragment.inputText)
                }
            }
            dialogFragment.show(this)
        }

        searchArtistButton.setOnClickListener {
            val dialogFragment = NormalizeDialogFragment.newInstance(searchArtistEditText.text.toString(), intentSearchArtist)
            dialogFragment.clickListener = DialogInterface.OnClickListener { _, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    searchArtistEditText.setText(dialogFragment.inputText)
                }
            }
            dialogFragment.show(this)

        }

        searchClearButton.setOnClickListener {
            searchTitleEditText.text = null
            searchArtistEditText.text = null
        }

        searchStartButton.setOnClickListener { view ->
            // Hide keyboard
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            val title = searchTitleEditText.text.toString()
            val artist = searchArtistEditText.text.toString()
            if (title.isEmpty() && artist.isEmpty()) {
                AppUtils.showToast(this, R.string.error_input_condition)
                return@setOnClickListener
            }

            // Clear view
            showSearchResult(null)
            showLyrics(null)
            searchResultAdapter.selectedItem = null

            searchResultListView.visibility = View.INVISIBLE
            searchResultLoadingLayout.visibility = View.VISIBLE

            //searchLyrics(title, artist)
            launch(UI) {
                val result = async {
                    try {
                        return@async ViewLyricsSearcher.search(title, artist, 0)
                    } catch (e: Exception) {
                        return@async null
                    }
                }
                val r = result.await()
                if (r == null)
                    AppUtils.showToast(applicationContext, R.string.message_lyrics_failure)
                showSearchResult(r)
            }
        }

        searchResultListView.setOnItemClickListener { _, _, position, _ ->
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(searchResultListView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            // Clear view
            showLyrics(null)

            searchLyricsScrollView.visibility = View.INVISIBLE
            searchLyricsLoadingLayout.visibility = View.VISIBLE

            launch(UI) {
                val item = searchResultAdapter.getItem(position)
                item.lyrics = async {
                    return@async ViewLyricsSearcher.downloadLyricsText(item.lyricURL)
                }.await()
                showLyrics(item)
            }
        }
    }



    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)

        searchResultListView.adapter = searchResultAdapter

        searchTitleEditText.setText(intent.getStringExtra(INTENT_SEARCH_TITLE))
        searchArtistEditText.setText(intent.getStringExtra(INTENT_SEARCH_ARTIST))
    }

    /**
     * On create options menu.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_search, menu)
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
            R.id.menu_search_save_file -> {
                if (!existsLyrics()) {
                    AppUtils.showToast(this, R.string.error_exists_lyrics)
                    return true
                }

                val title = searchTitleEditText.text.toString()
                val artist = searchArtistEditText.text.toString()
                AppUtils.saveFile(this, title, artist)
            }
            R.id.menu_search_save_cache -> {
                if (!existsLyrics()) {
                    AppUtils.showToast(this, R.string.error_exists_lyrics)
                    return true
                }

                val dialog = ConfirmDialogFragment.newInstance(
                        getString(R.string.message_dialog_confirm_save_cache),
                        getString(R.string.label_confirmation),
                        getString(R.string.label_dialog_confirm_save_cache),
                        null,
                        getString(android.R.string.cancel)
                )
                dialog.clickListener = DialogInterface.OnClickListener { _, which ->
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        val title = searchTitleEditText.text.toString()
                        val artist = searchArtistEditText.text.toString()

                        launch(UI) {
                            val result = async {
                                return@async searchCacheHelper.insertOrUpdate(title, artist, searchResultAdapter.selectedItem)
                            }
                            if (result.await())
                                AppUtils.showToast(this@SearchActivity, R.string.message_save_cache)
                        }
                    }
                }
                dialog.show(this)
            }
            R.id.menu_search_open_cache -> {
                val intent = Intent(this, CacheActivity::class.java)
                intent.putExtra(CacheActivity.INTENT_SEARCH_TITLE, searchTitleEditText.text.toString())
                intent.putExtra(CacheActivity.INTENT_SEARCH_ARTIST, searchArtistEditText.text.toString())
                startActivity(intent)
                return true
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
                if (!existsLyrics()) {
                    AppUtils.showToast(this, R.string.error_exists_lyrics)
                    return
                }

                val uri = resultData.data
                try {
                    contentResolver.openOutputStream(uri).use { stream ->
                        BufferedWriter(OutputStreamWriter(stream, "UTF-8")).use { writer ->
                            writer.write(searchResultAdapter.selectedItem?.lyrics)
                            writer.flush()
                            AppUtils.showToast(this, R.string.message_lyrics_save_succeeded)
                        }
                    }
                } catch (e: IOException) {
                    Logger.e(e)
                    AppUtils.showToast(this, R.string.message_lyrics_save_failed)
                }

            }
        }

        // Hide keyboard
        if (currentFocus != null) {
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    private fun showSearchResult(result: Result?) {
        try {
            searchResultAdapter.clear()
            if (result != null)
                searchResultAdapter.addAll(result.infoList)
            searchResultAdapter.notifyDataSetChanged()
        } finally {
            searchResultListView.visibility = View.VISIBLE
            searchResultLoadingLayout.visibility = View.INVISIBLE
        }
    }

    private fun showLyrics(item: ResultItem?) {
        if (item == null) {
            searchLyricsTextView.text = null
        } else {
            searchLyricsTextView.text = item.lyrics
        }
        searchResultAdapter.selectedItem = item
        searchResultAdapter.notifyDataSetChanged()
        searchLyricsScrollView.visibility = View.VISIBLE
        searchLyricsLoadingLayout.visibility = View.INVISIBLE
    }

    /**
     * Check existence of lyrics
     * @return true if exists lyrics.
     */
    private fun existsLyrics(): Boolean {
        return !searchResultAdapter.selectedItem?.lyricURL.isNullOrEmpty()
    }

    companion object {
        const val INTENT_SEARCH_TITLE = "INTENT_SEARCH_TITLE"
        const val INTENT_SEARCH_ARTIST = "INTENT_SEARCH_ARTIST"
    }

}

/**
 * Search result adapter.
 */
private class SearchResultAdapter internal constructor(context: Context) : ArrayAdapter<ResultItem>(context, R.layout.layout_search_item) {

    /** Selected item.  */
    internal var selectedItem: ResultItem? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listView = parent as ListView
        var itemView = convertView
        val holder: ListItemViewHolder
        if (itemView == null) {
            holder = ListItemViewHolder(parent.context)
            itemView = holder.itemView
        } else {
            holder = itemView.tag as ListItemViewHolder
        }

        val item = getItem(position)
        val listener : (View) -> Unit = {
            listView.performItemClick(it, position, getItemId(position))
        }
        holder.bind(item, (item == selectedItem), listener)

        return itemView
    }

    /** List item view holder.  */
    private class ListItemViewHolder(val context: Context) {
        val itemView = View.inflate(context, R.layout.layout_search_item, null)!!
        init {
            itemView.tag = this
        }

        fun bind(item: ResultItem, selected: Boolean, listener: (View) -> Unit) {
            itemView.searchItemRadioButton.isChecked = selected
            itemView.searchItemTitleTextView.text = item.musicTitle
            itemView.searchItemArtistTextView.text = AppUtils.coalesce(item.musicArtist, "-")
            itemView.searchItemAlbumTextView.text = AppUtils.coalesce(item.musicAlbum, "-")
            itemView.searchItemDownloadTextView.text = context.getString(R.string.label_search_item_download, item.lyricDownloadsCount)
            itemView.searchItemRatingTextView.text = context.getString(R.string.label_search_item_rating, item.lyricRate, item.lyricRatesCount)
            itemView.searchItemFromTextView.text = context.getString(R.string.label_search_item_from, item.lyricUploader)
            itemView.searchItemRadioButton.setOnClickListener(listener)
        }
    }
}

package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ListView
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.ActivitySearchBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.ConfirmDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.NormalizeDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.Result
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ViewLyricsSearcher
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.prefs.Prefs
import kotlinx.android.synthetic.main.layout_search_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Search Activity.
 */
class SearchActivity : Activity() {

    /** Preferences.  */
    private lateinit var prefs: Prefs
    /** Binding. */
    private lateinit var binding: ActivitySearchBinding

    /** Search list adapter.  */
    private lateinit var searchResultAdapter: SearchResultAdapter
    /** Search cache helper.  */
    private lateinit var searchCacheHelper: SearchCacheHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = Prefs(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        val intentSearchTitle : String? = intent.getStringExtra(INTENT_SEARCH_TITLE)
        val intentSearchArtist : String? = intent.getStringExtra(INTENT_SEARCH_ARTIST)

        binding.searchTitleEditText.setText(intentSearchTitle)
        binding.searchArtistEditText.setText(intentSearchArtist)

        // Action Bar
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)

        searchCacheHelper = SearchCacheHelper(this)
        searchResultAdapter = SearchResultAdapter(this)
        binding.searchResultListView.adapter = searchResultAdapter

        val searchResultHeight = resources.getDimensionPixelSize(R.dimen.search_result_height)

        // adjust size
        binding.searchLyricsScrollView.post(Runnable {
            // adjust height
            val heightResult = binding.searchResultListView.measuredHeight
            val heightLyrics = binding.searchLyricsScrollView.measuredHeight
            val heightSum = heightResult + heightLyrics
            if (heightResult == 0)
                return@Runnable
            if (heightSum < searchResultHeight * 2) {
                val params = binding.searchResultListView.layoutParams
                params.height = heightSum / 2
                binding.searchResultListView.layoutParams = params
            }
        })

        // Title button
        binding.searchTitleButton.setOnClickListener {
            val dialogFragment = NormalizeDialogFragment.newInstance(binding.searchTitleEditText.text.toString(), intentSearchTitle)
            dialogFragment.clickListener = { _, which, bundle ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    binding.searchTitleEditText.setText(bundle?.getString(NormalizeDialogFragment.RESULT_INPUT_TEXT))
                }
            }
            dialogFragment.show(this)
        }

        // Artist button
        binding.searchArtistButton.setOnClickListener {
            val dialogFragment = NormalizeDialogFragment.newInstance(binding.searchArtistEditText.text.toString(), intentSearchArtist)
            dialogFragment.clickListener = { _, which, bundle ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    binding.searchArtistEditText.setText(bundle?.getString(NormalizeDialogFragment.RESULT_INPUT_TEXT))
                }
            }
            dialogFragment.show(this)

        }

        // Clear[x] button
        binding.searchClearButton.setOnClickListener {
            binding.searchTitleEditText.text = null
            binding.searchArtistEditText.text = null
        }

        // Search button
        binding.searchStartButton.setOnClickListener { view ->
            // Hide keyboard
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            val title = binding.searchTitleEditText.text.toString()
            val artist = binding.searchArtistEditText.text.toString()
            if (title.isEmpty() && artist.isEmpty()) {
                AppUtils.showToast(this, R.string.error_input_condition)
                return@setOnClickListener
            }

            // Clear view
            showSearchResult(null)
            showLyrics(null)
            searchResultAdapter.selectedItem = null

            binding.searchResultListView.visibility = View.INVISIBLE
            binding.searchResultLoadingLayout.visibility = View.VISIBLE

            //searchLyrics(title, artist)
            GlobalScope.launch(Dispatchers.Main) {
                val result = async(Dispatchers.Default) {
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

        // List item
        binding.searchResultListView.setOnItemClickListener { _, _, position, _ ->
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(binding.searchResultListView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            // Clear view
            showLyrics(null)

            binding.searchLyricsScrollView.visibility = View.INVISIBLE
            binding.searchLyricsLoadingLayout.visibility = View.VISIBLE

            GlobalScope.launch(Dispatchers.Main) {
                val item = searchResultAdapter.getItem(position)
                item.lyrics = async(Dispatchers.Default) {
                    return@async ViewLyricsSearcher.downloadLyricsText(item.lyricURL)
                }.await()
                showLyrics(item)
            }
        }
    }



    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)

        binding.searchResultListView.adapter = searchResultAdapter

        binding.searchTitleEditText.setText(intent.getStringExtra(INTENT_SEARCH_TITLE))
        binding.searchArtistEditText.setText(intent.getStringExtra(INTENT_SEARCH_ARTIST))
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

                val title = binding.searchTitleEditText.text.toString()
                val artist = binding.searchArtistEditText.text.toString()
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
                dialog.clickListener = { _, which, _ ->
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        val title = binding.searchTitleEditText.text.toString()
                        val artist = binding.searchArtistEditText.text.toString()

                        GlobalScope.launch(Dispatchers.Main) {
                            val result = async(Dispatchers.Default) {
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
                intent.putExtra(CacheActivity.INTENT_SEARCH_TITLE, binding.searchTitleEditText.text.toString())
                intent.putExtra(CacheActivity.INTENT_SEARCH_ARTIST, binding.searchArtistEditText.text.toString())
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
        if (requestCode == AppUtils.REQUEST_CODE_SAVE_FILE && resultCode == Activity.RESULT_OK) {
            // Save to lyrics file
            if (!existsLyrics()) {
                AppUtils.showToast(this, R.string.error_exists_lyrics)
                return
            }

            val uri = resultData.data
            try {
                contentResolver.openOutputStream(uri).bufferedWriter(Charsets.UTF_8).use {
                    it.write(searchResultAdapter.selectedItem?.lyrics)
                }
                AppUtils.showToast(this, R.string.message_lyrics_save_succeeded)
            } catch (e: Exception) {
                Timber.e(e)
                AppUtils.showToast(this, R.string.message_lyrics_save_failed)
            }
        }

        // Hide keyboard
        if (currentFocus != null) {
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * Show search result list.
     */
    private fun showSearchResult(result: Result?) {
        try {
            searchResultAdapter.clear()
            if (result != null)
                searchResultAdapter.addAll(result.infoList)
            searchResultAdapter.notifyDataSetChanged()
        } finally {
            binding.searchResultListView.visibility = View.VISIBLE
            binding.searchResultLoadingLayout.visibility = View.INVISIBLE
        }
    }

    /**
     * Show lyrics.
     */
    private fun showLyrics(item: ResultItem?) {
        if (item == null) {
            binding.searchLyricsTextView.text = null
        } else {
            binding.searchLyricsTextView.text = item.lyrics
        }
        searchResultAdapter.selectedItem = item
        searchResultAdapter.notifyDataSetChanged()
        binding.searchLyricsScrollView.visibility = View.VISIBLE
        binding.searchLyricsLoadingLayout.visibility = View.INVISIBLE
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
    }

}


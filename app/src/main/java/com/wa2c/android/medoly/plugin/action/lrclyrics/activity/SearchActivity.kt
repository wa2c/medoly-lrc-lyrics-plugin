package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.ActivitySearchBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.LayoutSearchItemBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.AppDatabase
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheDao
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.ConfirmDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.NormalizeDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.Result
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ViewLyricsSearcher
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber


/**
 * Search Activity.
 */
class SearchActivity : AppCompatActivity() {

    /** Binding. */
    private lateinit var binding: ActivitySearchBinding

    /** Search list adapter.  */
    private lateinit var searchResultAdapter: SearchResultAdapter
    /** Search cache DAO. */
    private lateinit var dao: SearchCacheDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        val intentSearchTitle : String? = intent.getStringExtra(INTENT_SEARCH_TITLE)
        val intentSearchArtist : String? = intent.getStringExtra(INTENT_SEARCH_ARTIST)

        binding.searchTitleEditText.setText(intentSearchTitle)
        binding.searchArtistEditText.setText(intentSearchArtist)

        // Action Bar
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(true)
        }

        dao = AppDatabase.buildDb(this).getSearchCacheDao()
        searchResultAdapter = SearchResultAdapter()
        binding.searchResultListView.adapter = searchResultAdapter
        binding.searchResultListView.layoutManager = LinearLayoutManager(this)

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
                    AppUtils.showToast(applicationContext, R.string.message_get_lyrics_failure)
                showSearchResult(r)
            }
        }

        // List item
        searchResultAdapter.itemClickListener = listener@{ _, position ->
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(binding.searchResultListView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            showLyrics(null)

            binding.searchLyricsScrollView.visibility = View.INVISIBLE
            binding.searchLyricsLoadingLayout.visibility = View.VISIBLE

            GlobalScope.launch(Dispatchers.Main) {
                val item = searchResultAdapter.getItem(position)
                item?.lyrics = async(Dispatchers.Default) {
                    return@async ViewLyricsSearcher.downloadLyricsText(item?.lyricURL)
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

        showSearchResult(null)
    }

    /**
     * On create options menu.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_search, menu)
        if (menu != null) {
            for (i in 0 until menu.size()) {
                menu.getItem(i).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            }
        }
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
                                val cache = SearchCache.create(AppUtils.coalesce(title), AppUtils.coalesce(artist), searchResultAdapter.selectedItem)
                                return@async dao.create(cache) > 0
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
    public override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == AppUtils.REQUEST_CODE_SAVE_FILE && resultCode == RESULT_OK) {
            // Save to lyrics file
            if (!existsLyrics()) {
                AppUtils.showToast(this, R.string.error_exists_lyrics)
                return
            }

            try {
                val uri = resultData?.data!!
                contentResolver.openOutputStream(uri)!!.bufferedWriter(Charsets.UTF_8).use {
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
            inputMethodMgr.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
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
            showLyrics(null)
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
        if (item != null) // for ripple effect
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



    /**
     * Unsent list adapter
     */
    inner class SearchResultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        /** Item list */
        private val itemList: MutableList<ResultItem> = mutableListOf()
        /** Selected item.  */
        var selectedItem: ResultItem? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val itemBinding: LayoutSearchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_search_item, parent,false)
            val rootView = itemBinding.root
            rootView.tag = itemBinding
            return object : RecyclerView.ViewHolder(rootView) {}
        }

        @SuppressLint("ClickableViewAccessibility")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val listPosition = holder.adapterPosition
            val item = itemList[listPosition]
            (holder.itemView.tag as LayoutSearchItemBinding).apply {
                val context = root.context
                searchItemRadioButton.isChecked = (item == selectedItem)
                searchItemTitleTextView.text = item.musicTitle
                searchItemArtistTextView.text = AppUtils.coalesce(item.musicArtist, "-")
                searchItemAlbumTextView.text = AppUtils.coalesce(item.musicAlbum, "-")
                searchItemDownloadTextView.text = context.getString(R.string.label_search_item_download, item.lyricDownloadsCount)
                searchItemRatingTextView.text = context.getString(R.string.label_search_item_rating, item.lyricRate, item.lyricRatesCount)
                searchItemFromTextView.text = context.getString(R.string.label_search_item_from, item.lyricUploader)

                searchItemRadioButton.setOnTouchListener { _, event ->
                    root.onTouchEvent(event)
                }
                root.setOnClickListener {
                    itemClickListener?.invoke(root, listPosition)
                }
            }
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        fun getItem(position: Int): ResultItem? {
            return itemList.getOrNull(position)
        }

        fun addAll(list: Collection<ResultItem>?) {
            if (list != null)
                itemList.addAll(list)
        }

        fun clear() {
            itemList.clear()
        }

        var itemClickListener: ((view: View, which: Int) -> Unit)? = null

    }



    companion object {
        const val INTENT_SEARCH_TITLE = "INTENT_SEARCH_TITLE"
        const val INTENT_SEARCH_ARTIST = "INTENT_SEARCH_ARTIST"
    }

}


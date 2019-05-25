package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

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
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.ActivityCacheBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.*
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.CacheDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.ConfirmDialogFragment
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.android.synthetic.main.layout_cache_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

/**
 * Cache activity
 */
class CacheActivity : AppCompatActivity() {

    /** Binding. */
    private lateinit var binding: ActivityCacheBinding

    /** Search list adapter.  */
    private lateinit var cacheAdapter: CacheAdapter
    /** Search cache DAO. */
    private lateinit var dao: SearchCacheDao
    /** Current cache item. */
    private var currentCacheItem: SearchCache2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cache)

        // Action Bar
        actionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(true)
        }

        dao = AppDatabase.buildDb(this).getSearchCacheDao()
        cacheAdapter = CacheAdapter(this)
        binding.cacheListView.adapter = cacheAdapter

        binding.cacheTitleEditText.setText(intent.getStringExtra(INTENT_SEARCH_TITLE))
        binding.cacheArtistEditText.setText(intent.getStringExtra(INTENT_SEARCH_ARTIST))

        binding.cacheInputClearButton.setOnClickListener {
            binding.cacheTitleEditText.text = null
            binding.cacheArtistEditText.text = null
        }

        binding.cacheInputSearchButton.setOnClickListener {
            // Hide keyboard
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            val title = binding.cacheTitleEditText.text.toString()
            val artist = binding.cacheArtistEditText.text.toString()

            searchCache(title, artist)
            binding.cacheTitleEditText.tag = title
            binding.cacheArtistEditText.tag = artist
        }

        binding.cacheListView.setOnItemClickListener { _, _, position, _ ->
            val item  = cacheAdapter.getItem(position)!!
            val dialog = CacheDialogFragment.newInstance(item)

            dialog.clickListener = { _, which, _ ->
                when (which) {
                    // Save
                    DialogInterface.BUTTON_POSITIVE -> {
                        currentCacheItem = item
                        AppUtils.saveFile(this@CacheActivity, item.title, item.artist)
                    }
                    // Re-search
                    DialogInterface.BUTTON_NEGATIVE -> {
                        currentCacheItem = item
                        val intent = Intent(this@CacheActivity, SearchActivity::class.java)
                        intent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, item.title)
                        intent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, item.artist)
                        startActivity(intent)
                    }
                    // Delete lyrics
                    CacheDialogFragment.DIALOG_RESULT_DELETE_LYRICS -> searchCache(binding.cacheTitleEditText.tag as String, binding.cacheArtistEditText.tag as String)
                    // Delete cache
                    CacheDialogFragment.DIALOG_RESULT_DELETE_CACHE -> searchCache(binding.cacheTitleEditText.tag as String,binding. cacheArtistEditText.tag as String)
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

        binding.cacheListView.adapter = cacheAdapter
        binding.cacheTitleEditText.setText(intent.getStringExtra(INTENT_SEARCH_TITLE))
        binding.cacheArtistEditText.setText(intent.getStringExtra(INTENT_SEARCH_ARTIST))
    }

    /**
     * On create options menu.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_cache, menu)
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

                dialog.clickListener = { _, which, _ ->
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        GlobalScope.launch(Dispatchers.Main) {
                            val result = async(Dispatchers.Default) {
                                return@async (dao.deleteIn(cacheAdapter.checkedSet.map{ r -> r._id }.toList()) > 0)
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
                intent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, binding.cacheTitleEditText.text.toString())
                intent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, binding.cacheArtistEditText.text.toString())
                startActivity(intent)
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
            try {
                val uri = resultData?.data!!
                contentResolver.openOutputStream(uri)!!.bufferedWriter(Charsets.UTF_8).use {
                    it.write(currentCacheItem!!.makeResultItem()!!.lyrics)
                }
                AppUtils.showToast(this, R.string.message_lyrics_save_succeeded)
            } catch (e: Exception) {
                Timber.e(e)
                AppUtils.showToast(this, R.string.message_lyrics_save_failed)
            }
        }

        currentCacheItem = null

        // Hide keyboard
        if (currentFocus != null) {
            val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodMgr.hideSoftInputFromWindow(currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * Search cache
     */
    private fun searchCache(title: String, artist: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val result = async(Dispatchers.Default) {
                return@async dao.search(title, artist)
            }
            cacheAdapter.setList(result.await().toMutableList())
        }
    }



    /**
     * Search result adapter.
     */
    private class CacheAdapter internal constructor(context: Context) : ArrayAdapter<SearchCache2>(context, R.layout.layout_search_item) {
        /** Checked item. */
        val checkedSet = HashSet<SearchCache2>()
        /** SearchCache list.  */
        private var cacheList: MutableList<SearchCache2> = ArrayList()

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

            holder.bind(getItem(position)!!, checkedSet)

            return itemView
        }

        fun setList(list: MutableList<SearchCache2>) {
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

            fun bind(item: SearchCache2, checkedSet: HashSet<SearchCache2>) {
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

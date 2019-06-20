package com.wa2c.android.medoly.plugin.action.lrclyrics.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.DialogCacheBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.AppDatabase
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheDao
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**
 * Cache dialog.
 */
class CacheDialogFragment : AbstractDialogFragment() {

    /** Binding. */
    private lateinit var binding: DialogCacheBinding
    private lateinit var dao: SearchCacheDao

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_cache, null, false)
        dao = AppDatabase.buildDb(context).getSearchCacheDao()

        // data
        val cache = arguments!!.getSerializable(ARG_CACHE) as SearchCache
        val result = cache.makeResultItem()

        // view
        binding.dialogCacheLyricsTextView.text = if (cache.has_lyrics != null && cache.has_lyrics!!) result!!.lyrics else getString(R.string.message_dialog_cache_none)
        binding.dialogCacheDeleteLyricsButton.isEnabled = (cache.has_lyrics == true)

        // delete lyrics button
        binding.dialogCacheDeleteLyricsButton.setOnClickListener {
            deleteLyrics(cache)
        }

        // delete cache button
        binding.dialogCacheDeleteCacheButton.setOnClickListener {
            deleteCache(cache)
        }

        // build dialog
        return AlertDialog.Builder(context).apply {
            setTitle(R.string.title_activity_cache)
            setView(binding.root)
            setNeutralButton(R.string.label_close, null)
            setNegativeButton(R.string.label_dialog_cache_research, null)
            result?.let {
                if (!result.lyrics.isNullOrEmpty())
                    setPositiveButton(R.string.menu_search_save_file, null)
            }
            create()
        }.create()
    }

    /**
     * Delete cache lyrics.
     */
    private fun deleteLyrics(cache: SearchCache) {
        GlobalScope.launch(Dispatchers.Main) {
            val deleteResult = async(Dispatchers.Default) {
                try {
                    cache.language = null
                    cache.from = null
                    cache.file_name = null
                    cache.has_lyrics = null
                    cache.result = null
                    cache.date_modified = System.currentTimeMillis()
                    dao.update(cache)
                    return@async true
                } catch (e: Exception) {
                    return@async null
                }
            }
            val r = deleteResult.await()
            if (r != true)
                AppUtils.showToast(context, R.string.message_dialog_cache_delete_error)
            invokeListener(DIALOG_RESULT_DELETE_LYRICS)
        }
    }

    /**
     * Delete cache.
     */
    private fun deleteCache(cache: SearchCache) {
        GlobalScope.launch(Dispatchers.Main) {
            val deleteResult = async(Dispatchers.Default) {
                try {
                    dao.delete(cache)
                    return@async true
                } catch (e: Exception) {
                    return@async null
                }
            }
            val r = deleteResult.await()
            if (r != true)
                AppUtils.showToast(context, R.string.message_dialog_cache_delete_error)
            invokeListener(DIALOG_RESULT_DELETE_CACHE)
        }
    }

    companion object {

        /** Dialog result on delete lyrics.  */
        const val DIALOG_RESULT_DELETE_LYRICS = -10
        /** Dialog result on delete cache.  */
        const val DIALOG_RESULT_DELETE_CACHE = -20

        /** Cache key.  */
        private const val ARG_CACHE = "ARG_CACHE"

        /**
         * Create dialog instance.
         * @param cache Search cache.
         * @return Dialog instance.
         */
        fun newInstance(cache: SearchCache): CacheDialogFragment {
            return CacheDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CACHE, cache)
                }
            }
        }
    }
}

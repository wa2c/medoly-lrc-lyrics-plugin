package com.wa2c.android.medoly.plugin.action.lrclyrics.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.DialogCacheBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_cache, null, false)

        // data
        val cache = arguments.getSerializable(ARG_CACHE) as SearchCache
        val result = cache.makeResultItem()

        // view
        binding.dialogCacheLyricsTextView.text = if (cache.has_lyrics != null && cache.has_lyrics!!) result!!.lyrics else getString(R.string.message_dialog_cache_none)
        if (cache.has_lyrics != true) {
            binding.dialogCacheDeleteLyricsButton.isEnabled = false
        }

        // delete lyrics button
        binding.dialogCacheDeleteLyricsButton.setOnClickListener {
            deleteLyrics(cache)
        }

        // delete cache button
        binding.dialogCacheDeleteCacheButton.setOnClickListener {
            deleteCache(cache)
        }

        // build dialog
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.title_activity_cache)
        builder.setView(binding.root)
        builder.setNeutralButton(R.string.label_close, null)
        builder.setNegativeButton(R.string.label_dialog_cache_research, null)
        if (result != null && !result.lyrics.isNullOrEmpty()) {
            builder.setPositiveButton(R.string.menu_search_save_file, null)
        }
        return builder.create()
    }

    /**
     * Delete cache lyrics.
     */
    private fun deleteLyrics(cache: SearchCache) {
        val searchCacheHelper = SearchCacheHelper(this@CacheDialogFragment.activity)
        GlobalScope.launch(Dispatchers.Main) {
            val deleteResult = async(Dispatchers.Default) {
                try {
                    searchCacheHelper.insertOrUpdate(cache.title, cache.artist, null)
                } catch (e: Exception) {
                    return@async null
                }
            }
            val r = deleteResult.await()
            if (r != true)
                AppUtils.showToast(this@CacheDialogFragment.activity, R.string.message_dialog_cache_delete_error)
            clickListener?.invoke(dialog, DIALOG_RESULT_DELETE_LYRICS, null)
        }
    }

    /**
     * Delete cache.
     */
    private fun deleteCache(cache: SearchCache) {
        val searchCacheHelper = SearchCacheHelper(this@CacheDialogFragment.activity)
        GlobalScope.launch(Dispatchers.Main) {
            val deleteResult = async(Dispatchers.Default) {
                try {
                    searchCacheHelper.delete(listOf(cache))
                } catch (e: Exception) {
                    return@async null
                }
            }
            val r = deleteResult.await()
            if (r != true)
                AppUtils.showToast(this@CacheDialogFragment.activity, R.string.message_dialog_cache_delete_error)
            clickListener?.invoke(dialog, DIALOG_RESULT_DELETE_CACHE, null)
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
            val fragment = CacheDialogFragment()
            val args = Bundle()
            args.putSerializable(ARG_CACHE, cache)
            fragment.arguments = args

            return fragment
        }
    }
}

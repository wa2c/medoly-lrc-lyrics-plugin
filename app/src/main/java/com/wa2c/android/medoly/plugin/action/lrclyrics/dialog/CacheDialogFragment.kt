package com.wa2c.android.medoly.plugin.action.lrclyrics.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCacheHelper
import kotlinx.android.synthetic.main.dialog_cache.view.*
import java.lang.ref.WeakReference



/**
 * Confirm dialog.
 */
class CacheDialogFragment : AbstractDialogFragment() {


    /**
     * onCreateDialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        // data
        val cache = arguments.getSerializable(ARG_CACHE) as SearchCache
        val result = cache.makeResultItem()

        // view
        val contentView = View.inflate(activity, R.layout.dialog_cache, null)
        contentView.dialogCacheLyricsTextView.text = if (cache.has_lyrics != null && cache.has_lyrics!!) result!!.lyrics else getString(R.string.message_dialog_cache_none)

        // delete lyrics button
        contentView.dialogCacheDeleteLyricsButton.setOnClickListener { LyricsDeleteAsyncTask(this@CacheDialogFragment, cache).execute() }

        // delete cache button
        contentView.dialogCacheDeleteCacheButton.setOnClickListener { CacheDeleteAsyncTask(this@CacheDialogFragment, cache).execute() }

        // build dialog
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.title_activity_cache)
        builder.setView(contentView)
        builder.setNeutralButton(R.string.label_close, null)
        builder.setNegativeButton(R.string.label_dialog_cache_research, clickListener)
        if (result != null && !result.lyrics.isNullOrEmpty()) {
            builder.setPositiveButton(R.string.menu_search_save_file, clickListener)
        }
        return builder.create()
    }

    /**
     * Delete lyrics task
     */
    private class LyricsDeleteAsyncTask internal constructor(dialog: AbstractDialogFragment, private val cache: SearchCache) : AsyncTask<Void, Void, Void>() {

        private val dialogReference: WeakReference<AbstractDialogFragment> = WeakReference(dialog)

        override fun doInBackground(vararg params: Void): Void? {
            val c = dialogReference.get()?.activity ?: return null
            val searchCacheHelper = SearchCacheHelper(c)
            searchCacheHelper.insertOrUpdate(cache.title, cache.artist, null)
            return null
        }

        override fun onPostExecute(result: Void) {
            dialogReference.get()?.onClickButton(dialogReference.get()?.dialog, DIALOG_RESULT_DELETE_LYRICS)
        }
    }

    /**
     * Delete lyrics task
     */
    private class CacheDeleteAsyncTask internal constructor(dialog: AbstractDialogFragment, private val cache: SearchCache) : AsyncTask<Void, Void, Void>() {

        private val dialogReference: WeakReference<AbstractDialogFragment> = WeakReference(dialog)

        override fun doInBackground(vararg params: Void): Void? {
            val c = dialogReference.get()?.activity ?: return null
            val searchCacheHelper = SearchCacheHelper(c)
            searchCacheHelper.delete(listOf(cache))
            return null
        }

        override fun onPostExecute(result: Void) {
            dialogReference.get()?.onClickButton(dialogReference.get()?.dialog, DIALOG_RESULT_DELETE_CACHE)
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

package com.wa2c.android.medoly.plugin.action.lrclyrics.db

import android.content.Context

import com.google.gson.Gson
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils

/**
 * Search cache adapter.
 */

class SearchCacheHelper
/**
 * Constructor.
 * @param context Context.
 */
(
        /** Context.  */
        private val context: Context) {
    /** Gson.  */
    private val gson: Gson

    init {
        this.gson = Gson()
    }


    /**
     * Get ResultItem object from title and artist.
     * @param title Search title.
     * @param artist Search artist.
     * @return Exists item, null if not exists.
     */
    fun select(title: String?, artist: String?): SearchCache? {
        val od = provideOrmaDatabase(context)
        return od.selectFromSearchCache()
                .titleAndArtistEq(AppUtils.coalesce(title), AppUtils.coalesce(artist))
                .valueOrNull()
    }

    /**
     * Get Search Cache object matched on title and artist.
     * @param title Search title.
     * @param artist Search artist.
     * @return Exists item, null if not exists.
     */
    fun search(title: String?, artist: String?): List<SearchCache> {
        val od = provideOrmaDatabase(context)
        val selector = od.selectFromSearchCache()
        // title
        if (title != null && !title.isEmpty())
            selector.where("title like ?", "%$title%")
        // artist
        if (artist != null && !artist.isEmpty())
            selector.where("artist like ?", "%$artist%")

        return selector.orderBytitleAndArtistAsc()
                .toList()
    }

    /**
     * Insert or update cache.
     * @param searchTitle Search title.
     * @param searchArtist Search artist.
     * @param resultItem Result item.
     * @return true as succeeded.
     */
    fun insertOrUpdate(searchTitle: String?, searchArtist: String?, resultItem: ResultItem?): Boolean {
        val od = provideOrmaDatabase(context)

        var language: String? = null
        var from: String? = null
        var file_name: String? = null
        var has_lyrics: Boolean? = false
        val result = gson.toJson(resultItem)
        if (resultItem != null && resultItem.lyricURL != null) {
            language = resultItem.language
            from = resultItem.lyricUploader
            file_name = resultItem.lyricURL!!.substring(resultItem.lyricURL!!.lastIndexOf("/") + 1).replace(".lrc", "")
            has_lyrics = resultItem.lyrics != null
        }

        val title = AppUtils.coalesce(searchTitle)
        val artist = AppUtils.coalesce(searchArtist)

        var cache = select(title, artist)
        if (cache != null) {
            val count = od.updateSearchCache()._idEq(cache._id)
                    .language(language)
                    .from(from)
                    .file_name(file_name)
                    .has_lyrics(has_lyrics)
                    .result(result)
                    .execute()
            return count > 0
        } else {
            // Insert model
            cache = SearchCache(
                    0,
                    title,
                    artist,
                    language,
                    from,
                    file_name,
                    has_lyrics,
                    result,
                    null,
                    null
            )
            val id = od.insertIntoSearchCache(cache)
            return id >= 0
        }
    }

    /**
     * Delete cache.
     * @param caches Cache.
     * @return true as succeeded.
     */
    fun delete(caches: Collection<SearchCache>?): Boolean {
        if (caches == null || caches.size == 0)
            return false

        val od = provideOrmaDatabase(context)

        od.transactionSync {
            for ((_id) in caches) {
                od.deleteFromSearchCache()
                        ._idEq(_id)
                        .execute()
            }
        }

        return true
    }

    companion object {

        /** Singleton object.  */
        private var ormaDatabase: OrmaDatabase? = null

        /**
         * Provide OrmaDatabase.
         * @param context context.
         * @return OrmaDatabase object.
         */
        @Synchronized
        private fun provideOrmaDatabase(context: Context): OrmaDatabase {
            if (ormaDatabase == null) {
                ormaDatabase = OrmaDatabase.builder(context).build()
            }
            return ormaDatabase!!
        }
    }

}

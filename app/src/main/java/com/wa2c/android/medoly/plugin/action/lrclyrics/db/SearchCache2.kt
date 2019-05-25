package com.wa2c.android.medoly.plugin.action.lrclyrics.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import java.io.Serializable

@Entity(
        tableName = SearchCache2.SEARCH_CACHE_TABLE_NAME,
        indices = [Index(value = ["title", "artist"]), Index(value = ["title"]), Index(value = ["artist"])]
)
data class SearchCache2 (
        @PrimaryKey(autoGenerate = true) var _id: Long,
        var title: String?,
        var artist: String?,
        var language: String?,
        var from: String?,
        var file_name: String?,
        var has_lyrics: Boolean?,
        var result: String?,
        var date_added: Long?,
        var date_modified: Long?
): Serializable {


    /**
     * Get ResultItem from result field.
     * @return result item.
     */
    fun makeResultItem(): ResultItem? {
        return if (result == null || result!!.isEmpty()) null else Gson().fromJson(result, ResultItem::class.java)
    }

    companion object {
        const val SEARCH_CACHE_TABLE_NAME = "search_cache"

        /**
         * Create new object.
         */
        fun create(title: String, artist: String, result: ResultItem?): SearchCache2 {
            val now = System.currentTimeMillis()
            return SearchCache2(
                    0,
                    AppUtils.coalesce(title),
                    AppUtils.coalesce(artist),
                    result?.language,
                    result?.lyricUploader,
                    result?.lyricsFileName,
                    !result?.lyrics.isNullOrEmpty(),
                    Gson().toJson(result),
                    now,
                    now)
        }
    }

}

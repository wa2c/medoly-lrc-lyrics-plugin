package com.wa2c.android.medoly.plugin.action.lrclyrics.db

import androidx.room.*
import com.google.gson.Gson
import com.wa2c.android.medoly.plugin.action.lrclyrics.search.ResultItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils

@Dao
interface SearchCacheDao {

    @Query("SELECT * FROM " + SearchCache2.SEARCH_CACHE_TABLE_NAME + " WHERE title LIKE '%' || :title || '%' AND artist LIKE '%' || :artist || '%'")
    fun search(title: String, artist: String): List<SearchCache2>

    @Insert
    fun create(row: SearchCache2): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(row: SearchCache2): Int

    @Delete
    fun delete(row: SearchCache2): Int

    @Query("DELETE FROM " + SearchCache2.SEARCH_CACHE_TABLE_NAME + " WHERE _id IN (:ids)")
    fun deleteIn(ids: List<Long>): Int

}

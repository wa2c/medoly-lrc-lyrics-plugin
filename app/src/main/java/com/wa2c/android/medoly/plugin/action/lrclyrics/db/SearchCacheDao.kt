package com.wa2c.android.medoly.plugin.action.lrclyrics.db

import androidx.room.*

@Dao
interface SearchCacheDao {

    @Query("SELECT * FROM " + SearchCache.SEARCH_CACHE_TABLE_NAME + " WHERE title LIKE '%' || :title || '%' AND artist LIKE '%' || :artist || '%'")
    fun search(title: String, artist: String): List<SearchCache>

    @Insert
    fun create(row: SearchCache): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(row: SearchCache): Int

    @Delete
    fun delete(row: SearchCache): Int

    @Query("DELETE FROM " + SearchCache.SEARCH_CACHE_TABLE_NAME + " WHERE _id IN (:ids)")
    fun deleteIn(ids: List<Long>): Int

}

package com.wa2c.android.medoly.plugin.action.lrclyrics.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Search Cache Database.
 */
@Database(entities = [SearchCache::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get search cache dao.
     */
    abstract fun getSearchCacheDao(): SearchCacheDao

    companion object {
        /** DB name */
        private const val DB_NAME = "app.db"

        /**
         * Build DB
         */
        fun buildDb(context: Context) : AppDatabase {
             return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries() // Main thread でも動作させたい場合
                    .build()
        }
    }

}

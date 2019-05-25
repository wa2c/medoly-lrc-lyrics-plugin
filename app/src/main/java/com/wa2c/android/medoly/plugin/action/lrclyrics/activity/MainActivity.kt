package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wa2c.android.medoly.library.MedolyEnvironment
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.databinding.ActivityMainBinding
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache2
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.AppDatabase
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import timber.log.Timber



/**
 * Main activity.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        actionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(true)
            it.setIcon(R.drawable.ic_launcher)
        }

        // Search
        binding.launchSearchButton.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        // Cache
        binding.launchCacheButton.setOnClickListener {
            startActivity(Intent(this, CacheActivity::class.java))
        }

        // Settings
//        val database = Room.databaseBuilder(this, AppDatabase::class.java, "com.wa2c.android.medoly.plugin.action.lrclyrics.orma.db")
//                .addMigrations()
//                .addMigrations(MIGRATION_11_12)
//                .build()
        binding.launchSettingsButton.setOnClickListener {
            //startActivity(Intent(this, SettingsActivity::class.java))
//            val dao = database.searchCacheDao()
            GlobalScope.async {
                try {
                    try {
                        val dbPath = getDatabasePath("com.wa2c.android.medoly.plugin.action.lrclyrics.orma.db")
                        val db: SQLiteDatabase = SQLiteDatabase.openDatabase(dbPath.absolutePath, null, SQLiteDatabase.OPEN_READWRITE)
                        val columns = arrayOf("_id", "title", "artist", "language", "`from`", "file_name", "has_lyrics", "result", "date_added", "date_modified")
                        db.query("search_cache", columns, null, null, null, null, "_id").use {
                            while (it.moveToNext()) {
                                val row = SearchCache2(
                                        it.getLong(0), // _id
                                        it.getString(1), // title
                                        it.getString(2), // artist
                                        it.getString(3), // language
                                        it.getString(4), // from
                                        it.getString(5), // file_name
                                        it.getString(6) == "1", // has_lyrics
                                        it.getString(7), // result
                                        it.getString(8)?.toLongOrNull(), // date_added
                                        it.getString(9)?.toLongOrNull() // date_modified
                                )
                                Timber.d(db.toString())
                            }
                        }
                    } catch (e: Exception) {
                        Timber.e(e)
                    }
                } catch (e: Exception) {
                    Timber.e(e)
                }
            }

        }

        // Launch Medoly
        binding.launchMedolyButton.setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage(MedolyEnvironment.MEDOLY_PACKAGE)
            if (intent == null) {
                AppUtils.showToast(this, R.string.message_no_medoly)
                return@setOnClickListener
            }
            startActivity(intent)
        }
    }
    val MIGRATION_11_12 = object : Migration(11, 12) {
        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }

}

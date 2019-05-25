package com.wa2c.android.medoly.plugin.action.lrclyrics

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.core.content.pm.PackageInfoCompat
import com.wa2c.android.medoly.library.PluginOperationCategory
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.AppDatabase
import com.wa2c.android.medoly.plugin.action.lrclyrics.db.SearchCache2
import com.wa2c.android.prefs.Prefs
import timber.log.Timber

/**
 * Migrator
 */
class Migrator(private val context: Context) {
    private val prefs = Prefs(context)

    /**
     * Get current app version code.
     * @return Current version.
     */
    private val currentVersionCode: Int
        get() {
            return try {
                val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
                PackageInfoCompat.getLongVersionCode(packageInfo).toInt()
            } catch (e: Exception) {
                Timber.d(e)
                0
            }
        }

    /**
     * Get saved app version code. (previous version)
     * @return Saved version.
     */
    private val savedVersionCode: Int
        get() = prefs.getInt(R.string.pref_app_version_code, 0)

    /**
     * Save current version.
     */
    private fun saveCurrentVersionCode() {
        val version = currentVersionCode
        prefs[R.string.pref_app_version_code] = version
    }



    /**
     * Version up.
     */
    fun versionUp(): Boolean {
        val prevVersionCode = savedVersionCode
        val currentVersionCode = currentVersionCode

        versionUpFrom11(prevVersionCode)

        if (currentVersionCode <= prevVersionCode || prevVersionCode == 0)
            return false

        // migration
        versionUpFrom0(prevVersionCode)
        versionUpFrom10(prevVersionCode)
        versionUpFrom11(prevVersionCode)

        // save version
        saveCurrentVersionCode()
        return true
    }

    /**
     * Ver > ?
     */
    private fun versionUpFrom0(prevVersionCode: Int) {
        val pref_plugin_event = "pref_plugin_event"
        if (!prefs.contains(pref_plugin_event))
            return

        val event = prefs.getInt(pref_plugin_event)
        if (event == 1)
            prefs[R.string.pref_event_get_lyrics] = PluginOperationCategory.OPERATION_MEDIA_OPEN.name
        else if (event == 2)
            prefs[R.string.pref_event_get_lyrics] = PluginOperationCategory.OPERATION_PLAY_START.name
        prefs.remove(pref_plugin_event)
    }

    /**
     * Ver > Ver. 1.8.0 (10)
     */
    private fun versionUpFrom10(prevVersionCode: Int) {
        if (prevVersionCode > 10)
            return

        // Get Lyrics
        val albumArt: String? = prefs[R.string.pref_event_get_lyrics]
        if (albumArt == "OPERATION_MEDIA_OPEN")
            prefs[R.string.pref_event_get_lyrics] = PluginOperationCategory.OPERATION_MEDIA_OPEN.categoryValue
        else if (albumArt == "OPERATION_PLAY_START")
            prefs[R.string.pref_event_get_lyrics] = PluginOperationCategory.OPERATION_PLAY_START.categoryValue
    }

    /**
     * Ver > Ver. 1.8.1 (11)
     */
    private fun versionUpFrom11(prevVersionCode: Int) {
        if (prevVersionCode > 11)
            return

        try {
            val roomDb = AppDatabase.buildDb(context)
            roomDb.runInTransaction {
                val dao = roomDb.getSearchCacheDao()
                val dbPath = context.getDatabasePath("com.wa2c.android.medoly.plugin.action.lrclyrics.orma.db") // Orma DB
                val ormaDb: SQLiteDatabase = SQLiteDatabase.openDatabase(dbPath.absolutePath, null, SQLiteDatabase.OPEN_READWRITE)
                val columns = arrayOf("_id", "title", "artist", "language", "`from`", "file_name", "has_lyrics", "result", "date_added", "date_modified")
                ormaDb.query("search_cache", columns, null, null, null, null, "_id").use {
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
                        dao.create(row)
                        Timber.d(row.toString())
                    }
                }
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }



}

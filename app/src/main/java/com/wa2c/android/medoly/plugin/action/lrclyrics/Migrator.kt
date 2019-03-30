package com.wa2c.android.medoly.plugin.action.lrclyrics

import android.content.Context
import com.wa2c.android.medoly.library.PluginOperationCategory
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
                packageInfo.versionCode
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

        if (currentVersionCode <= prevVersionCode)
            return false

        // migration
        versionUpFrom0(prevVersionCode)
        versionUpFrom10(prevVersionCode)

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
     * Ver > Ver. 2.1.0 (17)
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

}

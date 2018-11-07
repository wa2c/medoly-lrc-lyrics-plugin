package com.wa2c.android.medoly.plugin.action.lrclyrics

import android.app.Application
import android.content.Context
import com.wa2c.android.medoly.library.PluginOperationCategory
import com.wa2c.android.prefs.Prefs


/**
 * App
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        versionUp(this)
    }

    /**
     * Version up.
     * @param context Context.
     */
    private fun versionUp(context: Context) {
        val pref_plugin_event = "pref_plugin_event"

        val pref = Prefs(context)
        if (pref.contains(pref_plugin_event)) {
            val `val` = pref.getInt(pref_plugin_event)
            if (`val` == 1)
                pref.putString(context.getString(R.string.pref_event_get_lyrics), PluginOperationCategory.OPERATION_MEDIA_OPEN.name)
            else if (`val` == 2)
                pref.putString(context.getString(R.string.pref_event_get_lyrics), PluginOperationCategory.OPERATION_PLAY_START.name)
            pref.remove(pref_plugin_event)
        }
    }
}

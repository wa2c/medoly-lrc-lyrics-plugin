package com.wa2c.android.medoly.plugin.action.lrclyrics.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.wa2c.android.medoly.library.MediaPluginIntent
import com.wa2c.android.medoly.library.MediaProperty
import com.wa2c.android.medoly.library.PluginOperationCategory
import com.wa2c.android.medoly.library.PluginTypeCategory
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.prefs.Prefs
import timber.log.Timber

/**
 * Execute receiver.
 */
class PluginReceivers {

    abstract class AbstractPluginReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Timber.d("onReceive: " + this.javaClass.simpleName)

            val pluginIntent = MediaPluginIntent(intent)
            val propertyData = pluginIntent.propertyData ?: return
            val prefs = Prefs(context)

            if (this is EventGetLyricsReceiver ||
                this is ExecuteGetLyricsReceiver) {
                // category
                if (!pluginIntent.hasCategory(PluginTypeCategory.TYPE_GET_LYRICS)) {
                    AppUtils.sendResult(context, pluginIntent)
                    return
                }
                // media
                if (propertyData.isMediaEmpty) {
                    AppUtils.showToast(context, R.string.message_no_media)
                    AppUtils.sendResult(context, pluginIntent)
                    return
                }
                // property
                if (propertyData.getFirst(MediaProperty.TITLE).isNullOrEmpty() || propertyData.getFirst(MediaProperty.ARTIST).isNullOrEmpty()) {
                    AppUtils.sendResult(context, pluginIntent)
                    return
                }

                val operation = prefs.getString(R.string.pref_event_get_lyrics, defRes = R.string.pref_default_event_get_lyrics)
                if (!pluginIntent.hasCategory(PluginOperationCategory.OPERATION_EXECUTE) && !pluginIntent.hasCategory(operation)) {
                    AppUtils.sendResult(context, pluginIntent)
                    return
                }

                // service
                pluginIntent.setClass(context, PluginGetLyricsService::class.java)
            } else if (this is ExecuteSearchLyricsReceiver) {
                // check
                if (!pluginIntent.hasCategory(PluginTypeCategory.TYPE_RUN)) {
                    return
                }

                // service
                pluginIntent.setClass(context, PluginRunService::class.java)
            }

            pluginIntent.putExtra(AbstractPluginService.RECEIVED_CLASS_NAME, this.javaClass.name)
            context.stopService(pluginIntent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(pluginIntent)
            } else {
                context.startService(pluginIntent)
            }
        }
    }

    // Event

    class EventGetLyricsReceiver : AbstractPluginReceiver()

    // Execution

    class ExecuteGetLyricsReceiver : AbstractPluginReceiver()

    class ExecuteSearchLyricsReceiver : AbstractPluginReceiver()

}

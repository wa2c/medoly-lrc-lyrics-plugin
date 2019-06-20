package com.wa2c.android.medoly.plugin.action.lrclyrics.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.wa2c.android.medoly.library.*
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
            val result = receive(context, MediaPluginIntent(intent))
            setResult(result.resultCode, null, null)
        }

        /**
         * Receive data.
         */
        private fun receive(context: Context, pluginIntent: MediaPluginIntent): PluginBroadcastResult {
            var result =  PluginBroadcastResult.CANCEL

            val propertyData = pluginIntent.propertyData ?: return result
            val prefs = Prefs(context)

            if (this is EventGetLyricsReceiver ||
                    this is ExecuteGetLyricsReceiver) {
                // category
                if (!pluginIntent.hasCategory(PluginTypeCategory.TYPE_GET_LYRICS)) {
                    AppUtils.sendResult(context, pluginIntent)
                    return result
                }
                // media
                if (propertyData.isMediaEmpty) {
                    AppUtils.showToast(context, R.string.message_no_media)
                    AppUtils.sendResult(context, pluginIntent)
                    return result
                }
                // property
                if (propertyData.getFirst(MediaProperty.TITLE).isNullOrEmpty() || propertyData.getFirst(MediaProperty.ARTIST).isNullOrEmpty()) {
                    AppUtils.sendResult(context, pluginIntent)
                    return result
                }

                val operation = prefs.getString(R.string.pref_event_get_lyrics, defRes = R.string.pref_default_event_get_lyrics)
                if (!pluginIntent.hasCategory(PluginOperationCategory.OPERATION_EXECUTE) && !pluginIntent.hasCategory(operation)) {
                    AppUtils.sendResult(context, pluginIntent)
                    return result
                }

                // service
                pluginIntent.setClass(context, PluginGetLyricsService::class.java)
                result = PluginBroadcastResult.PROCESSING
            } else if (this is ExecuteSearchLyricsReceiver) {
                // category
                if (!pluginIntent.hasCategory(PluginTypeCategory.TYPE_RUN)) {
                    return result
                }

                // service
                pluginIntent.setClass(context, PluginRunService::class.java)
                result = PluginBroadcastResult.COMPLETE
            }

            pluginIntent.putExtra(AbstractPluginService.RECEIVED_CLASS_NAME, this.javaClass.name)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(pluginIntent)
            } else {
                context.startService(pluginIntent)
            }
            return result
        }
    }

    // Event

    class EventGetLyricsReceiver : AbstractPluginReceiver()

    // Execution

    class ExecuteGetLyricsReceiver : AbstractPluginReceiver()

    class ExecuteSearchLyricsReceiver : AbstractPluginReceiver()

}

package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import com.wa2c.android.medoly.library.MediaPluginIntent;
import com.wa2c.android.medoly.library.PluginOperationCategory;
import com.wa2c.android.medoly.library.PluginTypeCategory;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;

import org.androidannotations.api.builder.ServiceIntentBuilder;

/**
 * Execute receiver.
 */
public class PluginReceivers {

    public static abstract class AbstractPluginReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Logger.d("onReceive: " + this.getClass().getSimpleName());

            MediaPluginIntent serviceIntent = new MediaPluginIntent(intent);
            Class c = this.getClass();
            serviceIntent.putExtra(AbstractPluginService.RECEIVED_CLASS_NAME, c.getName());

            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            ServiceIntentBuilder builder = null;
            if (c == EventGetLyricsReceiver.class || c == ExecuteGetLyricsReceiver.class) {
                String operation = pref.getString(context.getString(R.string.pref_event_get_lyrics), "");
                if (serviceIntent.hasCategory(PluginOperationCategory.OPERATION_EXECUTE) ||
                    (serviceIntent.hasCategory(PluginOperationCategory.OPERATION_MEDIA_OPEN) && PluginOperationCategory.OPERATION_MEDIA_OPEN.name().equals(operation)) ||
                    (serviceIntent.hasCategory(PluginOperationCategory.OPERATION_PLAY_START) && PluginOperationCategory.OPERATION_PLAY_START.name().equals(operation))) {
                    PluginGetLyricsService_.intent(context).stop();
                    serviceIntent.setClass(context, PluginGetLyricsService_.class);
                    builder = PluginGetLyricsService_.intent(context).process(serviceIntent);
                } else {
                    AbstractPluginService.sendResult(context, serviceIntent, null);
                }
            } else if (c == ExecuteSearchLyricsReceiver.class) {
                if (serviceIntent.hasCategory(PluginTypeCategory.TYPE_RUN)) {
                    serviceIntent.setClass(context, PluginRunService_.class);
                    PluginRunService_.intent(context).stop();
                    //PluginRunService_.intent(context).process(serviceIntent).start();
                    builder = PluginRunService_.intent(context).process(serviceIntent);
                }
            }

            if (builder != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(builder.get());
                } else {
                    context.startService(builder.get());
                }
            }
        }
    }

    // Event

    public static class EventGetLyricsReceiver extends AbstractPluginReceiver { }

    // Execution

    public static class ExecuteGetLyricsReceiver extends AbstractPluginReceiver { }

    public static class ExecuteSearchLyricsReceiver extends AbstractPluginReceiver { }

}

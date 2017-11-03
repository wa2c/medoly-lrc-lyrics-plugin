package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Execute receiver.
 */
public class PluginReceivers {

    public static abstract class AbstractPluginReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent serviceIntent = new Intent(intent);
            Class c = this.getClass();

            if (c == EventGetLyricsReceiver.class ||
                c == ExecuteGetLyricsReceiver.class ) {
                serviceIntent.setClass(context, PluginGetLyricsService_.class);
                PluginGetLyricsService_.intent(context).stop();
                PluginGetLyricsService_.intent(context).process(serviceIntent).start();
            } else if (c == ExecuteSearchLyricsReceiver.class) {
                serviceIntent.setClass(context, PluginRunService_.class);
                PluginRunService_.intent(context).stop();
                PluginRunService_.intent(context).process(serviceIntent).start();
            }
        }
    }

    // Event

    public static class EventGetLyricsReceiver extends AbstractPluginReceiver { }

    // Execution

    public static class ExecuteGetLyricsReceiver extends AbstractPluginReceiver { }

    public static class ExecuteSearchLyricsReceiver extends AbstractPluginReceiver { }

}

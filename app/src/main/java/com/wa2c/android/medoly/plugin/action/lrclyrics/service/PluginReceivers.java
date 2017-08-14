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
            serviceIntent.putExtra(ProcessService_.RECEIVED_CLASS_NAME, intent.getComponent().getClassName());
            serviceIntent.setClass(context, ProcessService_.class);
            ProcessService_.intent(context).search(serviceIntent).start();
        }
    }

    // Event

    public static class EventGetLyricsReceiver extends AbstractPluginReceiver { }

    // Execution

    public static class ExecuteGetLyricsReceiver extends AbstractPluginReceiver { }

    public static class ExecuteSearchLyricsReceiver extends AbstractPluginReceiver { }

}

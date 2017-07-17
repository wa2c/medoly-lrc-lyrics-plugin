package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wa2c.android.medoly.plugin.action.lrclyrics.service.EventProcessService_;


/**
 * Plugin receiver.
 */
public class PluginReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Stop exists service
        Intent stopIntent = new Intent(context, EventProcessService_.class);
        context.stopService(stopIntent);

        // Launch service
        EventProcessService_.intent(context)
                .search(intent)
                .start();
    }
}

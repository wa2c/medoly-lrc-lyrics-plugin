package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;

/**
 * Event receiver.
 */
public class EventReceiver {
    public static class EventAllReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            AppUtils.startService(context, intent);
        }
    }
}


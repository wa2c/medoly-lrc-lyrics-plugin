package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;

/**
 * Execute receiver.
 */
public class ExecuteReceiver {

    public static class ExecuteGetLyricsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            AppUtils.startService(context, intent);
        }
    }

    public static class ExecuteSearchLyricsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            AppUtils.startService(context, intent);
        }
    }

}

package com.wa2c.android.medoly.plugin.action.viewlyrics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wa2c.android.medoly.plugin.action.viewlyrics.service.DownloadIntentService_;


/**
 * メッセージプラグイン受信レシーバ。
 */
public class PluginReceiver extends BroadcastReceiver {
    /**
     * メッセージ受信。
     * @param context コンテキスト。
     * @param intent インテント。
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        // 既存のサービス強制停止
        Intent stopIntent = new Intent(context, DownloadIntentService_.class);
        context.stopService(stopIntent);

//        // IntentService起動
//        Intent serviceIntent = new Intent(intent);
//        serviceIntent.setClassName(DownloadIntentService.class.getPackage().getName(), DownloadIntentService.class.getName());
//        context.startService(serviceIntent);

        // IntentService 起動
        DownloadIntentService_.intent(context)
                .search(intent)
                .start();
    }
}

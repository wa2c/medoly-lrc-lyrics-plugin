package com.wa2c.android.medoly.plugin.action.lrclyrics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wa2c.android.medoly.plugin.action.lrclyrics.service.EventProcessService_;


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
        Intent stopIntent = new Intent(context, EventProcessService_.class);
        context.stopService(stopIntent);

        // IntentService 起動
        EventProcessService_.intent(context)
                .search(intent)
                .start();
    }
}

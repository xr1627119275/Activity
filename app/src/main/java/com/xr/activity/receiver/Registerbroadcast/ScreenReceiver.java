package com.xr.activity.receiver.Registerbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {
    private static final String TAG = "1ScreenReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals("android.intent.action.SCREEN_OFF")){
            Log.d(TAG, "1锁屏: ");
        }else if(action.equals("android.intent.action.SCREEN_ON")){
            Log.d(TAG, "1开屏: ");

        }
    }
}

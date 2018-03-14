package com.xr.activity.Service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.xr.activity.receiver.Registerbroadcast.ScreenReceiver;

public class ScreenService extends Service {
    private ScreenReceiver screenReceiver;

    public ScreenService() {
    }

    @Override
    public void onCreate() {
        IntentFilter filter = new IntentFilter();
        screenReceiver = new ScreenReceiver();
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(screenReceiver,filter);
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(screenReceiver);
        super.onDestroy();
    }
}

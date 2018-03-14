package com.xr.activity.receiver.Registerbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xr.activity.R;
import com.xr.activity.Service.ScreenService;

public class RegisterbroadcastActivity extends AppCompatActivity {

    private ScreenReceiver screenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbroadcast);
//        IntentFilter filter = new IntentFilter();
//        screenReceiver = new ScreenReceiver();
//        filter.addAction("android.intent.action.SCREEN_OFF");
//        filter.addAction("android.intent.action.SCREEN_ON");
//        registerReceiver(screenReceiver,filter);
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(screenReceiver);
        super.onDestroy();
    }

    public void click(View view) {
        Intent intent = new Intent(this, ScreenService.class);
        startService(intent);
    }
}

package com.xr.activity.receiver.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xr.activity.R;

public class Main5Activity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //动态注册屏幕解锁
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xr.custombroadcast");
        broadcastReceiver = new BroadCastReceiver();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void click(View view) {
        Intent intent = new Intent();
        intent.putExtra("name","my name is xr");
        intent.setAction("com.xr.custombroadcast");
        sendBroadcast(intent);
    }

    public void click1(View view) {
        Intent intent = new Intent();
        intent.setAction("com.xr.OrderedBroadcast");
        sendOrderedBroadcast(intent,null,new FinalReceiver(),null,1,"啊哈哈哈哈哈",null);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();

    }
}

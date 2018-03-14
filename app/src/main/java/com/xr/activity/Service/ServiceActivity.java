package com.xr.activity.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xr.activity.R;

public class ServiceActivity extends AppCompatActivity {

    private Intent intent;
    private Myconn myconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        intent = new Intent(getApplicationContext(), FirstService.class);
    }

    public void click1(View view) {
        startService(intent);
    }

    public void click2(View view) {
        stopService(intent);
    }

    public void click3(View view) {
        myconn = new Myconn();
        bindService(intent, myconn, BIND_AUTO_CREATE);
    }

    public void click4(View view) {
        unbindService(myconn);
    }

     class Myconn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Iservice myBinder = (Iservice) service;
            myBinder.callTest(2);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    protected void onDestroy() {
        unbindService(myconn);
        super.onDestroy();
    }
}

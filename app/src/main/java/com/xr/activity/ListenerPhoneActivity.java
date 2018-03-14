package com.xr.activity;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xr.activity.Service.PhoneService;

public class ListenerPhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_phone);

        Intent intent = new Intent(this, PhoneService.class);
        startService(intent);
//        ActivityManager systemService = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//        boolean isLockScreen = keyguardManager.inKeyguardRestrictedInputMode();
//        Toast.makeText(this,isLockScreen==true?"yes":"no",Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        Intent intent = new Intent(this, PhoneService.class);
        startService(intent);
    }
}

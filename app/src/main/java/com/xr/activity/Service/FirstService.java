package com.xr.activity.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class FirstService extends Service {
    private static final String TAG = "FirstService";
    public FirstService() {
    }
    public void test(int i){
        if(i==1) {
            Toast.makeText(getApplicationContext(), "哈哈，我是Toast", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "哈哈，我不是Toast", Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
    private class MyBinder extends Binder implements Iservice{

        @Override
        public void callTest(int i) {
            test(i);
        }
    }
}

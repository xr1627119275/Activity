package com.xr.activity.Service;


import android.app.Service;
import android.content.Intent;

import android.os.Binder;
import android.os.IBinder;


import android.os.RemoteException;
import android.util.Log;

import com.xr.activity.IMyAidlInterface;


public class RemoteService extends Service {
    private static final String TAG = "RemoteService";
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public void testMethod(){
        Log.d(TAG, "111testMethod: ");

    }

    private class MyBinder extends IMyAidlInterface.Stub {


        @Override
        public void callTest(int i) throws RemoteException {
            testMethod();
        }

    }
}

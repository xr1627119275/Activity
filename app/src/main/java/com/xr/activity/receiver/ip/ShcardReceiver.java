package com.xr.activity.receiver.ip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ShcardReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.MEDIA_UNMOUNTED")){
            Toast.makeText(context,"卸载了",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"挂载了",Toast.LENGTH_SHORT).show();

        }
    }
}

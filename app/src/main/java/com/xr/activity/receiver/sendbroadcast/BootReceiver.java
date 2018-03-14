package com.xr.activity.receiver.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.xr.activity.Service.PhoneService;
import com.xr.activity.receiver.ip.Main4Activity;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(Intent.ACTION_BOOT_COMPLETED.equals(action)){
            Toast.makeText(context,"开机了",Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(context, PhoneService.class);
            context.startService(intent);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
    }
}

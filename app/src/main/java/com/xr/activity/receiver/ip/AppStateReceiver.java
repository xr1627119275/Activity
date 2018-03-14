package com.xr.activity.receiver.ip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AppStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(Intent.ACTION_INSTALL_PACKAGE.equals(action)){
            Toast.makeText(context,"安装"+intent.getData(),Toast.LENGTH_SHORT).show();
        }else if(Intent.ACTION_PACKAGE_ADDED.equals(action)){
            Toast.makeText(context,"安装--"+intent.getData(),Toast.LENGTH_SHORT).show();
        }else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
            Toast.makeText(context, "卸载" + intent.getData(), Toast.LENGTH_SHORT).show();
        }
    }
}

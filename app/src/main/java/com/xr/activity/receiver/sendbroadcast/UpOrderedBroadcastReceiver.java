package com.xr.activity.receiver.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UpOrderedBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String content = getResultData();
        Toast.makeText(context,1000+content,Toast.LENGTH_SHORT).show();
        setResultData("哈哈哈");
        abortBroadcast();//终止广播
    }
}

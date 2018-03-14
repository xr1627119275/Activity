package com.xr.activity.receiver.ip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by 16271 on 2018/3/8.
 */

public class OutGoingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences config = context.getSharedPreferences("config", 0);
        String ipnumber = config.getString("ipnumber", "");
        String resultData = getResultData();
        setResultData(ipnumber+resultData);
        Toast.makeText(context,resultData,Toast.LENGTH_LONG).show();
    }
}

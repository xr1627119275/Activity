package com.xr.activity.Notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xr.activity.R;

public class NotificationActivity extends AppCompatActivity {

    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void click1(View view) {
        Notification.Builder builder =new Notification.Builder(this);
        builder.setContentTitle("我是大标题")
                .setContentText("我是内容")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background));

//        Notification notification = new Notification(R.drawable.ic_launcher_background,"接收到了一条通知",System.currentTimeMillis());
//
//
        nm.notify(10,builder.build());
//        NewMessageNotification.notify(this,"haha",1);

    }

    public void click2(View view) {
        NewMessageNotification.cancel(this);
    }
}

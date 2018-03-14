package com.xr.activity;

import android.Manifest;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class SmsBackupActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    private static final String TAG = "SmsBackupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_backup);
        String[] perms ={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_SMS,Manifest.permission.SEND_SMS};
        if(EasyPermissions.hasPermissions(this,perms)){
            Log.d(TAG, "以获取权限");
        }else {
            EasyPermissions.requestPermissions(this, "必要的权限", 0, perms);
        }
    }

    public void backup(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {


        XmlSerializer serializer = Xml.newSerializer();
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "smsbackup.xml");
//        File file = new File(getFileStreamPath("smsbackup.xml").getPath());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            serializer.setOutput(fileOutputStream, "utf-8");
            serializer.startDocument("utf-8", true);
            Uri uri = Uri.parse("content://sms/");
            Cursor cursor = getContentResolver().query(uri, new String[]{"address", "date", "body"}, null, null, null);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            serializer.startTag(null, "smss");

            while (cursor.moveToNext()) {

                serializer.startTag(null,"sms");
                serializer.startTag(null,"address");
                String address = cursor.getString(0);
                serializer.text(address);
                serializer.endTag(null,"address");
                serializer.startTag(null,"date");
                String date = cursor.getString(1);
                serializer.text(format.format(Long.parseLong(date)));
                serializer.endTag(null,"date");
                serializer.startTag(null,"body");
                String body = cursor.getString(2);

                serializer.text(URLEncoder.encode(body,"utf-8"));

                serializer.endTag(null,"body");
                serializer.endTag(null,"sms");

//                Log.d(TAG, "backup: " + address + "--" + format.format(Long.parseLong(date)) + "--" + body);
            }
            serializer.endTag(null, "smss");
            serializer.endDocument();
            fileOutputStream.close();
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            }
        }).start();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //把申请权限的回调交由EasyPermissions处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    public void insert(View view) {
        Uri uri = Uri.parse("content://sms/");
        ContentValues values = new ContentValues();
        values.put("address","10086");
        values.put("body","you");
        values.put("date",System.currentTimeMillis());
        Uri uri1 = getContentResolver().insert(uri, values);
        Toast.makeText(getApplicationContext(),uri1.toString(),Toast.LENGTH_SHORT).show();
    }
}

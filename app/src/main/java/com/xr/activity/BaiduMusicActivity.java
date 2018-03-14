package com.xr.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.xr.activity.Service.MusicIService;
import com.xr.activity.Service.MusicService;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class BaiduMusicActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    private static final String TAG = "BaiduMusicActivity";
    private Intent intent;
    private Myconn myconn;
    private MusicIService iService;
    private static SeekBar seekBar1;
    @SuppressLint("HandlerLeak")
    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            int duration = data.getInt("duration");
            int currentPosition = data.getInt("currentPosition");
            seekBar1.setMax(duration);
            seekBar1.setProgress(currentPosition);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_music);
        seekBar1 = findViewById(R.id.seekBar1);
        String[] perms ={Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(EasyPermissions.hasPermissions(this,perms)){
            Log.d(TAG, "以获取权限");
        }else {
            EasyPermissions.requestPermissions(this, "必要的权限", 0, perms);
        }
        intent = new Intent(this, MusicService.class);
        startService(intent);
        myconn = new Myconn();
        bindService(intent,myconn,BIND_AUTO_CREATE);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                iService.callSeekToPostion(progress);
            }
        });
    }

    //播放
    public void click1(View view) {
        iService.callPlayMusic();
    }

    //暂停
    public void click2(View view) {
        iService.callPauseMusic();
    }

    //重新播放
    public void click3(View view) {
        iService.callRePlayMusic();
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

    class Myconn implements ServiceConnection{



        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iService = (MusicIService) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    protected void onDestroy() {
        unbindService(myconn);
        super.onDestroy();
    }
}

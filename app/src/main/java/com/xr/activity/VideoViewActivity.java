package com.xr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;

public class VideoViewActivity extends AppCompatActivity {

    private VideoView vv;
    private io.vov.vitamio.widget.VideoView vitamio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        if(!LibsChecker.checkVitamioLibs(this)){

            return;
        }
//        vv = findViewById(R.id.vv);
        vitamio = findViewById(R.id.vitamio);
        vitamio.setVideoPath("/sdcard/cc.MP4");
        vitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vitamio.start();
            }
        });
                vitamio.setMediaController(new MediaController(getApplicationContext()));
//        vv.setVideoPath("/sdcard/cc.MP4");
//        vv.start();
    }

}

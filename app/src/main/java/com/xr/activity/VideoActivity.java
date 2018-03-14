package com.xr.activity;

import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class VideoActivity extends AppCompatActivity {

    private SurfaceView sfv;
    private int currentPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        sfv = findViewById(R.id.sfv);

        
        final SurfaceHolder holder = sfv.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            private MediaPlayer mediaPlayer;

            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("/sdcard/cc.MP4");
                    mediaPlayer.setDisplay(holder);
                    mediaPlayer.prepareAsync();

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                            mediaPlayer.seekTo(currentPosition-1000);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    currentPosition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.stop();
                }
            }
        });


    }

}


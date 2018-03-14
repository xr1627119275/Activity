package com.xr.activity.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.xr.activity.BaiduMusicActivity;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer player;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        player = new MediaPlayer();

        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new Mybinder();
    }
    public void playInteMusic(){
        try {
            player.reset();
            player.setDataSource("http://119.29.219.137/xpg.mp3");
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.start();
                }
            });

            updateSeekBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playMusic() {
        try {
            player.reset();

            player.setDataSource("/sdcard/xpg.mp3");
            player.prepare();
            player.start();
            updateSeekBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateSeekBar() {
        final int duration = player.getDuration();
        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int currentPosition = player.getCurrentPosition();
                Message message = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putInt("duration",duration);
                bundle.putInt("currentPosition",currentPosition);
                message.setData(bundle);
                BaiduMusicActivity.handler.sendMessage(message);
            }
        };
        timer.schedule(timerTask,0,1000);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                timer.cancel();
                timerTask.cancel();
            }
        });
    }

    public void pauseMusic() {
        player.pause();
        Log.d(TAG, "111pauseMusic: ");
    }

    public void rePlayMusic() {
        player.start();
        Log.d(TAG, "111rePlayMusic: ");
    }
    public void seekToPostion(int position){
        player.seekTo(position);
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    private class Mybinder extends Binder implements MusicIService {

        @Override
        public void callPlayMusic() {
            playMusic();
        }

        @Override
        public void callPauseMusic() {
            pauseMusic();
        }

        @Override
        public void callRePlayMusic() {
            rePlayMusic();
        }

        @Override
        public void callSeekToPostion(int position) {
            seekToPostion(position);
        }
    }

}

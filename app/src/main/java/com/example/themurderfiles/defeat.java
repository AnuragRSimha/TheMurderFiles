package com.example.themurderfiles;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class defeat extends Service {
    MediaPlayer music;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this, R.raw.defeat);
        music.setLooping(true); // Set looping
        music.setVolume(100, 100);
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        music.start();
        return startId;
    }
    @Override
    public void onDestroy() {
        music.stop();
        music.release();
    }
    @Override
    public void onLowMemory() {
    }
}

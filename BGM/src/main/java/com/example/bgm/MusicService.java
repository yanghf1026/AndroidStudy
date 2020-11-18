package com.example.bgm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    public MusicService() {
    }
    static boolean isplay; //定义当前播放状态
    MediaPlayer player; //MediaPlayer对象
    @Override
    public IBinder onBind(Intent intent) { //必须实现的绑定方法
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this,R.raw.music); //创建MediaPlayer对象并加载播放的音乐文件
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying()){ //如果没有播放音乐
            player.start(); //播放音乐
            isplay = player.isPlaying(); //当前状态正在播放音乐
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        isplay = player.isPlaying();
        player.release();
        super.onDestroy();
    }
}

package com.example.bgm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageButton btn_play = (ImageButton) findViewById(R.id.btn_play);//获取“播放/停止”按钮
        //启动Service与停止Service，实现播放背景音乐与停止播放背景音乐
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MusicService.isplay == false){ //判断音乐播放的状态
                    //启动Service，从而实现播放背景音乐
                    startService(new Intent(MainActivity.this,MusicService.class));
                    //更换背景音乐播放图标
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.play,null));
                }else{
                    //停止Service，从而实现停止播放背景音乐
                    stopService(new Intent(MainActivity.this,MusicService.class));
                    //更换停止背景音乐图标
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.stop,null));
                }
            }
        });
    }

    @Override
    protected void onStart() { //实现进入界面时，启动背景音乐Service
        startService(new Intent(MainActivity.this,MusicService.class)); //启动Service，从而实现播放背景音乐
        super.onStart();
    }
}

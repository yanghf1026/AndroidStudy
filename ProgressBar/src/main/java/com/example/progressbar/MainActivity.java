package com.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final int TIME = 60;
    final int TIME_MSG = 0x001;
    private ProgressBar timer;
    private int mProgressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer); //获取进度条组件
        handler.sendEmptyMessage(TIME_MSG); //启动进度条
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(TIME - mProgressStatus > 0){ //当前进度大于0
                mProgressStatus++; //进度+1
                timer.setProgress(TIME - mProgressStatus); //更新进度
                handler.sendEmptyMessageDelayed(TIME_MSG,1000); //一秒后发送消息
            }else{
                //提示时间已到
                Toast.makeText(MainActivity.this,"时间到！游戏结束！",Toast.LENGTH_SHORT).show();
            }
        }
    };
}

package com.example.time;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Chronometer ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ch = findViewById(R.id.ch);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setFormat("%s");
        ch.start();
        //添加监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //判断时间达到60秒的时候
                if(SystemClock.elapsedRealtime() - ch.getBase() >= 60000){
                    ch.stop();//停止计时器
                    Toast.makeText(MainActivity.this,"你的时间用光啦！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

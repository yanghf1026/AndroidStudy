package com.example.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button mButton = null;
    private IntentFilter mIntentFilter = null;
    private MyBroadcastReceiver mMyBroadcastRecvier = null;
    TimePicker timePicker;//时间拾取器
    Calendar c;//日历对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //过滤器
        mIntentFilter = new IntentFilter("yhf");
        //创建广播接受者的对象
        mMyBroadcastRecvier = new MyBroadcastReceiver();
        //注册广播接受者的对象
        registerReceiver(mMyBroadcastRecvier,mIntentFilter);
        mButton = findViewById(R.id.Broadcast);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("yhf");

                //发送一个广播
                sendBroadcast(intent);
            }
        });
        c = Calendar.getInstance();//获取日历对象
        timePicker = findViewById(R.id.timePicker1);//获取时间拾取组件
        timePicker.setIs24HourView(true);//设置使用24小时制
        Button button = findViewById(R.id.button);//获取设置闹钟按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlarmActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this
                        ,0,intent,0);
                //获取AlarmManager对象
                AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                c.set(Calendar.HOUR_OF_DAY,timePicker.getHour());    // 设置闹钟的小时数
                c.set(Calendar.MINUTE,timePicker.getMinute());      // 设置闹钟的分钟数
                c.set(Calendar.SECOND,0);                                      // 设置闹钟的秒数
                alarm.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);//设置一个闹钟

                Toast.makeText(MainActivity.this,"闹钟设置成功",Toast.LENGTH_SHORT).show();//显示一个消息提示
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消广播接受者的注册
        unregisterReceiver(mMyBroadcastRecvier);
    }

}

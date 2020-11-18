package com.example.time;

import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private



    TimePicker timePicker; // 定义时间选择器
    int mHour;
    int mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        Calendar calendar = Calendar.getInstance();
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.mHour = hourOfDay;
                MainActivity.this.mMinute = minute;
                show(hourOfDay,minute);
            }
        });
    }

    private void show(int hourOfDay, int minute) {
        String str = hourOfDay+"时"+minute+"分";
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
}

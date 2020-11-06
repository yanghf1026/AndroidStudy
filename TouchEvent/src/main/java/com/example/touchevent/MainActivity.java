package com.example.touchevent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取相对布局管理器
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        final HatView hat = new HatView(MainActivity.this);//创建并实例化HatView对象
        //为帽子添加触摸事件监听
        hat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hat.bitmapX = event.getX() -250;
                hat.bitmapY = event.getY() -100;
                hat.invalidate(); //重绘hat组件
                return true;
            }
        });
        relativeLayout.addView(hat);//将hat添加到布局管理器
    }
}

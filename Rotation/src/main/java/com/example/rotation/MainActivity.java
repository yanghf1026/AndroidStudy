package com.example.rotation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final int FLAG_MSG = 0x001; //定义要发送的消息
    private ViewFlipper flipper; //定义ViewFlipper
    private Message message; //声明消息对象
    //定义图片数组
    private int[] images = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
    private Animation[] animation = new Animation[2]; //定义动画数组，为ViewFlipper指定切换动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.viewFlipper);
        for(int i = 0 ;i < images.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        animation[1] = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        flipper.setInAnimation(animation[0]);
        flipper.setOutAnimation(animation[1]);
        message= Message.obtain(); //获得消息对象
        message.what = FLAG_MSG; //设置消息代码
        handler.sendMessage(message); //发送消息
        LooperThread thread = new LooperThread(); //创建一个线程
        thread.start(); //开启线程

    }
    Handler handler = new Handler(){ //创建Android.os.Handler对象


        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == FLAG_MSG){
                flipper.showPrevious(); //显示下一个动画和图片
            }
            message = handler.obtainMessage(FLAG_MSG);
            handler.sendMessageDelayed(message,3000); //延迟三秒发送信息
        }
    };
}

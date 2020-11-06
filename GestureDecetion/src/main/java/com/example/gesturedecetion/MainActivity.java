package com.example.gesturedecetion;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    ViewFlipper flipper;
    GestureDetector detector;//定义手势检测器
    Animation[] animation = new Animation[4];//定义动画数组，为ViewFlipper指定切换动画
    final int distance = 50;//定义手势动作两点之间的最小距离
    //定义图片数组
    private int[] images = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(this,this);//创建手势检测器
        flipper = findViewById(R.id.flipper);
        for(int i = 0;i < images.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        //初始化数组
        animation[0] = AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        animation[1] = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        animation[2] = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        animation[3] = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX() - e2.getX() > distance){
            //为flipper设置切换的动画效果
            flipper.setInAnimation(animation[2]);
            flipper.setOutAnimation(animation[1]);
            flipper.showPrevious();
            return true;
        }else if(e2.getX() - e1.getX() > distance){
            //为flipper设置切换的对象
            flipper.setInAnimation(animation[0]);
            flipper.setOutAnimation(animation[3]);
            flipper.showNext();
            return  true;
        }
        return  false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将该Activity上的触碰事件交给GestureDetector处理
        return detector.onTouchEvent(event);
    }
}

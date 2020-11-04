package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中的导航图片
        ImageView imageView1 = findViewById(R.id.image1);
        ImageView imageView2 = findViewById(R.id.image2);
        ImageView imageView3 = findViewById(R.id.image3);
        ImageView imageView4 = findViewById(R.id.image4);
        imageView1.setOnClickListener(l);//添加单击事件
        imageView2.setOnClickListener(l);
        imageView3.setOnClickListener(l);
        imageView4.setOnClickListener(l);
    }
    //创建单机事件监听器
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();   // 获取Fragment
            FragmentTransaction ft = fm.beginTransaction(); // 开启一个事务
            Fragment f = null; //为Fragment初始化
            switch (v.getId()) {    //通过获取点击的id判断点击了哪个张图片
                case R.id.image1:
                    f = new WeChat_Fragment();
                    break;
                case R.id.image2:
                    f = new Message_Fragment();
                    break;
                case R.id.image3:
                    f = new Find_Fragment();
                    break;
                case R.id.image4:
                    f = new Me_Fragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment, f); //替换Fragment
            ft.commit(); //提交事务
        }
    };
}

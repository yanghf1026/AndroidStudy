package com.example.random;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BinderService binderService; //定义Service类
    //文本组件ID
    int[] tvid = {R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.textView6,R.id.textView7,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_random = findViewById(R.id.btn);
        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List number = binderService.getRandomNumber();
                for(int i = 0;i < number.size();i++){
                    TextView tv = findViewById(tvid[i]);
                    String stuNumber = number.get(i).toString();
                    tv.setText(stuNumber);
                }
            }
        });
    }
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binderService = ((BinderService.MyBinder) service).getService(); //获取后台Service信息
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,BinderService.class);
        bindService(intent,conn,BIND_AUTO_CREATE); //保定指定Service
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn); //解除绑定Service
    }
}

package com.example.presstwice;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private long exitTime = 0; //退出时间变量值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            exit();
            return true; //拦截返回键
        }
        return super.onKeyDown(keyCode,event);
    }

    private void exit() {
        if((System.currentTimeMillis() - exitTime) > 2000){//计算按键时间差是否大于两秒
            Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();

        }else {
            finish();
            System.exit(0); //销毁强制退出
        }
    }
}

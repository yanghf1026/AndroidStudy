package com.example.random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinderService extends Service {
    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder(); //返回MyBinder Service对象
    }

    public class MyBinder extends Binder{
        public BinderService getService(){ //创建获取Service的方法
            return BinderService.this; //返回当前Service类
        }
    }
    public List getRandomNumber(){
        List resArr = new ArrayList(); //创建ArrayList数组
        String strNumber = "";
        for(int i = 0;i < 7;i++){
            //将随机获取的数字转换为字符串添加到ArrayList数组中
            int number = new Random().nextInt(33)+1;
            //把生成的随机数格式化为两位的字符串
            if(number < 10){
                strNumber = "0" + String.valueOf(number);
            }else{
                strNumber = String.valueOf(number);
            }
            resArr.add(strNumber);
        }
        return resArr; //将数组返回
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

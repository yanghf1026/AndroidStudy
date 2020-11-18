package com.example.rotation;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

import android.os.Handler;

public class LooperThread extends Thread {
    public Handler handler;					//声明一个Handler对象
    @Override
    public void run() {
        super.run();
        Looper.prepare();					//初始化Looper对象
        //实例化一个Handler对象
        handler = new Handler() {
            public void handleMessage(Message msg) {
                Log.i("yhf", String.valueOf(msg.what));
            }
        };

        Message m=handler.obtainMessage();	//获取一个消息
        m.what=0x7;						//设置Message的what属性的值
        handler.sendMessage(m);			//发送消息
        Looper.loop();						//启动Looper

    }
}

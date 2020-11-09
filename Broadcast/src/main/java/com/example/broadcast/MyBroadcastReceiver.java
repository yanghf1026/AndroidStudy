package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class MyBroadcastReceiver extends BroadcastReceiver {
    private static  final String action1 = "yhf";
    private static final String action2 = "example";
    @Override
    public void onReceive(Context context, Intent intent) {
       if(intent.getAction().equals(action1)){
           Toast.makeText(context,"接收到了yhf的广播",Toast.LENGTH_SHORT).show();
       }else if (intent.getAction().equals(action2)){
           Toast.makeText(context,"接收到了example广播",Toast.LENGTH_SHORT).show();
       }
    }
}

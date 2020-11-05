package com.example.actionanddata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton = findViewById(R.id.imageButton_phone);
        ImageButton imageButton1 = findViewById(R.id.imageButton_sms);
        imageButton.setOnClickListener(l);
        imageButton1.setOnClickListener(l);
    }
    //创建监听事件对象
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();//创建一个Intent对象
            switch (v.getId()){
                case R.id.imageButton_phone:
                    intent.setAction(intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:17636508231"));
                    startActivity(intent); //启动Activity
                    break;
                case R.id.imageButton_sms:
                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:5554"));
                    intent.putExtra("sms_body","Welcome to Android!");
                    startActivity(intent);
            }
        }
    };
}

package com.example.imagebutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        Button button = findViewById(R.id.button);//通过ＩＤ获取布局按钮
        //为按钮添加单击事件监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchActivity.this,GrantActivity.class);
                startActivity(intent);
            }
        });
    }
}

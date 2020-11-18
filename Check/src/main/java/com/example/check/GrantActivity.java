package com.example.check;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GrantActivity extends AppCompatActivity {
    Button btn_login;///定义登录按钮
    CheckBox checkBox1,checkBox2,checkBox3;//定义复选框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant);
        //通过ID获取登录按钮和复选框
        btn_login = findViewById(R.id.btn_login);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkBox3);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checked = "";//保存选中的值
                if (checkBox1.isChecked()) {
                    checked += checkBox1.getText().toString();
                }
                if (checkBox2.isChecked()) {
                    checked += checkBox2.getText().toString();
                }
                if (checkBox3.isChecked()) {
                    checked += checkBox3.getText().toString();
                }
                //显示被选中的复选框对应的信息
                Toast.makeText(GrantActivity.this, checked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

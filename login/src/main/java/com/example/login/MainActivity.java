package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String mr = "mr",mrsoft = "mrsoft";//定义后台账号与密码
    private String username,password;//输入的账号和密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("yhf","onCreate");
        setContentView(R.layout.activity_main);
        final EditText usernameET = findViewById(R.id.username);
        final EditText passwordEt = findViewById(R.id.password);
        ImageButton login = findViewById(R.id.login);
        //获得SharedPreferences,并创建名称为“mrsoft“
        final SharedPreferences sp = getSharedPreferences("mrsoft",MODE_PRIVATE);
        if(sp.getString("username",username)!= null && sp.getString("password",password)!=null){
            //存在就判断账号密码与后台是否相同，相同就直接登录
            if(sp.getString("username",username).equals(mr)&&sp.getString("password",password).equals(mrsoft)){
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);//通过Intent跳转登录后界面
                startActivity(intent);//启动跳转页面
            }
        }else{
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username = usernameET.getText().toString();//获取输入的账号密码
                    password = passwordEt.getText().toString();
                    SharedPreferences.Editor editor = sp.edit();//获得Editor对象，用于存储账号与密码信息
                    if(username.equals(mr)&&password.equals(mrsoft)){
                        Toast.makeText(MainActivity.this,"账号、密码正确",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MessageActivity.class);//通过Intent跳转到登录后界面
                        startActivity(intent);
                        editor.putString("username",username);
                        editor.putString("password",password);
                        editor.commit();
                        Toast.makeText(MainActivity.this,"已保存账号密码 ",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("yhf","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("yhf","onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("yhf","onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("yhf","onStop");
    }
}

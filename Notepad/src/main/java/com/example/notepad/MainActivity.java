package com.example.notepad;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    byte[] buffer = null;//定义保存数据的数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etext = findViewById(R.id.editText);//获取用于填写记事本信息的编辑框组件
        ImageButton btn_save = findViewById(R.id.btn_save);//保存按钮
        ImageButton btn_cancel = findViewById(R.id.btn_cancel);//取消按钮
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null; //定义文件输出流
                String text = etext.getText().toString();//获取文本信息

                try {
                    fos = openFileOutput("memo",MODE_PRIVATE);//获得文件输出流，，并指定文件保存位置
                    fos.write(text.getBytes());//保存文本信息
                    fos.flush();//清除换成
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos != null){ //输出流不为空时
                        try {
                            fos.close();//关闭文件输出流
                            Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        });
        FileInputStream fis = null;//定义文件输入流
        try {
            fis = openFileInput("memo");
            buffer = new byte[fis.available()];//保存数据的数组
            fis.read(buffer); //保存数据的数组
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){ //当输入流不为空时
                try {
                    fis.close();
                    String data = new String(buffer); //获得数组中保存的数据
                    etext.setText(data); //将读取的数据保存在编辑框中
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //退出应用
            }
        });
    }
}

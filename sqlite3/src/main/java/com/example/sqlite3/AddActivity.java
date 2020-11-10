package com.example.sqlite3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper; //定义DBOpenHelper，用于数据库链接
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbOpenHelper = new DBOpenHelper(AddActivity.this,"dict.db",null,1);
        final EditText etWord = findViewById(R.id.add_word); //获取添加单词的编辑框
        final EditText etExplain = findViewById(R.id.add_interpret); //获取添加解释的编辑框
        ImageButton btn_Save = findViewById(R.id.save_btn); //获取保存按钮
        ImageButton btn_Cancel = findViewById(R.id.cancel_btn1); //获取取消按钮
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = etWord.getText().toString(); //获取填写的生词
                String explain = etExplain.getText().toString(); //获取填写的解释
                if(word.equals("")||explain.equals("")){
                    //如果填写的单词或者解释为空时
                    Toast.makeText(AddActivity.this,"填写的单词或解释为空",Toast.LENGTH_SHORT).show();
                }else {
                    //调用insertData()方法，实现插入生词数据
                    insertData(dbOpenHelper.getReadableDatabase(),word,explain);
                    //显示提示信息
                    Toast.makeText(AddActivity.this,"添加生词成功！",Toast.LENGTH_LONG).show();

                }
            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void insertData(SQLiteDatabase readableDatabase,String word,String explain){
        ContentValues values = new ContentValues();
        values.put("word",word); // 保存单词
        values.put("detail",explain); //保存解释
        readableDatabase.insert("dict" ,null,values); //执行插入操作
    }
}

package com.example.sqlite3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper;//定义DBOpenHelper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbOpenHelper = new DBOpenHelper(MainActivity.this,"dict.db",null,1);
        final ListView listView = findViewById(R.id.result_listView); //获取显示结果的ListView
        final EditText etSearch = findViewById(R.id.search_et); //获取查询内容的编辑框
        ImageButton btnSearch = findViewById(R.id.search_btn); //获取查询按钮
        Button btn_add = findViewById(R.id.btn_add); //获取跳转添加生词界面的按钮
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class); //通过Intent跳转添加生词界面
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = etSearch.getText().toString(); //获取要查询的单词
                Cursor cursor = dbOpenHelper.getReadableDatabase().query("dict",null,"word = ?",new String[]{key},null,null,null);
                //创建ArrayList对象，用于保存查询结果
                ArrayList<Map<String , String >> resultlist = new ArrayList<Map<String ,String >>();
                while (cursor.moveToNext()){ //遍历Cursor结果集
                    Map<String,String> map = new HashMap<>(); //将结果集的数据存入ArrayList中
                    map.put("word",cursor.getString(1));
                    map.put("interpret",cursor.getString(2));

                    resultlist.add(map);

                }if(resultlist == null || resultlist.size() == 0){ //如果数据库中没有数据
                    //显示提示信息，没有相关记录
                    Toast.makeText(MainActivity.this,"很遗憾，没有相关记录！",Toast.LENGTH_SHORT).show();
                }else{
                    //否则将查询的结果显示到ListView列表中
                    SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,resultlist,R.layout.result_main,new String[]{"word","interpret"}, new int[]{R.id.result_word,R.id.result_interpret});
                    listView.setAdapter(simpleAdapter);
                }

            }
        });
    }
    @Override
    protected void onDestroy() {  //实现退出应用时，关闭数据库连接
        super.onDestroy();
        if (dbOpenHelper != null) {   //如果数据库不为空时
            dbOpenHelper.close();     //关闭数据库连接
        }
    }
}

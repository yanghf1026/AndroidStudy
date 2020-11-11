package com.example.phonebook;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String columns = ContactsContract.Contacts.DISPLAY_NAME; //希望获得姓名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.result); //获得布局文件中的TextView组件
        tv.setText(getQueryData()); //为TextView设置数据
    }

    private CharSequence getQueryData() { //创建getQueryData()方法，实现获取通讯录信息
        StringBuilder sb = new StringBuilder(); //用于保存字符串
        ContentResolver resolver = getContentResolver(); //获得ContentResolver对象
        //查询记录
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int displayNameIndex = cursor.getColumnIndex(columns); //获得姓名记录的索引值
        //迭代全部记录
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String displayName = cursor.getString(displayNameIndex);
            sb.append(displayName + "\n");
        }
        cursor.close(); //关闭Cursor
        return sb.toString(); //返回查询结果
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

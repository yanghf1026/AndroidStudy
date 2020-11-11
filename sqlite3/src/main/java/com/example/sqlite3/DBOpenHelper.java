package com.example.sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    //定义创建数据表dict的SQL语句
    final String CREATE_TABLE_SQL = "create table dict(_id integer primary key autoincrement , word ,detail)";

    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version); //重写构造方法并设置工厂为null
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL); //创建单词信息表
    }
    //重写基类的onUpgrade()方法，以便数据库版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("---版本更新---" + oldVersion + "--->" + newVersion);
    }
}

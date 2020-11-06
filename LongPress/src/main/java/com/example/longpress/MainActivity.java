package com.example.longpress;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            //创建长按监听事件
            @Override
            public boolean onLongClick(View v) {
                registerForContextMenu(v);//将长按事件注册到菜单中
                openContextMenu(v);//打开菜单
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//创建菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        //菜单添加参数
        menu.add("收藏");
        menu.add("举报");
    }
}

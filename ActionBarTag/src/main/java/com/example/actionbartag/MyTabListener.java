package com.example.actionbartag;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MyTabListener implements ActionBar.TabListener {
    private Fragment fragment;
    private final Activity activity; //定义Activity
    private final Class aClass; //定义Class

    public MyTabListener(Activity activity, Class aClass) { //添加构造函数
        this.activity = activity;
        this.aClass = aClass;
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(fragment == null){
            fragment = Fragment.instantiate(activity,aClass.getName());
            ft.add(android.R.id.content, fragment, null);
        }
        ft.attach(fragment); //显示新画面
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(fragment != null){
            ft.detach(fragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

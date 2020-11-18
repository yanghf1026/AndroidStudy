package com.example.actionbarback;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        if (NavUtils.getParentActivityName(FriendsActivity.this) != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //显示向左的箭头图标
        }
    }
}
;
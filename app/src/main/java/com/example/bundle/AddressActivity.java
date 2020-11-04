package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        TextView site=(TextView) findViewById(R.id.site);
        TextView name=(TextView)findViewById(R.id.name);
        TextView phone=(TextView)findViewById(R.id.phone);
        site.setText(bundle.getString("sate"));
        phone.setText(bundle.getString("phone"));
        name.setText(bundle.getString("name"));
    }
}

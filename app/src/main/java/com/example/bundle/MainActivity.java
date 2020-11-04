package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String sate1 = ((EditText)findViewById(R.id.site1)).getText().toString();
            String sate2 = ((EditText)findViewById(R.id.site2)).getText().toString();
            String sate3 = ((EditText)findViewById(R.id.site3)).getText().toString();
            String phone=((EditText)findViewById(R.id.phone)).getText().toString();
            String name=((EditText)findViewById(R.id.name)).getText().toString();
                if(!"".equals(sate1)&&!"".equals(sate2)&&!"".equals(sate3)&&!"".equals(phone)&&!"".equals(name)){
                    Intent intent=new Intent(MainActivity.this,AddressActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("phone",phone);
                    bundle.putString("sate",sate1+sate2+sate3);
                    intent.putExtra("bundle",bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"请将信息填写完整",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

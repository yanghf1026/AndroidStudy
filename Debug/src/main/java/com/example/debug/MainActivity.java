package com.example.debug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public static void main(String[] args) {
        double a = random();
        double b = random();
        System.out.println("a= "+a +"b= "+b);
//        Log.i("Demo","a="+a +"b="+b);
    }
}


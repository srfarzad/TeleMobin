package com.mobinone.telemobin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.e("LifeCycle About","OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle About","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle About","onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle About","onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle About","onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle About","onPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle About","onResume");
    }


}

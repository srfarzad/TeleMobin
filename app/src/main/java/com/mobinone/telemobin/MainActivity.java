package com.mobinone.telemobin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView img=findViewById(R.id.img_slider);

        TextView txt_best_videos=findViewById(R.id.txt_best_videos);



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Hi Android",Toast.LENGTH_LONG).show();

                Log.e("MainLog","Hiiiiiiiiiiiiiiiii");

            }
        });


        txt_best_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(getApplicationContext(),AboutActivity.class);

                startActivity(intent);

            }
        });


        Log.e("LifeCycle","OnCreate");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle","onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle","onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle","onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle","onPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle","onResume");
    }
}

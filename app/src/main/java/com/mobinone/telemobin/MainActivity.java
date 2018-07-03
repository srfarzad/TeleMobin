package com.mobinone.telemobin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            toolbar=findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle("");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_about:

                Intent intent=new Intent(getApplicationContext(),
                        AboutActivity.class);

                startActivity(intent);


                break;

            case R.id.item_contact:


                Intent call_intent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0912365"));
                //Intent call_intent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:0912365"));
                startActivity(call_intent);


                break;

            case R.id.item_exit:

                finish();

                break;
            case R.id.item_website:

                //webview
                Intent website_intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.p30droid.com"));
                startActivity(website_intent);
                break;




        }

        return super.onOptionsItemSelected(item);
    }
}

package com.mobinone.telemobin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
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

import com.mobinone.telemobin.activities.RegisterActivity;
import com.mobinone.telemobin.database.TelemobinDb;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    NavigationView navigation_view;

    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            toolbar=findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle("");


            TelemobinDb telemobinDb=new TelemobinDb(getApplicationContext());

        navigation_view=findViewById(R.id.navigation_view);
        drawer=findViewById(R.id.drawer);
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

        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.item_joing_tl:

                        Intent intent=new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://tl.me/p30droid"));

                        startActivity(intent);

                        break;

                    case R.id.item_login:


                        DialogUtils.onLogin(MainActivity.this);


                        break;

                    case R.id.item_register:

                        Intent intent_register=new Intent(getApplicationContext(),
                                RegisterActivity.class);

                        startActivity(intent_register);

                        break;





                }

                return false;
            }
        });


        ActionBarDrawerToggle actionBr=new
                ActionBarDrawerToggle(MainActivity.this,
                drawer,toolbar,R.string.open,R.string.close);


        actionBr.syncState();




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


    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert=new
                AlertDialog.Builder(MainActivity.this);

        alert.setTitle(getResources().getString(R.string.exit_title));
        alert.setMessage(getResources().getString(
                R.string.exit_message
        ));

        alert.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        alert.setPositiveButton(getResources().getString(
                R.string.yes
        ), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        alert.setNeutralButton(getResources().getString(R.string.no), new
                DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });



                alert.show();
        //super.onBackPressed();
    }
}

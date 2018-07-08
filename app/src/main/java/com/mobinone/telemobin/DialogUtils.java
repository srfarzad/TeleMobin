package com.mobinone.telemobin;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogUtils {


    public static void onLogin(final Activity activity){



        AlertDialog.Builder loginDialog=new
                AlertDialog.Builder(activity);


        LayoutInflater inflater=LayoutInflater.from(activity);
        View custom_view=inflater.inflate(R.layout.login_layout,null);

        loginDialog.setView(custom_view);


        final EditText edt_username=custom_view.findViewById(R.id.edt_username);

        final EditText edt_password=custom_view.findViewById(R.id.edt_password);


        Button btn_login=custom_view.findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user=edt_username.getText().toString();

                String pass=edt_password.getText().toString();

                if(user.equals("android") && pass.equals("123")){

                    Toast.makeText(activity,activity.getResources().getString(R.string.login_succefull),Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(activity,activity.getResources().getString(R.string.errot_login),Toast.LENGTH_LONG).show();
                }


            }
        });


        loginDialog.show();



    }

}

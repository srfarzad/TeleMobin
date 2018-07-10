package com.mobinone.telemobin.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mobinone.telemobin.R;
import com.mobinone.telemobin.database.UserDbAdapter;
import com.mobinone.telemobin.models.Users;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {


    @BindView(R.id.input_email)EditText input_email;
    @BindView(R.id.input_password)EditText input_password;
    @BindView(R.id.btn_login)Button btn_login;
    @BindView(R.id.linear_main)LinearLayout linear_main;

    UserDbAdapter userDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        userDbAdapter=new UserDbAdapter(this);

    }

    @OnClick(R.id.btn_login)
    public void btn_login_click(){

        Users users=new Users();
        users.setUserName(input_email.getText().toString());
        users.setPassword(input_password.getText().toString());
      long res= userDbAdapter.insertUser(users);

      if(res>0){

          Snackbar.make(linear_main,getResources().getString(R.string.register_succefull)
          ,Snackbar.LENGTH_LONG).show();

      }
      else {
          Snackbar.make(linear_main,getResources().getString(R.string.register_error)
                  ,Snackbar.LENGTH_LONG).show();
      }


    }


}

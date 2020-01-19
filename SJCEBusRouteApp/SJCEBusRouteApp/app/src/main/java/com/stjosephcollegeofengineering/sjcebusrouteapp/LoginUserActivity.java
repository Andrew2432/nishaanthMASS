package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginUserActivity extends AppCompatActivity {
    private Button btnUserSignIn, btnUserSignUp, btnUserCompReg, btnUserBack;
    private EditText etStuStaffID, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        btnUserBack = (Button) findViewById(R.id.loginUserBtnBack);
        btnUserSignUp = (Button)findViewById(R.id.loginUserBtnSignUp);
        btnUserCompReg = (Button)findViewById(R.id.loginUserBtnCompReg);

        etStuStaffID = (EditText)findViewById(R.id.loginUserInputIDEt);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etStuStaffID.requestFocus();
            }
        }, 750);


        btnUserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.stjosephcollegeofengineering.sjcebusrouteapp.LoginActivity.class);
                startActivity(intent);
            }
        });

        btnUserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnUserCompReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterVerifyActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}

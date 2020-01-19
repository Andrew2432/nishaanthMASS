package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginDriverActivity extends AppCompatActivity {
    private Button btnDriverBack;
    private EditText etBusNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_driver);

        etBusNo = (EditText)findViewById(R.id.loginDriverBusEt);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etBusNo.requestFocus();
            }
        }, 750);

        btnDriverBack = (Button)findViewById(R.id.loginDriverBtnBack);
        btnDriverBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

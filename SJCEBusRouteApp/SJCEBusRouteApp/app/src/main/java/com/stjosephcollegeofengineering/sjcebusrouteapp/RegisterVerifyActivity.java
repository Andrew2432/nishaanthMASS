package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterVerifyActivity extends AppCompatActivity {
    private Button btnRegVerBack;
    private EditText etRegVerAck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_verify);

        btnRegVerBack = (Button)findViewById(R.id.registerVerifyBtnBack);

        etRegVerAck = (EditText)findViewById(R.id.registerVerifyACKEt);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etRegVerAck.requestFocus();
            }
        }, 750);


        btnRegVerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.stjosephcollegeofengineering.sjcebusrouteapp.LoginUserActivity.class);
                startActivity(intent);
            }
        });

    }
}

package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stjosephcollegeofengineering.sjcebusrouteapp.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginDriver, loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginDriver = (Button)findViewById(R.id.loginButtonDriver);
        loginUser = (Button)findViewById(R.id.loginButtonUser);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginUserActivity.class);
                startActivity(intent);
            }
        });

        loginDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginDriverActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

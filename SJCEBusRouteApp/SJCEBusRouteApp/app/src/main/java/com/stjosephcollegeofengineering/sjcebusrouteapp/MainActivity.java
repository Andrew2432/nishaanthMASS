package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ImageView splashScreenLogo;
    private TextView splashScreenTitle;
    private Animation splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashScreenLogo = (ImageView) findViewById(R.id.splash_screen_logo);
        splashScreenTitle = (TextView) findViewById(R.id.splash_screen_title);
        splash = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_screen_main);


        splashScreenLogo.setAnimation(splash);
        splashScreenTitle.setAnimation(splash);

        Thread splashThread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                } finally {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            }
        };
        splashThread.start();
    }
}

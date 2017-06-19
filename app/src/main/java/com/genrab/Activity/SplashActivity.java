package com.genrab.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.genrab.R;
import com.genrab.Untils.Credentials;

/**
 * Created by intel on 6/9/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private Intent intent;
    private int SPLASH_TIME_OUT = 1000;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (Credentials.getSaveUserLogin(SplashActivity.this)) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        handler.postDelayed(runnable, SPLASH_TIME_OUT);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }
}
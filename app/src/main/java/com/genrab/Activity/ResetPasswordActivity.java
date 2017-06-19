package com.genrab.Activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.genrab.R;


/**
 * Created by intel on 6/9/2017.
 */

public class ResetPasswordActivity extends AppCompatActivity {
    EditText userIdEditText;
    Button loginButton;
    TextView registerTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        //getting the widget id
        init();
        //Using the click listener
        listener();

        //Title
        setTitle("Reset Password");

        //Using the tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //End

        //changing color of back arrow
        Drawable upArrow = ContextCompat.getDrawable(getApplicationContext(), R.mipmap.back);
        upArrow.setColorFilter(ContextCompat.getColor(ResetPasswordActivity.this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void listener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userIdEditText.length() == 0) {
                    userIdEditText.setError("Enter user id/email id...");
                } else {
                    reset();
                }
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(ResetPasswordActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }

    //Here reset password
    private void reset() {

    }

    private void init() {
        //EditText
        userIdEditText = (EditText) findViewById(R.id.etUserId);
        //TextView
        registerTextView = (TextView) findViewById(R.id.txtRegister);
        //Button
        loginButton = (Button) findViewById(R.id.btnLogin);


    }
}

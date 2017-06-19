package com.genrab.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.genrab.R;
import com.genrab.Untils.Credentials;

/**
 * Created by intel on 6/9/2017.
 */

public class LoginActivity extends AppCompatActivity {
    EditText userIdEditText, userPasswordEditText;
    TextView lostpasswordTextView, registerTextView;
    Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Getting the widget Id
        init();
        //using the click listener
        listener();
    }

    private void listener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userIdEditText.length() == 0) {
                    userIdEditText.setError("Enter User Id...");
                } else if (userPasswordEditText.length() == 0) {
                    userPasswordEditText.setError("Enter Password...");
                } else {
                    //Credentials.SaveuserLogin(true,LoginActivity.this);
                    profile();
                }

            }
        });

        //If you are loss the password then pass the intent in reset Password screen...
        lostpasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(resetIntent);
            }
        });

        //If you want to register in app then go to register activity here...
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(resetIntent);
            }
        });
    }

    //Open the user profile here..
    private void profile() {
        //Pass the Intent here to next activity
        Intent mainIntnet = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntnet);
    }

    //getting the widget id here
    private void init() {
        //EditText
        userIdEditText = (EditText) findViewById(R.id.etUserId);
        userPasswordEditText = (EditText) findViewById(R.id.etPassword);
        //TextView
        lostpasswordTextView = (TextView) findViewById(R.id.txtLost);
        registerTextView = (TextView) findViewById(R.id.txtRegisterNow);
        //Button
        loginButton = (Button) findViewById(R.id.btnLogin);

    }

}

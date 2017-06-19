package com.genrab.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.genrab.CustomItem.CountryItem;
import com.genrab.R;
import com.genrab.Untils.Constant;
import com.genrab.Untils.Credentials;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by intel on 6/9/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText firstnameEditText, lastnameEditText, useremail, conformemail, phoneEditText;
    TextView loginTextView;
    Button registerButton;
    Spinner countrySpinner;
    ProgressDialog dialog;
    ArrayList<CountryItem> countryItems = new ArrayList<>();
    private ArrayList<String> countryName = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //Getting the widget id
        init();
        //using the click listener
        listener();

        //Using the tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Title set
        setTitle("Register");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //End

        //changing color of back arrow
        Drawable upArrow = ContextCompat.getDrawable(getApplicationContext(), R.mipmap.back);
        upArrow.setColorFilter(ContextCompat.getColor(RegisterActivity.this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //***********Check the network connectivity here******
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null) && (wifi.isConnected() | datac.isConnected())) {

            //Getting the Spinner Data here..
            getSpinnerData();
        } else {

            //Set the Adapter
            ArrayAdapter<String> adapterCountry = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_item_row);
            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterCountry.add("Country");
            countrySpinner.setAdapter(adapterCountry);

        }

    }


    private void init() {
        //EditText
        firstnameEditText = (EditText) findViewById(R.id.etFirstName);
        lastnameEditText = (EditText) findViewById(R.id.etlastName);
        useremail = (EditText) findViewById(R.id.etUserEmail);
        conformemail = (EditText) findViewById(R.id.etConformEmail);
        phoneEditText = (EditText) findViewById(R.id.etPhone);
        //Spinner
        countrySpinner = (Spinner) findViewById(R.id.spinnerCountry);
        //Button
        registerButton = (Button) findViewById(R.id.btnRegister);
        //TextView
        loginTextView = (TextView) findViewById(R.id.txtLogin);


    }

    private void listener() {
        final String mEmail = useremail.getText().toString();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firstnameEditText.length() == 0) {
                    firstnameEditText.setError("Enter First name...");
                } else if (lastnameEditText.length() == 0) {
                    lastnameEditText.setError("Enter last name...");
                } else if (useremail.length() == 0) {
                    useremail.setError("Enter user email...");
                    if (conformemail.equals(mEmail)) {
                        Toast.makeText(getApplicationContext(), "Match !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Does not match !", Toast.LENGTH_LONG).show();
                    }

                } else if (conformemail.length() == 0) {
                    conformemail.setError("Enter Conform Email..");
                } else if (phoneEditText.length() == 0) {
                    phoneEditText.setError("Enter phone number...");
                } else {
                    //***********Check the network connectivity here******
                    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    android.net.NetworkInfo datac = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    if ((wifi != null & datac != null) && (wifi.isConnected() | datac.isConnected())) {
                        userRegister();
                    } else {
                        //no connection
                        Toast toast = Toast.makeText(RegisterActivity.this, "No Internet Connection", Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
            }
        });

        //if you are allready login then pass the intent in login activty
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pass the Intent here
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    //Get the country data here...
    private void getSpinnerData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.SPINNER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i <= jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String mCountryName = object.optString("name");
                                String mCountryId = object.optString("id");

                                CountryItem countryItem = new CountryItem();
                                countryItem.setCountryId(mCountryId);
                                countryItem.setCountry(mCountryName);
                                countryItems.add(countryItem);
                                countryName.add(mCountryName);

                                //Setting adapter to show the items in the spinner
                                ArrayAdapter<String> adapterStation = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_item_row);
                                adapterStation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                adapterStation.addAll(countryName);
                                countrySpinner.setAdapter(adapterStation);

                                // Spinner on item click listener
                                countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                    @Override
                                    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                                        // TODO Auto-generated method stub
                                        // Locate the textviews in activity_main.xml
                                        String shopId = countryItems.get(position).getCountryId();
                                        Credentials.SaveCountryId(shopId, RegisterActivity.this);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> arg0) {
                                        // TODO Auto-generated method stub
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }
    //**********END**

    private void userRegister() {
        showDialog(true);
        //pass the intent in login activity here....
        final String mFirst = firstnameEditText.getText().toString();
        final String mLast = lastnameEditText.getText().toString();
        final String mEmail = useremail.getText().toString();
        //final String mCountry = countrySpinner.getSelectedItem().toString();
        final String mPhone = phoneEditText.getText().toString();
        final String mCountry = Credentials.getCountryId(RegisterActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showDialog(false);
                        try {
                            JSONObject object = new JSONObject(response);
                            String mMessage = object.optString("message");
                            String mStatus = object.optString("status");
                            String mError = object.optString("error");
                            Log.i("response::", "response::" + response);

                            //Save the token in share preference..
                            //End
                            if (mStatus.equals("200")) {
                                showDialog(false);
                                Toast.makeText(RegisterActivity.this, "Successfully Registered..", Toast.LENGTH_LONG).show();
                                profile();
                                firstnameEditText.setText("");
                                lastnameEditText.setText("");
                                useremail.setText("");
                                conformemail.setText("");
                                phoneEditText.setText("");

                            } else if (mError.equals("Phone numbers already exist.")) {
                                showDialog(false);
                                Toast.makeText(RegisterActivity.this, "Phone numbers already exist..", Toast.LENGTH_LONG).show();
                            } else if (mError.equals("Email already exist.")) {
                                showDialog(false);
                                Toast.makeText(RegisterActivity.this, "Email already exist..", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        showDialog(false);
                        // Toast.makeText(CustomerSignUpActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        Log.i("Error::", "Error::" + error);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(Constant.FIRST_NAME, mFirst);
                map.put(Constant.LAST_NAME, mLast);
                map.put(Constant.USER_EMAIL, mEmail);
                map.put(Constant.USER_COUNTRY, mCountry);
                map.put(Constant.USER_PHONE, mPhone);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showDialog(boolean check) {
        if (check) {
            dialog = ProgressDialog.show(RegisterActivity.this, "", "Loading.....");
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }

    private void profile() {
        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }


}
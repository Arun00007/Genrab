package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genrab.R;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentMultipleAccount extends Fragment {
    LinearLayout editLinearLayout, radioLinearLayout, parentLinearLayout,headerLinearLayout;
    TextView usernameTextView, radioTextView;
    EditText userIdEditText;
    private boolean state = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiple_account, viewGroup, false);
        //Getting the widget Id
        init(view);
        //using the click listener
        listener();
        return view;
    }

    private void listener() {
        editLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state) {
                    state = false;
                    radioLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    state = true;
                    radioLinearLayout.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Enter theuser id here..
        userIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (state) {
                    state = false;
                    headerLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    state = true;
                    usernameTextView.setText("Arun");
                }

            }
        });
    }

    private void init(View view) {
        //LinearLayout
        editLinearLayout = (LinearLayout) view.findViewById(R.id.layEdit);
        radioLinearLayout = (LinearLayout) view.findViewById(R.id.layRadioButton);
        parentLinearLayout = (LinearLayout) view.findViewById(R.id.layparent);
        headerLinearLayout = (LinearLayout) view.findViewById(R.id.layHeader);
        //TextView
        usernameTextView = (TextView) view.findViewById(R.id.txtUsername);
        radioTextView = (TextView) view.findViewById(R.id.txtRadio);
        //EditText
        userIdEditText = (EditText) view.findViewById(R.id.etUserId);
    }
}
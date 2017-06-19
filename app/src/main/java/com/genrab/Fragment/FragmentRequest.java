package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.genrab.Activity.RegisterActivity;
import com.genrab.R;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentRequest extends Fragment {
    Spinner modeSpinner;

    private static String[] mMode = new String[]{
            "Choose a mode",
            "Wire Transfer",
            "Bitcoin Transfer",
            "Etherium Transfer"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, viewGroup, false);

        //getting the widget id
        init(view);
        //using the click listener
        listener();
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        //Spinner
        modeSpinner = (Spinner) view.findViewById(R.id.spinnerMode);
        //Set the Adapter
        ArrayAdapter<String> adaptermode = new ArrayAdapter<>(getActivity(), R.layout.mode_spinner);
        adaptermode.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptermode.addAll(mMode);
        modeSpinner.setAdapter(adaptermode);
    }
}
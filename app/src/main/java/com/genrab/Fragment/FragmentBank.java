package com.genrab.Fragment;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genrab.R;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentBank extends Fragment {
    LinearLayout bitcoinLinearLayout;
    AlertDialog alertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank, viewGroup, false);

        //getting the widget id
        init(view);
        //Using the click listener here
        listener();
        return view;
    }

    private void listener() {
        bitcoinLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customPop();
            }
        });
    }


    private void init(View view) {
        bitcoinLinearLayout = (LinearLayout) view.findViewById(R.id.layBitcoin);
    }

    private void customPop() {
        //*********Open the pop window message on EditText view click*******//

        LayoutInflater li = LayoutInflater.from(getActivity());
        View promptsView = li.inflate(R.layout.bitcoin_custom_pop, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final ImageView imgClose = (ImageView) promptsView.findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


        // create alert dialog
        alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }


}
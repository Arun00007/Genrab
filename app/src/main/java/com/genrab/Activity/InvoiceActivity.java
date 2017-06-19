package com.genrab.Activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.genrab.CustomAdpater.InvoiceAdpater;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;
import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class InvoiceActivity extends AppCompatActivity {
    ImageView bacImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        //Getting the widget id here...
        init();
        //using the click listener here
        listener();
       /* //Title
        setTitle("Invoice Detail");

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
        upArrow.setColorFilter(ContextCompat.getColor(InvoiceActivity.this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);*/
    }

    private void listener() {
        bacImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init() {
    bacImageView=(ImageView)findViewById(R.id.imgBack);
    }


}

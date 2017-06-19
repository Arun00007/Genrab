package com.genrab.CustomAdpater;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.genrab.Activity.InvoiceActivity;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class RateAdapter extends BaseAdapter {
    ArrayList<HistoryItem> items = new ArrayList<HistoryItem>();
    Activity con;

    public RateAdapter(Activity con, ArrayList<HistoryItem> items) {
        this.con = con;
        this.items = items;
        //this.orignalItems =items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int pos) {
        return items.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup) {
        LayoutInflater inflator = con.getLayoutInflater();
        View listItem = inflator.inflate(R.layout.rate_row_item, null, true);

        //TextView

        TextView descriptionTextView = (TextView) listItem.findViewById(R.id.txtDescription);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.txtDate);
        TextView distrubTextView = (TextView) listItem.findViewById(R.id.txtDistrub);
        TextView investTextView = (TextView) listItem.findViewById(R.id.txtInvestAmount);
        TextView generateTextView = (TextView) listItem.findViewById(R.id.txtGenrateAmount);

        descriptionTextView.setText(items.get(pos).getDescription());
        dateTextView.setText(items.get(pos).getRateDate());
        distrubTextView.setText(items.get(pos).getDistrub());
        investTextView.setText(items.get(pos).getInvestAmount());
        generateTextView.setText(items.get(pos).getGenerateAmount());


        return listItem;
    }


}

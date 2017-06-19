package com.genrab.CustomAdpater;

import android.app.Activity;
import android.app.ProgressDialog;
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

public class InvoiceAdpater extends BaseAdapter {
    ArrayList<HistoryItem> items = new ArrayList<HistoryItem>();
    Activity con;

    public InvoiceAdpater(Activity con, ArrayList<HistoryItem> items) {
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
        View listItem = inflator.inflate(R.layout.history_row_item, null, true);

        //TextView

       // TextView invoiceTextView = (TextView) listItem.findViewById(R.id.txtInvoice);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.txtDate);
        TextView amountTextView = (TextView) listItem.findViewById(R.id.txtAmount);

        TextView actionTextView = (TextView) listItem.findViewById(R.id.txtAction);

       // invoiceTextView.setText(items.get(pos).getUserId());
        dateTextView.setText(items.get(pos).getDate());
        amountTextView.setText(items.get(pos).getAmount());

        actionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actionIntent = new Intent(con, InvoiceActivity.class);
                con.startActivity(actionIntent);
            }
        });

        return listItem;
    }


}

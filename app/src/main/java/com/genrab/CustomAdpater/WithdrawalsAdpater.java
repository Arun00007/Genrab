package com.genrab.CustomAdpater;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class WithdrawalsAdpater extends BaseAdapter {
    ArrayList<HistoryItem> items = new ArrayList<HistoryItem>();
    Activity con;

    public WithdrawalsAdpater(Activity con, ArrayList<HistoryItem> items) {
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
        View listItem = inflator.inflate(R.layout.withdrawal_row_history, null, true);

        //TextView

        TextView accountTextView = (TextView) listItem.findViewById(R.id.txtAccount);
        TextView transactionId = (TextView) listItem.findViewById(R.id.txttransactionid);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.txtDate);
        TextView amountTextView = (TextView) listItem.findViewById(R.id.txtAmount);
        TextView modeTextView = (TextView) listItem.findViewById(R.id.txtMode);
        TextView statusTextView = (TextView) listItem.findViewById(R.id.txtStatus);

        accountTextView.setText(items.get(pos).getAccountnumber());
        transactionId.setText(items.get(pos).getTranactionID());
        dateTextView.setText(items.get(pos).getTransdate());
        amountTextView.setText(items.get(pos).getTranactionamount());
        modeTextView.setText(items.get(pos).getMode());
        statusTextView.setText(items.get(pos).getStatus());


        return listItem;
    }


}
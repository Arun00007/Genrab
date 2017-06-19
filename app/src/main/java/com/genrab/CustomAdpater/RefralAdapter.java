package com.genrab.CustomAdpater;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.genrab.CustomItem.HistoryItem;
import com.genrab.CustomItem.ReferralItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class RefralAdapter extends BaseAdapter {
    ArrayList<ReferralItem> items = new ArrayList<ReferralItem>();
    Activity con;

    public RefralAdapter(Activity con, ArrayList<ReferralItem> items) {
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
        View listItem = inflator.inflate(R.layout.refral_row_item, null, true);

        //TextView

        TextView firstTextView = (TextView) listItem.findViewById(R.id.txtFirst);
        TextView lastTextView = (TextView) listItem.findViewById(R.id.txtLast);
        TextView usernameTextView = (TextView) listItem.findViewById(R.id.txtUsername);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.txtDate);
        TextView amountTextView = (TextView) listItem.findViewById(R.id.txtAmount);
        TextView statusTextView = (TextView) listItem.findViewById(R.id.txtStatus);

        firstTextView.setText(items.get(pos).getFirstname());
        lastTextView.setText(items.get(pos).getLastname());
        usernameTextView.setText(items.get(pos).getUsername());
        amountTextView.setText(items.get(pos).getRefralamount());
        dateTextView.setText(items.get(pos).getRefraldate());
        statusTextView.setText(items.get(pos).getRefralstatus());


        return listItem;
    }


}

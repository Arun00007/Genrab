package com.genrab.CustomAdpater;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.genrab.CustomItem.HistoryItem;
import com.genrab.CustomItem.StateItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/14/2017.
 */

public class BalanceAdapter extends BaseAdapter {
    ArrayList<StateItem> items = new ArrayList<StateItem>();
    Activity con;

    public BalanceAdapter(Activity con, ArrayList<StateItem> items) {
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
        View listItem = inflator.inflate(R.layout.balance_row_item, null, true);

        //TextView

        TextView balancetypeTextView = (TextView) listItem.findViewById(R.id.txtBalanceType);
        TextView balanceTextView = (TextView) listItem.findViewById(R.id.txtBalance);


        balancetypeTextView.setText(items.get(pos).getBalancetype());
        balanceTextView.setText(items.get(pos).getmBalance());
        return listItem;
    }


}

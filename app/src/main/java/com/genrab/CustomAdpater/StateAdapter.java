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
 * Created by intel on 6/13/2017.
 */

public class StateAdapter extends BaseAdapter {
    ArrayList<StateItem> items = new ArrayList<StateItem>();
    Activity con;

    public StateAdapter(Activity con, ArrayList<StateItem> items) {
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
        View listItem = inflator.inflate(R.layout.statement_row_item, null, true);

        //TextView

        TextView desTextView = (TextView) listItem.findViewById(R.id.txtDescript);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.txtDate);
        TextView transidTextView = (TextView) listItem.findViewById(R.id.txtTransactionid);
        TextView balanceTextView = (TextView) listItem.findViewById(R.id.txtBalnce);
        TextView creditTextView = (TextView) listItem.findViewById(R.id.txtCredit);
        TextView debitTextView = (TextView) listItem.findViewById(R.id.txtDebit);

        desTextView.setText(items.get(pos).getStateDescription());
        dateTextView.setText(items.get(pos).getStatedate());
        transidTextView.setText(items.get(pos).getStateTransId());
        balanceTextView.setText(items.get(pos).getBalance());
        creditTextView.setText(items.get(pos).getCredit());
        debitTextView.setText(items.get(pos).getDebit());


        return listItem;
    }


}

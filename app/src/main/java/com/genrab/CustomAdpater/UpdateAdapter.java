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
 * Created by intel on 6/14/2017.
 */

public class UpdateAdapter extends BaseAdapter {
    ArrayList<HistoryItem> items = new ArrayList<HistoryItem>();
    Activity con;

    public UpdateAdapter(Activity con, ArrayList<HistoryItem> items) {
        this.con = con;
        this.items = items;

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
        View listItem = inflator.inflate(R.layout.update_row_item, null, true);

        //TextView

        TextView nameTextView = (TextView) listItem.findViewById(R.id.txtName);
        TextView authorTextView = (TextView) listItem.findViewById(R.id.txtAuthor);


        nameTextView.setText(items.get(pos).getName());
        authorTextView.setText(items.get(pos).getAuthor());


        return listItem;
    }


}

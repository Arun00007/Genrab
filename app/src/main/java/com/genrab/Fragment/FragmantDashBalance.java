package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.BalanceAdapter;
import com.genrab.CustomAdpater.InvoiceAdpater;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.CustomItem.StateItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class FragmantDashBalance extends Fragment {
    BalanceAdapter balanceAdapter;
    private static ArrayList<StateItem> stateItems;
    ListView balanceListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_balance, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        stateItems = new ArrayList<StateItem>();
        for (int i = 0; i < MyData.balancetype.length; i++) {
            stateItems.add(new StateItem(
                    MyData.balancetype[i],
                    MyData.mbalance[i]
            ));
        }


        balanceAdapter = new BalanceAdapter(getActivity(), stateItems);
        balanceListView.setAdapter(balanceAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        balanceListView = (ListView) view.findViewById(R.id.lvList);
    }
}
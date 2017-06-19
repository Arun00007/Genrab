package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.InvoiceAdpater;
import com.genrab.CustomAdpater.WithdrawalsAdpater;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentHistory extends Fragment {
    WithdrawalsAdpater withdrawalsAdpater;
    private static ArrayList<HistoryItem> historyItems;
    ListView historyListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        historyItems = new ArrayList<HistoryItem>();
        for (int i = 0; i < MyData.accountnumber.length; i++) {
            historyItems.add(new HistoryItem(
                    MyData.accountnumber[i],
                    MyData.mode[i],
                    MyData.transDate[i],
                    MyData.transactionId[i],
                    MyData.amount[i],
                    MyData.status[i]
            ));
        }


        withdrawalsAdpater = new WithdrawalsAdpater(getActivity(), historyItems);
        historyListView.setAdapter(withdrawalsAdpater);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        historyListView = (ListView) view.findViewById(R.id.lvList);
    }
}
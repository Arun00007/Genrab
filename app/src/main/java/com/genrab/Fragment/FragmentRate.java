package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.InvoiceAdpater;
import com.genrab.CustomAdpater.RateAdapter;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentRate extends Fragment {
    RateAdapter rateAdapter;
    private static ArrayList<HistoryItem> historyItems;
    ListView historyListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        historyItems = new ArrayList<HistoryItem>();
        for (int i = 0; i < MyData.ratedate.length; i++) {
            historyItems.add(new HistoryItem(
                    MyData.ratedate[i],
                    MyData.descrition[i],
                    MyData.distrub[i],
                    MyData.investammount[i],
                    MyData.genrateAmmount[i]
            ));
        }


        rateAdapter = new RateAdapter(getActivity(),historyItems);
        historyListView.setAdapter(rateAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        historyListView = (ListView) view.findViewById(R.id.lvList);
    }
}
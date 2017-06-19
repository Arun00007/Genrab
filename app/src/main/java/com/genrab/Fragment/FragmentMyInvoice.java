package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.InvoiceAdpater;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentMyInvoice extends Fragment {
    InvoiceAdpater historyItemAdpater;
    private static ArrayList<HistoryItem> historyItems;
    ListView historyListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myinvoice, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        historyItems = new ArrayList<HistoryItem>();
        for (int i = 0; i < MyData.invoice.length; i++) {
            historyItems.add(new HistoryItem(
                    MyData.invoice[i],
                    MyData.date[i],
                    MyData.mAmmount[i]
            ));
        }


        historyItemAdpater = new InvoiceAdpater(getActivity(),historyItems);
        historyListView.setAdapter(historyItemAdpater);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        historyListView = (ListView) view.findViewById(R.id.lvList);
    }
}
package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.RateAdapter;
import com.genrab.CustomAdpater.UpdateAdapter;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class FragmentUpdate extends Fragment {
    UpdateAdapter updateAdapter;
    private static ArrayList<HistoryItem> historyItems;
    ListView updateListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        historyItems = new ArrayList<HistoryItem>();
        for (int i = 0; i < MyData.name.length; i++) {
            historyItems.add(new HistoryItem(
                    MyData.name[i],
                    MyData.author[i]

            ));
        }


        updateAdapter = new UpdateAdapter(getActivity(), historyItems);
        updateListView.setAdapter(updateAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        updateListView = (ListView) view.findViewById(R.id.lvList);
    }
}
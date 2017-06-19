package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.StateAdapter;
import com.genrab.CustomAdpater.WithdrawalsAdpater;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.CustomItem.StateItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class FragmentState extends Fragment {
    StateAdapter stateAdapter;
    private static ArrayList<StateItem> stateItems;
    ListView stateListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        stateItems = new ArrayList<StateItem>();
        for (int i = 0; i < MyData.transactionId.length; i++) {
            stateItems.add(new StateItem(
                    MyData.statedescription[i],
                    MyData.transactionId[i],
                    MyData.transDate[i],
                    MyData.balance[i],
                    MyData.credit[i],
                    MyData.debit[i]
            ));
        }


        stateAdapter = new StateAdapter(getActivity(), stateItems);
        stateListView.setAdapter(stateAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        stateListView = (ListView) view.findViewById(R.id.lvList);
    }
}
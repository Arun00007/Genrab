package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.genrab.CustomAdpater.ActivityAdapter;
import com.genrab.CustomAdpater.BalanceAdapter;
import com.genrab.CustomItem.StateItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/13/2017.
 */

public class FragmentAccountActivity extends Fragment {
    ActivityAdapter activityAdapter;
    private static ArrayList<StateItem> stateItems;
    ListView activityListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        stateItems = new ArrayList<StateItem>();
        for (int i = 0; i < MyData.transDate.length; i++) {
            stateItems.add(new StateItem(
                    MyData.ipaddress[i],
                    MyData.browser[i],
                    MyData.transDate[i]
            ));
        }


        activityAdapter = new ActivityAdapter(getActivity(), stateItems);
        activityListView.setAdapter(activityAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        activityListView = (ListView) view.findViewById(R.id.lvList);
    }
}
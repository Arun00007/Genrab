package com.genrab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.genrab.CustomAdpater.RateAdapter;
import com.genrab.CustomAdpater.RefralAdapter;
import com.genrab.CustomItem.HistoryItem;
import com.genrab.CustomItem.ReferralItem;
import com.genrab.R;

import java.util.ArrayList;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentReferral extends Fragment {
    RefralAdapter refralAdapter;
    private static ArrayList<ReferralItem> referralItems;
    ListView rederralListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_referral, viewGroup, false);


        //Getting the widget id here...
        init(view);
        //using the click listener here
        listener();

        referralItems = new ArrayList<ReferralItem>();
        for (int i = 0; i < MyData.firstname.length; i++) {
            referralItems.add(new ReferralItem(
                    MyData.firstname[i],
                    MyData.lastname[i],
                    MyData.username[i],
                    MyData.amount[i],
                    MyData.transDate[i],
                    MyData.status[i]
            ));
        }


        refralAdapter = new RefralAdapter(getActivity(), referralItems);
        rederralListView.setAdapter(refralAdapter);
        return view;
    }

    private void listener() {

    }

    private void init(View view) {
        rederralListView = (ListView) view.findViewById(R.id.lvList);
    }
}
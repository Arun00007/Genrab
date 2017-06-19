package com.genrab.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genrab.CustomAdpater.InvestmentPagerAdapter;
import com.genrab.CustomAdpater.MyAccountAdapter;
import com.genrab.R;

/**
 * Created by intel on 6/9/2017.
 */

public class FragmentMyAccount extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myaccount, viewGroup, false);

        //Getting the tab layout widget id here......
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        //TabLayoutMethod
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("My Invoice"));
        tabLayout.addTab(tabLayout.newTab().setText("Rate Of Interest"));
        tabLayout.addTab(tabLayout.newTab().setText("Add Funds"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAccountAdapter adapter = new MyAccountAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    } //Implementing the tab layoiut here....
}
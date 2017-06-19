package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmantDashBalance;
import com.genrab.Fragment.FragmentAccountActivity;
import com.genrab.Fragment.FragmentHistory;
import com.genrab.Fragment.FragmentRequest;
import com.genrab.Fragment.FragmentUpdate;

/**
 * Created by intel on 6/13/2017.
 */

public class DashBoardViewAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public DashBoardViewAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmantDashBalance fragmantDashBalance = new FragmantDashBalance();
                return fragmantDashBalance;
            case 1:
                FragmentAccountActivity fragmentAccountActivity = new FragmentAccountActivity();
                return fragmentAccountActivity;
            case 2:
                FragmentUpdate fragmentUpdate = new FragmentUpdate();
                return fragmentUpdate;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
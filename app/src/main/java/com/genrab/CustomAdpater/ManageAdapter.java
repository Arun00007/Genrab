package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmentAddFund;
import com.genrab.Fragment.FragmentHistory;
import com.genrab.Fragment.FragmentMultipleAccount;
import com.genrab.Fragment.FragmentMyInvoice;
import com.genrab.Fragment.FragmentOtherAccount;
import com.genrab.Fragment.FragmentRate;
import com.genrab.Fragment.FragmentRequest;
import com.genrab.Fragment.FragmentSelfAccount;

/**
 * Created by intel on 6/12/2017.
 */

public class ManageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ManageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentRequest fragmentRequest = new FragmentRequest();
                return fragmentRequest;
            case 1:
                FragmentHistory fragmentHistory = new FragmentHistory();
                return fragmentHistory;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
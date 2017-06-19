package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmentAddFund;
import com.genrab.Fragment.FragmentMultipleAccount;
import com.genrab.Fragment.FragmentMyInvoice;
import com.genrab.Fragment.FragmentOtherAccount;
import com.genrab.Fragment.FragmentRate;
import com.genrab.Fragment.FragmentSelfAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intel on 6/12/2017.
 */

public class MyAccountAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MyAccountAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentMyInvoice fragmentMyInvoice = new FragmentMyInvoice();
                return fragmentMyInvoice;
            case 1:
                FragmentRate fragmentRate = new FragmentRate();
                return fragmentRate;
            case 2:
                FragmentAddFund fragmentAddFund = new FragmentAddFund();
                return fragmentAddFund;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
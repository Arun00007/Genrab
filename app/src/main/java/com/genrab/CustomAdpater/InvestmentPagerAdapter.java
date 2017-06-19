package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmentMultipleAccount;
import com.genrab.Fragment.FragmentOtherAccount;
import com.genrab.Fragment.FragmentSelfAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intel on 6/9/2017.
 */

public class InvestmentPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public InvestmentPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentSelfAccount selfAccount = new FragmentSelfAccount();
                return selfAccount;
            case 1:
                FragmentOtherAccount otherAccount = new FragmentOtherAccount();
                return otherAccount;
            case 2:
                FragmentMultipleAccount multipleAccount = new FragmentMultipleAccount();
                return multipleAccount;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
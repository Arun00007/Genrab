package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmentBingo;
import com.genrab.Fragment.FragmentDownline;
import com.genrab.Fragment.FragmentGentree;
import com.genrab.Fragment.FragmentMultipleAccount;
import com.genrab.Fragment.FragmentOtherAccount;
import com.genrab.Fragment.FragmentReferral;
import com.genrab.Fragment.FragmentSelfAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intel on 6/12/2017.
 */

public class NetworkAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public NetworkAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentReferral fragmentReferral = new FragmentReferral();
                return fragmentReferral;
            case 1:
                FragmentBingo fragmentBingo = new FragmentBingo();
                return fragmentBingo;
            case 2:
                FragmentGentree fragmentGentree = new FragmentGentree();
                return fragmentGentree;
            case 3:
                FragmentDownline fragmentDownline = new FragmentDownline();
                return fragmentDownline;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
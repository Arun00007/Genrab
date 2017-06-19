package com.genrab.CustomAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.genrab.Fragment.FragmentAccount;
import com.genrab.Fragment.FragmentAddFund;
import com.genrab.Fragment.FragmentBank;
import com.genrab.Fragment.FragmentEdit;
import com.genrab.Fragment.FragmentMyInvoice;
import com.genrab.Fragment.FragmentPassword;
import com.genrab.Fragment.FragmentRate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intel on 6/12/2017.
 */

public class SettingAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SettingAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentEdit fragmentEdit = new FragmentEdit();
                return fragmentEdit;
            case 1:
                FragmentBank fragmentBank = new FragmentBank();
                return fragmentBank;
            case 2:
                FragmentAccount fragmentAccount = new FragmentAccount();
                return fragmentAccount;
            case 3:
                FragmentPassword fragmentPassword = new FragmentPassword();
                return fragmentPassword;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
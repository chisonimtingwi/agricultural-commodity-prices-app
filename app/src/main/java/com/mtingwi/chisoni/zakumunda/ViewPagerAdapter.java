package com.mtingwi.chisoni.zakumunda;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[]) {
        super(fm);

        if (null != mTitles) {
            this.Titles = mTitles;
            this.NumbOfTabs = mTitles.length;
        }
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new AllPricesFragment();

            case 1:
                return new CropCategoriesFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}

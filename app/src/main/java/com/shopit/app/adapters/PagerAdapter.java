package com.shopit.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shopit.app.fragments.BestOffers;
import com.shopit.app.fragments.CategoryFragment;

/**
 * Created by Veera on 4/10/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new BestOffers().newInstance("", "");
                break;
            case 1:
                fragment = new BestOffers().newInstance("", "");
                break;
            case 2:
                fragment = new CategoryFragment().newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Best Offers";
                break;
            case 1:
                title = "Top Stories";
                break;
            case 2:
                title = "Categories";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

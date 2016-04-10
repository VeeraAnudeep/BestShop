package veera.bestshop.app.adapters;

import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import veera.bestshop.app.fragments.BestOffers;

/**
 * Created by Veera on 4/10/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BestOffers.newInstance("", "");
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

package com.example.androidbackground.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.androidbackground.fragment.PictureFragment;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<PictureFragment> pictureFragments;                         //ViewPager
    private List<String> titlePrimarys;                                     //TabLayout

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, List<PictureFragment> pictureFragments, List<String> titlePrimarys) {
        super(fragmentManager);
        this.pictureFragments = pictureFragments;
        this.titlePrimarys = titlePrimarys;
        notifyDataSetChanged();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titlePrimarys.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return pictureFragments.get(i);
    }

    @Override
    public int getCount() {
        return pictureFragments.size();
    }
}

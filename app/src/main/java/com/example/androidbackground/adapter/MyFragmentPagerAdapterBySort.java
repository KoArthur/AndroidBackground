package com.example.androidbackground.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.androidbackground.fragment.PictureFragmentByType;
import java.util.List;

public class MyFragmentPagerAdapterBySort extends FragmentPagerAdapter {

    private List<PictureFragmentByType> pictureFragmentBySortList;
    private List<String> titles;

    public MyFragmentPagerAdapterBySort(FragmentManager fragmentManager, List<PictureFragmentByType> pictureFragmentBySortList, List<String> titles) {
        super(fragmentManager);
        this.pictureFragmentBySortList = pictureFragmentBySortList;
        this.titles = titles;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return pictureFragmentBySortList.get(i);
    }

    @Override
    public int getCount() {
        return pictureFragmentBySortList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}

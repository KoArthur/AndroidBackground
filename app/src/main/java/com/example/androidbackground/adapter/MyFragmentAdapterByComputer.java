package com.example.androidbackground.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.androidbackground.fragment.PictureFragmentByComputer;

import java.util.List;

public class MyFragmentAdapterByComputer extends FragmentPagerAdapter {

    List<PictureFragmentByComputer> pictureFragmentByComputers;
    List<String> titles;


    public MyFragmentAdapterByComputer(FragmentManager fm, List<PictureFragmentByComputer> pictureFragmentByComputers, List<String> titles) {
        super(fm);
        this.titles = titles;
        this.pictureFragmentByComputers = pictureFragmentByComputers;
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


    @Override
    public Fragment getItem(int i) {
        return pictureFragmentByComputers.get(i);
    }

    @Override
    public int getCount() {
        return pictureFragmentByComputers.size();
    }
}

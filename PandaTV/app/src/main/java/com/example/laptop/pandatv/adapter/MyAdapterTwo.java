package com.example.laptop.pandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyAdapterTwo extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private List<String> tablist;

    public MyAdapterTwo(FragmentManager fm, ArrayList<Fragment> list, List<String> tablist) {
        super(fm);
        this.list = list;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }
}

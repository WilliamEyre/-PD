package com.example.laptop.pandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;


public class MyZhiBoAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> arrayList;

    public MyZhiBoAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> arrayList) {
        super(fm);
        this.list = list;
        this.arrayList = arrayList;
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
        return arrayList.get(position);
    }
}

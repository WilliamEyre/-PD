package com.example.laptop.pandatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.laptop.pandatv.bean.ChilaStudent;

import java.util.ArrayList;
import java.util.List;


public class ChildAdapter extends FragmentStatePagerAdapter {
    private List<ChilaStudent.TablistBean> beanList;
    private ArrayList<Fragment> list;

    public ChildAdapter(FragmentManager fm, List<ChilaStudent.TablistBean> beanList, ArrayList<Fragment> list) {
        super(fm);
        this.beanList = beanList;
        this.list = list;
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
        return beanList.get(position).getTitle();
    }
}

package com.example.laptop.pandatv.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TableLayout;

import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.adapter.ChildAdapter;
import com.example.laptop.pandatv.base.BaseFragment;
import com.example.laptop.pandatv.bean.ChilaStudent;
import com.example.laptop.pandatv.login.LoginContract;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class DFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<>();
    private List<ChilaStudent.TablistBean> beanList = new ArrayList<>();
    private ChildAdapter childAdapter;
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        list.clear();
        beanList.clear();
        tabLayout = (TabLayout) view.findViewById(R.id.TabLayout5);
        viewPager = (ViewPager) view.findViewById(R.id.ViewPager5);

        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment5;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        ChilaStudent chilaStudent = gson.fromJson(url, ChilaStudent.class);
        beanList = chilaStudent.getTablist();
        for (int i=0;i<beanList.size();i++){
            ChiladFragment childafrag = new ChiladFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url",beanList.get(i).getUrl());
            childafrag.setArguments(bundle);
            list.add(childafrag);
        }

        childAdapter = new ChildAdapter(getChildFragmentManager(),beanList,list);
        viewPager.setAdapter(childAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);

    }

}

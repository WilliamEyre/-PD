package com.example.laptop.pandatv.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.adapter.MyAdapterTwo;
import com.example.laptop.pandatv.base.BaseFragment;
import com.example.laptop.pandatv.bean.StudentTwo;
import com.example.laptop.pandatv.login.LoginContract;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AFragment extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View {
    private ArrayList<Fragment> list = new ArrayList<>();
    private List<StudentTwo.TablistBean> tablist = new ArrayList<>();
    private ArrayList<String> list1 = new ArrayList<>();
    private MyAdapterTwo myAdapterTwo;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {

        list1.clear();
        list.clear();
        tabLayout = (TabLayout) view.findViewById(R.id.TabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.ViewPager);
        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.afragment;
    }

    @Override
    public void show(String url) {
        Log.e("weewdsd", "asdasdas");
        Gson gson = new Gson();
        StudentTwo studentTwo = gson.fromJson(url, StudentTwo.class);
        tablist = studentTwo.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            list1.add(tablist.get(i).getTitle());
        }

        FragmentTest1 fragmetn = new FragmentTest1();
        list.add(fragmetn);
        for (int i=1;i<list1.size();i++){
            Bundle bundler = new Bundle();
            bundler.putString("url",list1.get(i));
            fragmetn.setArguments(bundler);
            list.add(new Fragment());
        }
        myAdapterTwo = new MyAdapterTwo(getFragmentManager(), list, list1);
        viewPager.setAdapter(myAdapterTwo);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
        Log.e("weewdsd", "asdasdas");
    }

}

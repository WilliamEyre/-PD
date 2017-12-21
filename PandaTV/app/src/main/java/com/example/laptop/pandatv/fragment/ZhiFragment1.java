package com.example.laptop.pandatv.fragment;

import android.view.View;

import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.base.BaseFragment;
import com.example.laptop.pandatv.login.LoginContract;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;


public class ZhiFragment1 extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View {
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.zhiframgnet;
    }

    @Override
    public void show(String url) {

    }
}

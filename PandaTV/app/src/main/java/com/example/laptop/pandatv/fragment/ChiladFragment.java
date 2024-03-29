package com.example.laptop.pandatv.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.adapter.ChilAdapter1;
import com.example.laptop.pandatv.base.BaseFragment;
import com.example.laptop.pandatv.bean.Childa1;
import com.example.laptop.pandatv.login.LoginContract;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.List;


public class ChiladFragment extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View {
    private RecyclerView recyclerView;
    private ChilAdapter1 chilAdapter1;
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        Bundle arguments = getArguments();
        String url = arguments.getString("url");
        mPresenter.loginData(url);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.childer;
    }

    @Override
    public void show(String url) {
        Log.e("url",url);
        Gson gson = new Gson();
        Childa1 childa1 = gson.fromJson(url, Childa1.class);
        List<Childa1.LiveBean> live = childa1.getLive();
        chilAdapter1 = new ChilAdapter1(live,getActivity().getApplicationContext());
        recyclerView.setAdapter(chilAdapter1);
    }
}

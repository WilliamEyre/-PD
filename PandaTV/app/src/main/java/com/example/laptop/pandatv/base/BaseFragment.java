package com.example.laptop.pandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop.pandatv.utils.Tutils;

public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {
    public P mPresenter;
    public M mModle;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setLayoutId(),container,false);
        mPresenter = Tutils.setT(this,0);
        mModle = Tutils.setT(this,1);
        if (this instanceof BaseView){
            mPresenter.setVM(mModle,this);
        }
        initView(view);
        intiData();
        return view;
    }

    protected abstract void intiData();

    protected abstract void initView(View view);

    protected abstract int setLayoutId();
}

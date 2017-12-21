package com.example.laptop.pandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.laptop.pandatv.app.App;
import com.example.laptop.pandatv.utils.Tutils;

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.baseActivity = this;
        mPresenter = Tutils.setT(this,0);
        mModle = Tutils.setT(this,1);
        if (this instanceof BaseView){
            mPresenter.setVM(mModle,this);
        }
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();
}

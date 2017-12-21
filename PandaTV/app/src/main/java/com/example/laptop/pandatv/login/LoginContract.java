package com.example.laptop.pandatv.login;

import com.example.laptop.pandatv.base.BaseModel;
import com.example.laptop.pandatv.base.BasePresenter;
import com.example.laptop.pandatv.base.BaseView;

import java.util.Map;

public interface LoginContract {

    interface View extends BaseView {
      void show(String url);
    }

    interface Model extends BaseModel {
        void getData(String url, CallBacks callBacks);
        void setData(String url, Map<String, Object> map, CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void loginDatas(String url,Map<String,Object> map);
        public abstract void loginData(String url);
    }
}
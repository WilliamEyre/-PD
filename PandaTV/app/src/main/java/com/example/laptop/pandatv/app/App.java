package com.example.laptop.pandatv.app;

import android.app.Application;

import com.example.laptop.pandatv.base.BaseActivity;
import com.example.laptop.pandatv.base.BaseAdapters;
import com.example.laptop.pandatv.base.BaseFragment;

public class App extends Application{
    public static BaseActivity baseActivity;
    public static BaseFragment baseFragment;
    public static BaseAdapters baseAdapter;
}

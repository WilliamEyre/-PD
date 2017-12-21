package com.example.laptop.pandatv;


import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.laptop.pandatv.base.BaseActivity;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;


public class Main3Activity extends BaseActivity<LoginPresenter,LoginModel> {
    private WebView webView;

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.WebVIew);
        webView.loadUrl("http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main3;
    }
}

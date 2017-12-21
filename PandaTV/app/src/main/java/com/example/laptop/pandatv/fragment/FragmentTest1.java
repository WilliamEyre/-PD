package com.example.laptop.pandatv.fragment;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.base.BaseFragment;
import com.example.laptop.pandatv.bean.ZhiBo;
import com.example.laptop.pandatv.login.LoginContract;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class FragmentTest1 extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View,View.OnClickListener{
    private RadioGroup radiogroup;
    private FragmentManager fragmentManager;
    private TextView mName,mName1;
    private Button mBut;
    private Banner banners;
    private ArrayList<String> list = new ArrayList<>();
    private boolean boo = true;
    private ZhiFragment zhfragment;
    private ZhiFragment1 zhifraagment1;

    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json");
        radiogroup = (RadioGroup) view.findViewById(R.id.RadioGroup1);
        mName = (TextView) view.findViewById(R.id.NameZhiBo);
        mName1 = (TextView) view.findViewById(R.id.NameZhiBo1);
        banners = (Banner) view.findViewById(R.id.Banner3);
        mBut = (Button) view.findViewById(R.id.Image2);
        mBut.setOnClickListener(this);

        zhfragment = new ZhiFragment();
        zhifraagment1 = new ZhiFragment1();
        fragmentManager = getChildFragmentManager();
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.RadioButtons:
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.FrameLayout1,zhfragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.RadioButtons1:
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.FrameLayout1,zhifraagment1);
                        fragmentTransaction1.commit();
                        break;
                }
            }
        });
        }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        ZhiBo zhiBo = gson.fromJson(url, ZhiBo.class);
        List<ZhiBo.LiveBean> live = zhiBo.getLive();
        if (boo) {
            for (int i = 0; i < live.size(); i++) {
                list.add(live.get(i).getImage());
                mName.setText("[正在直播]"+live.get(i).getTitle());
                mName1.setText(live.get(i).getBrief());
            }
            boo = false;
        }
        banners.setImages(list)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new Gliders())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Image2:
                if (boo){
                    mName1.setVisibility(View.GONE);
                    mBut.setBackground(getResources().getDrawable(R.drawable.live_china_detail_down));
                    boo = false;
                }else {
                    mName1.setVisibility(View.VISIBLE);
                    mBut.setBackground(getResources().getDrawable(R.drawable.live_china_detail_up));
                    boo = true;
                }
                break;
        }
    }

    class Gliders extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}

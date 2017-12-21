package com.example.laptop.pandatv;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.laptop.pandatv.base.BaseActivity;
import com.example.laptop.pandatv.login.LoginModel;
import com.example.laptop.pandatv.login.LoginPresenter;

public class MainActivity extends BaseActivity<LoginPresenter,LoginModel> {


    @Override
    protected void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.ImageViewOne);
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(3000);
        imageView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}

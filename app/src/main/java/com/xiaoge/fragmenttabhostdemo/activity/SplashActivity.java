package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.MainActivity;
import com.xiaoge.fragmenttabhostdemo.R;


public class SplashActivity extends BaseActivity {
    private Animation myAnimation_Alpha;
    private RelativeLayout rl_homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        rl_homepage = (RelativeLayout) findViewById(R.id.rl_homepage);
        //根据各自的构造方法来初始化一个实例对象
        myAnimation_Alpha = new AlphaAnimation(0.3f, 1.0f);
        rl_homepage.setAnimation(myAnimation_Alpha);
        myAnimation_Alpha.setDuration(3000);
        myAnimation_Alpha.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivityWithAnim(intent);
                finish();

            }
        });

        myAnimation_Alpha.startNow();
    }


}

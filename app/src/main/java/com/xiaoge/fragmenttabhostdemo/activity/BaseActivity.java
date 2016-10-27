package com.xiaoge.fragmenttabhostdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.utils.GlobalConfig;


public class BaseActivity extends FragmentActivity implements View.OnClickListener {
    /**
     * Context
     */
    protected Activity mContext;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        tv_title = (TextView) findViewById(R.id.tv_title);

    }


    //如果有header 直接绑定返回按钮点击事件
    public void backpressed(View view) {
        finishWithAnim();
    }

    protected void setTitle(String title) {
        if (tv_title != null) {
            tv_title.setText(title);
        }
    }

    /***
     * 带动画启动  activity
     *
     * @param intent
     */
    protected void startActivityWithAnim(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.default_fromright_in, R.anim.default_toleft_out);
    }

    /***
     * 带动画退出  activity
     */
    protected void finishWithAnim() {
        finish();
        overridePendingTransition(R.anim.default_fromright_in, R.anim.default_toleft_out);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back: // 统一简单返回键处理
                finish();

                break;


            default: // 非统一处理onClick
                onInnerClick(view);

        }
    }

    protected void onInnerClick(View view) {}
}
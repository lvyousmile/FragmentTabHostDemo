package com.xiaoge.fragmenttabhostdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;


public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{
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

        initCreate();
        initView();
        initListener();
        initData();
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
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back: // 统一简单返回键处理
                finish();

                break;

            default: // 非统一处理onClick
                onInnerClick(v);
        }
    }


    /**
     * 初始化配置
     */
    protected abstract void initCreate();

    /**
     * 初始化View
     * 处理
     */
    protected abstract void initView();

    /**
     * 初始化监听器
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 抽取处理 onClick 方法
     * @param view    被点击的View
     */
    protected void onInnerClick(View view) {}

}

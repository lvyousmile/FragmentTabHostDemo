package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;

public class SettingActivity extends BaseActivity {

    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

    }

    protected void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);
    }
}

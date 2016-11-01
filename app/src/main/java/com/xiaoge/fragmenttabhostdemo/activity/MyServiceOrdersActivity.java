package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;

public class MyServiceOrdersActivity extends BaseActivity {
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myservice_orders);
        initView();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
    }
}

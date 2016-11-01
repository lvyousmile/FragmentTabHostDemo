package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;

public class HelpActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initView();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);

        back.setOnClickListener(this);
    }

}

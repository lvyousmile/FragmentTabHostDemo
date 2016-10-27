package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;


public class ForgetPwdAcitivity extends BaseActivity implements View.OnClickListener {


    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);

    }



}

package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.utils.ToastUtils;

public class SettingActivity extends BaseActivity {

    private RelativeLayout back;
    private RelativeLayout advice;
    private RelativeLayout update;
    private RelativeLayout family;
    private RelativeLayout help;
    private RelativeLayout about_savelife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

    }

    protected void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
        advice = (RelativeLayout) findViewById(R.id.advice);
        advice.setOnClickListener(this);
        update = (RelativeLayout) findViewById(R.id.update);
        update.setOnClickListener(this);
        family = (RelativeLayout) findViewById(R.id.family);
        family.setOnClickListener(this);
        help = (RelativeLayout) findViewById(R.id.help);
        help.setOnClickListener(this);
        about_savelife = (RelativeLayout) findViewById(R.id.about_savelife);
        about_savelife.setOnClickListener(this);
    }

    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);
        switch (view.getId()) {
            case R.id.advice:
                startActivity(new Intent(mContext, GiveSuggestionActivity.class));
                break;
            case R.id.update:
                ToastUtils.showShort(mContext, "当前已是最新版本");
                break;

            case R.id.family:
                startActivity(new Intent(mContext, InviteFamilyActivity.class));
                break;
            case R.id.help:
                startActivity(new Intent(mContext, HelpActivity.class));
                break;
            case R.id.about_savelife:
                startActivity(new Intent(mContext, AboutSavActivity.class));
                break;

            default:

                break;
        }
    }
}

package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;

public class MyDataActivity extends BaseActivity {

    private RelativeLayout back;
    private RelativeLayout changeNickname;
    private RelativeLayout changeLoginpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);
        back = (RelativeLayout) findViewById(R.id.back);
        changeNickname = (RelativeLayout) findViewById(R.id.change_nickname);
        changeLoginpwd = (RelativeLayout) findViewById(R.id.change_loginpwd);

        back.setOnClickListener(this);
        changeNickname.setOnClickListener(this);
        changeLoginpwd.setOnClickListener(this);

    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);

        switch (view.getId()) {
            case R.id.change_nickname:
                startActivity(new Intent(mContext, ChangeNicknameActivity.class));
                break;

            case R.id.change_loginpwd:
                startActivity(new Intent(mContext, ChangeLoginpwdActivity.class));
                break;

            default:
                break;
        }
    }

}

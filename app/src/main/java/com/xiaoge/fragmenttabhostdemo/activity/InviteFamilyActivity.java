package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;

public class InviteFamilyActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_family);
        initView();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);

        back.setOnClickListener(this);
    }

}

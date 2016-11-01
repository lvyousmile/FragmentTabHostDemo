package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xiaoge.fragmenttabhostdemo.R;

public class ChangeLoginpwdActivity extends BaseActivity{

    private RelativeLayout back;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_loginpwd);
        initView();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        submit = (Button) findViewById(R.id.submit);

        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);
        switch (view.getId()) {
            case R.id.submit:
                Toast.makeText(mContext, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}

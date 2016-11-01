package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xiaoge.fragmenttabhostdemo.R;

public class ChangePhoneAcivity extends BaseActivity {

    private RelativeLayout back;
    private Button getText;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);
        initView();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        getText = (Button) findViewById(R.id.getText);
        submit = (Button) findViewById(R.id.submit);

        back.setOnClickListener(this);
        getText.setOnClickListener(this);
        submit.setOnClickListener(this);
    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);
        switch (view.getId()) {
            case R.id.getText:
                Toast.makeText(mContext,"验证码已发送",Toast.LENGTH_SHORT).show();
                break;
            case R.id.submit:
                Toast.makeText(mContext,"已提交",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}

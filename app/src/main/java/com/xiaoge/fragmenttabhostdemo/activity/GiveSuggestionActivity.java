package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.utils.ToastUtils;

public class GiveSuggestionActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout back;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_suggestion);
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
                ToastUtils.showShort(mContext,"已提交");
                finish();
                break;
        }
    }
}

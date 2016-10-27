package com.xiaoge.fragmenttabhostdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;

public class RegisterActivity extends BaseActivity {

    private RelativeLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
    }


}

package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xiaoge.fragmenttabhostdemo.R;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {

    //登录名字和密码
    private EditText et_username;
    private EditText et_password;
    private Button bt_forgot_psw;

    private Button bt_login;
    private Button bt_register;

    private String username;
    private String password;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_forgot_psw = (Button) findViewById(R.id.bt_forgot_psw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_register = (Button) findViewById(R.id.bt_register);

        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        bt_forgot_psw.setOnClickListener(this);
    }

    @Override
    protected void initCreate() {

        gson = new Gson();
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initListener() {



    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);

        switch (view.getId()) {
            case R.id.bt_login: // 登录
                //loginUser();
                break;
            case R.id.bt_register: // 注册
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
                break;
            case R.id.bt_forgot_psw: // 找回密码
                startActivity(new Intent(getBaseContext(), ForgetPwdAcitivity.class));
                break;
        }

    }
/*
    private void loginUser() {

        username = et_username.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("username", username);
        password = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(), "用户名不能为空",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "密码不能为空",
                    Toast.LENGTH_SHORT).show();

            return;
        }


        final HashMap<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
    }
    */
}

package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xiaoge.fragmenttabhostdemo.MainActivity;
import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.bean.LoginBean;
import com.xiaoge.fragmenttabhostdemo.utils.NetUrl;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

public class LoginActivity extends BaseActivity {

    //登录名字和密码
    private EditText et_username;
    private EditText et_password;
    private Button bt_forgot_psw;

    private Button bt_login;
    private Button bt_register;

    private String name;
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

        gson = new Gson();

        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        bt_forgot_psw.setOnClickListener(this);

    }



    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);

        switch (view.getId()) {
            case R.id.bt_login: // 登录
                loginUser();
                //  startActivity(new Intent(mContext, MainActivity.class));
                break;
            case R.id.bt_register: // 注册
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
                break;
            case R.id.bt_forgot_psw: // 找回密码
                startActivity(new Intent(getBaseContext(), ForgetPwdAcitivity.class));
                break;
        }

    }

    private void loginUser() {

        name = et_username.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("name", name);
        password = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
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
        params.put("name", name);
        params.put("password", password);

        String url = NetUrl.BASE_URL + "/api/user/tlogin.html";
//        String url = "www.baidu.com";


        OkHttpUtils
                .get()
                .url(url)
                .addParams("name", name)
                .addParams("password", password)
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Toast.makeText(LoginActivity.this, "网络连接错误~~~", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Toast.makeText(LoginActivity.this, "网络连接成功~~~", Toast.LENGTH_LONG).show();
                        Log.i("ly","登录成功");

                        LoginBean loginbean = gson.fromJson(response, LoginBean.class);

                        if (1 == loginbean.code) {
                            Log.i("ly","密码错误");

                            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                            finish();
                            return;
                        } else if (0 == loginbean.code) {
                            Log.i("ly","登录成功");
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(mContext, MainActivity.class));
                        }

                        finish();
                    }

                });


    }

}

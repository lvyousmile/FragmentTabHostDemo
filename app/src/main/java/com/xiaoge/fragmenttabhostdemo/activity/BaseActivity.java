package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;


public class BaseActivity extends FragmentActivity  {
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv_title = (TextView) findViewById(R.id.tv_title);

    }
    //如果有header 直接绑定返回按钮点击事件
    public void backpressed(View view){
        finishWithAnim();
    }

    protected void setTitle(String title){
        if(tv_title!=null){
            tv_title.setText(title);
        }
    }

    /***
     * 带动画启动  activity
     * @param intent
     */
    protected void startActivityWithAnim(Intent intent){
        startActivity(intent);
        overridePendingTransition(R.anim.default_fromright_in,R.anim.default_toleft_out);
    }

    /***
     * 带动画退出  activity
     */
    protected void finishWithAnim(){
        finish();
        overridePendingTransition(R.anim.default_fromright_in,R.anim.default_toleft_out);
    }

}

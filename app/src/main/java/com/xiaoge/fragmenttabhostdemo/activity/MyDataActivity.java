package com.xiaoge.fragmenttabhostdemo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xiaoge.fragmenttabhostdemo.MainActivity;
import com.xiaoge.fragmenttabhostdemo.R;

public class MyDataActivity extends BaseActivity {

    private RelativeLayout back;
    private RelativeLayout changeNickname;
    private RelativeLayout changeLoginpwd;
    private RelativeLayout changeTelphone;
    private Button quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);
        initView();


    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        changeNickname = (RelativeLayout) findViewById(R.id.change_nickname);
        changeLoginpwd = (RelativeLayout) findViewById(R.id.change_loginpwd);
        changeTelphone = (RelativeLayout) findViewById(R.id.change_Telphone);
        quit = (Button) findViewById(R.id.quit);

        back.setOnClickListener(this);
        changeNickname.setOnClickListener(this);
        changeLoginpwd.setOnClickListener(this);
        changeTelphone.setOnClickListener(this);
        quit.setOnClickListener(this);
    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);

        switch (view.getId()) {
            case R.id.change_nickname://修改昵称
                startActivity(new Intent(mContext, ChangeNicknameActivity.class));
                break;

            case R.id.change_Telphone://修改电话
                startActivity(new Intent(mContext, ChangePhoneAcivity.class));
                break;

            case R.id.change_loginpwd://修改登录密码
                startActivity(new Intent(mContext, ChangeLoginpwdActivity.class));
                break;

            case R.id.quit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);        //先得到构造器
//                builder.setTitle("提示");                                         //设置标题
                builder.setMessage("是否确认退出");       //设置内容
//                builder.setIcon(R.mipmap.ic_launcher);   //自定义图标
                builder.setCancelable(false);           //设置是否能点击，对话框的其他区域取消

                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {     //设置其确认按钮和监听事件
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {     //设置其取消按钮和监听事件
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();       //创建对话框
                builder.show();         //显示对话框


        break;

        default:
        break;
    }
}

}

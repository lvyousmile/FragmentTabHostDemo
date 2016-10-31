package com.xiaoge.fragmenttabhostdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.activity.MyDataActivity;
import com.xiaoge.fragmenttabhostdemo.activity.MyServiceOrdersActivity;
import com.xiaoge.fragmenttabhostdemo.activity.NavigationAcitivity;
import com.xiaoge.fragmenttabhostdemo.activity.SettingActivity;

/**
 * Created by Administrator on 2016/9/16 0016.
 */
public class MineFragment extends BaseFragment {


    private RelativeLayout mydata;
    private RelativeLayout my_service_orders;
    private RelativeLayout mysetting;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initCreate() {


    }

    @Override
    protected void initView(View rootView) {
        mydata = (RelativeLayout) rootView.findViewById(R.id.mydata);
        my_service_orders = (RelativeLayout) rootView.findViewById(R.id.my_service_orders);
        mysetting = (RelativeLayout) rootView.findViewById(R.id.mysetting);
    }

    @Override
    protected void initListener() {
        mydata.setOnClickListener(this);
        my_service_orders.setOnClickListener(this);
        mysetting.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.mydata:
                    startActivity(new Intent(getActivity(), MyDataActivity.class));
                    break;
                case R.id.my_service_orders:
                    startActivity(new Intent(getActivity(), MyServiceOrdersActivity.class));
                    break;
                case R.id.mysetting:
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                    break;

                default:
                    break;
            }
    }

}

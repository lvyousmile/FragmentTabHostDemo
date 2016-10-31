package com.xiaoge.fragmenttabhostdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.activity.NavigationAcitivity;

/**
 * Created by Administrator on 2016/9/16 0016.
 */
public class HomeFragment extends BaseFragment {

    private TextView navigation;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initCreate() {
    }

    @Override
    protected void initView(View rootView) {
        navigation = (TextView) rootView.findViewById(R.id.navigation);

    }

    @Override
    protected void initListener() {
        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NavigationAcitivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View view) {

    }
}

package com.xiaoge.fragmenttabhostdemo;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.xiaoge.fragmenttabhostdemo.activity.GuideActivity;
import com.xiaoge.fragmenttabhostdemo.bean.Tab;
import com.xiaoge.fragmenttabhostdemo.fragment.DateFragment;
import com.xiaoge.fragmenttabhostdemo.fragment.PhoneFragment;
import com.xiaoge.fragmenttabhostdemo.fragment.HomeFragment;
import com.xiaoge.fragmenttabhostdemo.fragment.ServiceFragment;
import com.xiaoge.fragmenttabhostdemo.fragment.MineFragment;
import com.xiaoge.fragmenttabhostdemo.global.AppConstants;
import com.xiaoge.fragmenttabhostdemo.utils.SpUtils;
import com.xiaoge.fragmenttabhostdemo.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 存放内容fragment的帧布局
    private FrameLayout fl_content;
    // 使用fragmentTabhost + fragment完成当前的框架
    private FragmentTabHost mTabhost;
    private List<Tab> mTabs = new ArrayList<>();
    private LayoutInflater mInflater;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否是第一次开启应用
        boolean isFirstOpen = SpUtils.getBoolean(this, AppConstants.FIRST_OPEN,true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen) {
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // 查找控件
        initView();
    }



    private void initView() {
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        mTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 初始化底部标签页
        initTab();
    }


    private void initTab() {


        Tab tab_home = new Tab(HomeFragment.class, R.string.home, R.drawable.selector_icon_home);
        Tab tab_service = new Tab(ServiceFragment.class, R.string.service, R.drawable.selector_icon_service);
        Tab tab_phone = new Tab(PhoneFragment.class, R.string.phone, R.drawable.selector_icon_phone);
        Tab tab_date = new Tab(DateFragment.class, R.string.date, R.drawable.selector_icon_date);
        Tab tab_mine = new Tab(MineFragment.class, R.string.mine, R.drawable.selector_icon_mine);

        mTabs.add(tab_home);
        mTabs.add(tab_service);
        mTabs.add(tab_phone);
        mTabs.add(tab_date);
        mTabs.add(tab_mine);


        mInflater = LayoutInflater.from(this);
        // tabHost不许执行setup方法  最后一个布局id是将来填充fragment的帧布局
        mTabhost.setup(this, getSupportFragmentManager(), R.id.fl_content);

        for (Tab tab : mTabs) {

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec, tab.getFragment(), null);

        }

        // 隐藏标签之间的分割线 并将主页设置为默认选择的标签
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        }
        mTabhost.setCurrentTab(0);


    }


    private View buildIndicator(Tab tab) {


        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return view;
    }
}

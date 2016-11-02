package com.xiaoge.fragmenttabhostdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by LvYou on 2016/11/1 0001.
 */

public class TabPageIndicatorAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    //标题
    private String[] title;
    public TabPageIndicatorAdapter(FragmentManager fm, List<Fragment> fragments, String[] title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    //获取当前位置的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position % title.length];
    }
}

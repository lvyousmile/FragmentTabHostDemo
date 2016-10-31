package com.xiaoge.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.xiaoge.fragmenttabhostdemo.R;

public class NavigationAcitivity extends BaseActivity {
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
    }


}

package com.xiaoge.fragmenttabhostdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xiaoge.fragmenttabhostdemo.MainActivity;
import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.global.AppConstants;
import com.xiaoge.fragmenttabhostdemo.utils.SpUtils;


public class GuideActivity extends BaseActivity implements OnPageChangeListener {
	/**
	 * ViewPager
	 */
	private ViewPager viewPager;
	private ImageView[] tips;
	private ImageView[] mImageViews;
	private int[] imgIdArray;
	private ImageButton bt_enter;
	private ViewGroup group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_guide);
		group = (ViewGroup) findViewById(R.id.viewGroup);
		bt_enter = (ImageButton) findViewById(R.id.bt_enter);
		viewPager = (ViewPager) findViewById(R.id.viewPager);

		bt_enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GuideActivity.this,MainActivity.class);
				startActivityWithAnim(intent);
				finish();
			}
		});

		imgIdArray = new int[] { R.mipmap.p1,R.mipmap.login_img1, R.mipmap.login_img2, R.mipmap.login_img3};

		tips = new ImageView[imgIdArray.length];
		for (int i = 0; i < tips.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(10, 10));
			tips[i] = imageView;
			if (i == 0) {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_unfocused);
			}

			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 15;
			layoutParams.rightMargin = 15;
			layoutParams.bottomMargin = 20;
			group.addView(imageView, layoutParams);
		}

		mImageViews = new ImageView[imgIdArray.length];
		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setBackgroundResource(imgIdArray[i]);
		}

		viewPager.setAdapter(new MyAdapter());
		viewPager.setOnPageChangeListener(this);
		viewPager.setCurrentItem(0);

	}

	/**
	 * 
	 * @author xiaanming
	 * 
	 */
	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return imgIdArray.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(mImageViews[position
					% mImageViews.length]);

		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(mImageViews[position
					% mImageViews.length], 0);
			return mImageViews[position % mImageViews.length];
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(arg0 % mImageViews.length);

		if(arg0 == (mImageViews.length-1)){
			bt_enter.setVisibility(View.VISIBLE);
		}else{
			bt_enter.setVisibility(View.GONE);
		}

	}

	/**
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_unfocused);
			}
		}
	}

	@Override
	public void onBackPressed() {
		finishWithAnim();
		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 如果切换到后台，就设置下次不进入功能引导页
		SpUtils.putBoolean(GuideActivity.this, AppConstants.FIRST_OPEN, false);
		finish();
	}
}

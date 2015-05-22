package com.niu.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * viewpager切换适配器
 * 
 * @ClassName: ViewPagerAdaper
 * @Description: TODO
 * @author nyw
 * @date 2014-9-28
 */

public class ViewPagerAdaper extends PagerAdapter {

	private List<View> views;

	public ViewPagerAdaper(List<View> views) {
		this.views = views;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (views != null) {
			return views.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object arg1) {
		// TODO Auto-generated method stub
		return (view == arg1);
	}

	@Override
	public void destroyItem(View view, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) view).removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup view, int position) {
		// TODO Auto-generated method stub
		((ViewPager) view).addView(views.get(position), 0);
		return views.get(position);
	}

}

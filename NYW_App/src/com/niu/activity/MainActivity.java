package com.niu.activity;

import java.util.ArrayList;
import java.util.List;

import com.niu.adapter.MsgExpandableListView;
import com.niu.adapter.ViewPagerAdaper;
import com.niu.app.R;
import com.niu.bean.MsgBean;
import com.niu.util.L;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	/** 底部切换viewpager */
	private ViewPager viewPager;
	/** 底部按钮布局Views */
	private List<View> views;
	/** 消息布局 */
	private View msg_view;
	/** 表格布局 */
	private View connection_view;
	/** 关于我布局 */
	private View mine_view;
	/** viewpager对应的适配器 */
	private ViewPagerAdaper adapter;
	/** 消息整体按钮 */
	private LinearLayout msg_layout;
	/** 表格整体按钮 */
	private LinearLayout connection_layout;
	/** 关于我整体按钮 */
	private LinearLayout mine_layout;
	/** 上下文context */
	private Context context;
	/** 标题textView */
	private TextView title_tv;
	/** 消息按钮 */
	private ImageView menu_msg_iamge;
	/** 表格按钮 */
	private ImageView menu_conn_iamge;
	/** 我按钮 */
	private ImageView menu_mine_iamge;
	/** 消息textView */
	private TextView menu_msg_tv;
	/** 表格textView */
	private TextView menu_conn_tv;
	/** 我textView */
	private TextView menu_mine_tv;
	/** 更多按钮 */
	private RelativeLayout more_layout;
	/**消息列表*/
	private ExpandableListView  msg_exListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initView();
        initData();
    }

	/** 初始化控件 */
	public void initView() {
		title_tv = (TextView) this.findViewById(R.id.main_title);
		viewPager = (ViewPager) this.findViewById(R.id.main_viewPager);
		msg_view = this.getLayoutInflater().inflate(R.layout.bootom_msg,
				null);
		msg_exListView=(ExpandableListView) msg_view.findViewById(R.id.msg_exlistview);
		msg_exListView.setGroupIndicator(null);
		connection_view = this.getLayoutInflater().inflate(
				R.layout.bootom_table, null);
		mine_view = this.getLayoutInflater().inflate(R.layout.bootom_mine,
				null);
		msg_layout = (LinearLayout) this
				.findViewById(R.id.bottomMenu_msg_layout);
		msg_layout.setOnClickListener(this);
		connection_layout = (LinearLayout) this
				.findViewById(R.id.bottomMenu_connection_layout);
		connection_layout.setOnClickListener(this);

		mine_layout = (LinearLayout) this
				.findViewById(R.id.bottomMenu_mine_layout);
		mine_layout.setOnClickListener(this);

		menu_msg_iamge = (ImageView) this
				.findViewById(R.id.bottomMenu_msg_image);
		menu_msg_tv = (TextView) this.findViewById(R.id.bottomMenu_msg_tv);
		menu_conn_iamge = (ImageView) this
				.findViewById(R.id.bottomMenu_connection_iamge);
		menu_conn_tv = (TextView) this
				.findViewById(R.id.bottomMenu_connection_tv);
		menu_mine_iamge = (ImageView) this
				.findViewById(R.id.bottomMenu_mine_image);
		menu_mine_tv = (TextView) this.findViewById(R.id.bottomMenu_mine_tv);

		more_layout = (RelativeLayout) this.findViewById(R.id.main_more_layout);
		more_layout.setOnClickListener(this);
	}

	/**初始化数据*/
	public void initData(){
		views = new ArrayList<View>();
		views.add(msg_view);
		views.add(connection_view);
		views.add(mine_view);
		adapter = new ViewPagerAdaper(views);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		select(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				L.e("页面", arg0 + "");
				select(arg0);
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/** 消息列表页 */
	 switch (v.getId()) {
		case R.id.bottomMenu_msg_layout:
			viewPager.setCurrentItem(0);
			break;
		/** 表格页 */
		case R.id.bottomMenu_connection_layout:
			viewPager.setCurrentItem(1);
			break;
		/** 关于我页 */
		case R.id.bottomMenu_mine_layout:
			viewPager.setCurrentItem(3);
			break;
		}
	}
	
	/**
	 * viewPager滑动选择页面
	 * 
	 * @param num
	 *            页数
	 */
	public void select(int num) {
		switch (num) {
		/** 消息列表页 */
		case 0:
			more_layout.setVisibility(View.INVISIBLE);
			menu_msg_iamge.setImageResource(R.drawable.menu_msg_press_image);
			menu_msg_tv.setTextColor(Color.parseColor("#0079dd"));
			menu_conn_iamge.setImageResource(R.drawable.menu_conn_normal_iamge);
			menu_conn_tv.setTextColor(Color.parseColor("#9E9E9E"));
			menu_mine_iamge.setImageResource(R.drawable.menu_mine_normal_image);
			menu_mine_tv.setTextColor(Color.parseColor("#9E9E9E"));

			msg_layout.setEnabled(false);
			connection_layout.setEnabled(true);
			mine_layout.setEnabled(true);
			title_tv.setText(this.getResources().getString( R.string.msg_title));
			init_msg();
			break;
		/** 表格页 */
		case 1:
			more_layout.setVisibility(View.INVISIBLE);
			menu_msg_iamge.setImageResource(R.drawable.menu_msg_normal_image);
			menu_msg_tv.setTextColor(Color.parseColor("#9E9E9E"));
			menu_conn_iamge.setImageResource(R.drawable.menu_conn_press_image);
			menu_conn_tv.setTextColor(Color.parseColor("#0079dd"));
			menu_mine_iamge.setImageResource(R.drawable.menu_mine_normal_image);
			menu_mine_tv.setTextColor(Color.parseColor("#9E9E9E"));
			msg_layout.setEnabled(true);
			connection_layout.setEnabled(false);
			mine_layout.setEnabled(true);
			title_tv.setText(this.getResources().getString( R.string.connection_title));
			
			
			break;

		/** 关于我页 */
		case 2:
			more_layout.setVisibility(View.INVISIBLE);
			menu_msg_iamge.setImageResource(R.drawable.menu_msg_normal_image);
			menu_msg_tv.setTextColor(Color.parseColor("#9E9E9E"));
			menu_conn_iamge.setImageResource(R.drawable.menu_conn_normal_iamge);
			menu_conn_tv.setTextColor(Color.parseColor("#9E9E9E"));
			menu_mine_iamge.setImageResource(R.drawable.menu_mine_pess_image);
			menu_mine_tv.setTextColor(Color.parseColor("#0079dd"));

			msg_layout.setEnabled(true);
			connection_layout.setEnabled(true);
			mine_layout.setEnabled(false);
			title_tv.setText(this.getResources().getString(  R.string.mine_title));
			break;
		}
	}
	
	/**消息列表*/
	public void init_msg(){
		List<List<MsgBean>> dataList=new ArrayList<List<MsgBean>>();
		List<MsgBean> list=new ArrayList<MsgBean>();
		MsgBean bean=new MsgBean();
		list.add(bean);
		list.add(bean);
		list.add(bean);
		dataList.add(list);
		dataList.add(list);
		List<String>group=new ArrayList<String>();
		group.add("我的报销单");
		group.add("审批报销单");
		MsgExpandableListView adapter=new MsgExpandableListView(context, dataList,group);
		msg_exListView.setAdapter(adapter);
		int groupCount = msg_exListView.getCount();   
		for (int i=0; i<groupCount; i++)  
		 {   
			msg_exListView.expandGroup(i);  
		 };  
	}
}

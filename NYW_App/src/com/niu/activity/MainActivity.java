package com.niu.activity;

import java.util.ArrayList;
import java.util.List;

import com.niu.adapter.MsgExpandableListView;
import com.niu.adapter.ViewPagerAdaper;
import com.niu.app.R;
import com.niu.base.BaseActivity;
import com.niu.bean.MsgBean;
import com.niu.util.L;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener {

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
	/**个人中心*/
	private RelativeLayout mycenter_layout;
	/**设置*/
	private RelativeLayout setting_layout;
	/**修改该密码*/
	private RelativeLayout setPwd_layout;
	/**退出系统*/
	private RelativeLayout exit_layout;
	/** 弹出框popu */
	private PopupWindow popupWindow;
	/**整体布局*/
	private RelativeLayout main_layout;
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
		main_layout = (RelativeLayout) this.findViewById(R.id.main_layout);
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
		mycenter_layout=(RelativeLayout) mine_view.findViewById(R.id.menu_mine_mycenter_layout);
		mycenter_layout.setOnClickListener(this);
		setting_layout=(RelativeLayout) mine_view.findViewById(R.id.menu_mine_setting_layout);
		setting_layout.setOnClickListener(this);
		setPwd_layout=(RelativeLayout) mine_view.findViewById(R.id.menu_mine_set_pwd_layout);
		setPwd_layout.setOnClickListener(this);
		exit_layout=(RelativeLayout) mine_view.findViewById(R.id.menu_mine_exit_layout);
		exit_layout.setOnClickListener(this);
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
			viewPager.setCurrentItem(2);
			break;
		/**个人中心*/
		case R.id.menu_mine_mycenter_layout:
			break;
		/**设置*/
		case R.id.menu_mine_setting_layout:
			break;
		/**修改该密码*/
		case R.id.menu_mine_set_pwd_layout:
			Intent intent=new Intent(context,SetPwActivity.class);
			startActivity(intent);
			break;
		/**退出系统*/
		case R.id.menu_mine_exit_layout:
			initPopupWindow();
			popupWindow.setFocusable(true);
			popupWindow.setBackgroundDrawable(new BitmapDrawable());
			popupWindow.showAtLocation(main_layout, Gravity.TOP, 0, 0);
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
	
	/** 系统返回按钮 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				Intent mHomeIntent = new Intent(Intent.ACTION_MAIN, null);
				mHomeIntent.addCategory(Intent.CATEGORY_HOME);
				mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
				this.startActivity(mHomeIntent);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/** 退出弹出框 */
	public void initPopupWindow() {
		if (popupWindow == null) {
			View view = this.getLayoutInflater().inflate(R.layout.popu_exit, null);
			popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT);
			// popupWindow.setAnimationStyle(R.style.PopupAnimation);
			RelativeLayout layout = (RelativeLayout) view
					.findViewById(R.id.popu_edit_layout);
			layout.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if (popupWindow.isShowing()) {
						popupWindow.dismiss();
					}
					return false;
				}
			});
			RelativeLayout close_layout = (RelativeLayout) view
					.findViewById(R.id.popu_exit_frist_layout);
			/** 关闭微信 */
			close_layout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finishActivity();
					finish();
					if (popupWindow.isShowing()) {
						popupWindow.dismiss();
					}
				}
			});
			RelativeLayout exit_layout = (RelativeLayout) view
					.findViewById(R.id.popu_exit_second_layout);
			/** 切换账号 */
			exit_layout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					finishActivity();
					finish();
					if (popupWindow.isShowing()) {
						popupWindow.dismiss();
					}
				}
			});
		}
		if (popupWindow.isShowing()) {
			popupWindow.dismiss();
		}
	}
}

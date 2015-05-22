package com.niu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.niu.app.R;
import com.niu.base.BaseActivity;


/**
 * 登陆
 * 
 * @ClassName: LoginActivity
 * @Description: TODO
 * @author nyw
 * @date 2014-9-28
 */

public class LoginActivity extends BaseActivity implements OnClickListener {

	/** 登陆btn */
	private Button btn;
	/** 用户名edit */
	private EditText username_edit;
	/** 密码edit */
	private EditText password_edit;
	private String username;
	private String password;
	/** 上下文context */
	private Context context;
	private ScrollView scrollView;
	/** 忘记密码 */
	private TextView forget_pw_tv;
	/** handler 消息 */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
		}

	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		this.setContentView(R.layout.activity_login);
		context = this;
		initView();
		initData();
	}

	/** 初始化控件 */
	public void initView() {
		btn = (Button) this.findViewById(R.id.login_btn);
		btn.setOnClickListener(this);
		username_edit = (EditText) this.findViewById(R.id.uername_edit);
		password_edit = (EditText) this.findViewById(R.id.password_edit);
		scrollView = (ScrollView) this.findViewById(R.id.login_scrollView);
		scrollView.setScrollContainer(false);
		forget_pw_tv = (TextView) this.findViewById(R.id.forget_pw_tv);
		forget_pw_tv.setOnClickListener(this);
	}

	/**初始化数据*/
	public void initData(){
		/** tounch事件 */
		username_edit.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				/** 获取焦点 */
				username_edit.requestFocus();
				/** 弹出软件盘 */
				((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
						.showSoftInput(username_edit, 0);
				/** 滚动顶部图片 */
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						scrollView.fullScroll(ScrollView.FOCUS_DOWN);
					}
				}, 200);

				return false;
			}
		});
		/** tounch事件 */
		password_edit.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				/** 获取焦点 */
				password_edit.requestFocus();
				/** 弹出软件盘 */
				((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
						.showSoftInput(password_edit, 0);
				/** 滚动顶部图片 */
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						scrollView.fullScroll(ScrollView.FOCUS_DOWN);
					}
				}, 200);
				return false;
			}
		});
	}
	
	/** 点击事件处理 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			switch (v.getId()) {
			/** 登陆按钮 */
			case R.id.login_btn:
				Intent intent=new Intent(context,MainActivity.class);
				this.startActivity(intent);
				break;
			/** 忘记密码 */
			case R.id.forget_pw_tv:
				
				break;

			}

	}
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

}

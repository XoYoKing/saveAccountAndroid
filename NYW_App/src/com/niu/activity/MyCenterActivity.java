package com.niu.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.niu.app.R;
import com.niu.base.BaseActivity;

public class MyCenterActivity extends BaseActivity{

	/**用户名*/
	private TextView username_tv;
	/**手机号*/
	private TextView phone_tv;
	/**邮箱*/
	private TextView email_tv;
	/**角色*/
	private TextView role_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_mycenter);
	}

	/**初始化控件*/
	public void initView(){
		
	}
	
	/**初始化数据*/
	public void initData(){
		
	}
	
}

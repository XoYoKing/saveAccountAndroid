package com.niu.activity;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.niu.app.R;
import com.niu.base.BaseActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class SetPwActivity extends BaseActivity implements OnClickListener {

	/** 返回layout */
	private RelativeLayout back_layout;
	/** 上下文context */
	private Context context;
	/** 旧密码edit */
	private EditText old_edit;
	/** 新密码edit */
	private EditText set_edit;
	/** 确认密码edit */
	private EditText ok_edit;
	/** 确认按钮 */
	private Button ok_btn;
	/** 原密码 */
	private String old_pw;
	/** 新密码 */
	private String new_pw;
	/**旧密码line*/
	private ImageView old_line;
	/**新密码line*/
	private ImageView set_line;
	/**确认密码Line*/
	private ImageView ok_line;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_set_password);
		this.context = this;
		initView();
		initData();
	}

	/** 初始化控件 */
	public void initView() {
		back_layout = (RelativeLayout) this
				.findViewById(R.id.set_pw_back_layout);
		back_layout.setOnClickListener(this);
		old_edit = (EditText) this.findViewById(R.id.set_pw_old_edit);
		set_edit = (EditText) this.findViewById(R.id.set_pw_new_edit);
		ok_edit = (EditText) this.findViewById(R.id.set_pw_ok_edit);
		ok_btn = (Button) this.findViewById(R.id.set_pw_save_btn);
		ok_btn.setOnClickListener(this);
		old_line=(ImageView) this.findViewById(R.id.set_pw_old_line);
		set_line=(ImageView) this.findViewById(R.id.set_pw_set_line);
		ok_line=(ImageView) this.findViewById(R.id.set_pw_ok_line);
	}

	/** 初始化数据 */
	public void initData() {
		old_edit.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){
					old_line.setImageResource(R.drawable.login_change_username_line);
				}else{
					old_line.setImageResource(R.drawable.login_change_pw_line);
				}
			}});
		set_edit.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){
					set_line.setImageResource(R.drawable.login_change_username_line);
				}else{
					set_line.setImageResource(R.drawable.login_change_pw_line);
				}
			}});
		ok_edit.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){
					ok_line.setImageResource(R.drawable.login_change_username_line);
				}else{
					ok_line.setImageResource(R.drawable.login_change_pw_line);
				}
			}});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			switch (v.getId()) {
			/** 返回按钮 */
			case R.id.set_pw_back_layout:
				this.finish();
				break;
			/** 确认按钮 */
			case R.id.set_pw_save_btn:
				if (isOk())
				break;
			}
	}

	/** 检验方法 */
	public boolean isOk() {
		if (old_edit.getText().toString().trim().isEmpty()) {
			return false;
		} else {
			old_pw = old_edit.getText().toString().trim();
		}
		if (set_edit.getText().toString().trim().isEmpty()) {
			return false;
		} else {
			new_pw = set_edit.getText().toString().trim();
		}
		if (ok_edit.getText().toString().trim().isEmpty()) {
			Toast.makeText(context,
					this.getResources().getString(R.string.set_pw_cod),
					Toast.LENGTH_SHORT).show();
			return false;
		} else {
			if (!ok_edit.getText().toString().trim()
					.equals(set_edit.getText().toString().trim())) {
				Toast.makeText(context,
						this.getResources().getString(R.string.set_pw_cod),
						Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		return true;
	}

//	/** 提交更改内容 */
//	public void UpdateInfo() {
//		if (NetUtil.isNetworkAvailable(context)) {
//			dialog.show();
//			String urlString = Contansts.getInstance().change_pw_url;
//			final RequestParams params = new RequestParams();
//			Token.params(params);
//			params.put("oldpasswd", MD5.hashKeyForDisk(old_pw));
//			params.put("newpasswd", MD5.hashKeyForDisk(new_pw));
//			HttpUtil.put(urlString, params, new JsonHttpResponseHandler() {
//
//				@Override
//				public void onSuccess(JSONObject response) {
//					// TODO Auto-generated method stub
//					try {
//						String code = response.getString("code");
//						/** code返回状态码，1000表示OK */
//						if (code.equals("10000")) {
//							Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT)
//									.show();
//							EMChatManager.getInstance().logout();
//							MyApplication.getInstance().getSpUtil()
//									.setData_conn("0");
//							MyApplication.getInstance().getSpUtil()
//									.setData_org("0");
//							// GroupActivity.group_isUpdate=false;
//							finishActivity();
//							MyApplication.getInstance().getSpUtil()
//									.setexit_type("1");
//							Intent intent = new Intent(context,
//									WelcomeActivity.class);
//							context.startActivity(intent);
//							finish();
//							if (dialog.isShowing()) {
//								dialog.dismiss();
//							}
//						} else {
//							ReturnCode.code(context, code);
//						}
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						if (dialog.isShowing())
//							dialog.dismiss();
//						e.printStackTrace();
//					}
//					if (dialog.isShowing())
//						dialog.dismiss();
//					super.onSuccess(response);
//				}
//
//				/** 访问失败 */
//				@Override
//				public void onFailure(Throwable e, JSONObject errorResponse) {
//					// TODO Auto-generated method stub
//					Toast.makeText(context,
//							GetCodeString.GetMsg(context, R.string.code9997),
//							Toast.LENGTH_SHORT).show();
//					// L.e("修改失败", e.getMessage());
//					if (dialog.isShowing())
//						dialog.dismiss();
//					super.onFailure(e, errorResponse);
//				}
//
//				@Override
//				public void onFailure(int statusCode, Header[] headers,
//						String responseBody, Throwable e) {
//					// TODO Auto-generated method stub
//					// L.e("修改失败", e.getMessage());
//					super.onFailure(statusCode, headers, responseBody, e);
//				}
//
//				@Override
//				public void onSuccess(int statusCode, Header[] headers,
//						String responseBody) {
//					// TODO Auto-generated method stub
//					L.e("返回的json串", responseBody);
//					super.onSuccess(statusCode, headers, responseBody);
//				}
//			});
//		} else {
//			Toast.makeText(context,
//					GetCodeString.GetMsg(context, R.string.code9999),
//					Toast.LENGTH_SHORT).show();
//			if (dialog.isShowing())
//				dialog.dismiss();
//		}
//
//	}

}

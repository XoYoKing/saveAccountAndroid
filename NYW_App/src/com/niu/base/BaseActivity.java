package com.niu.base;

import java.util.ArrayList;

import com.niu.util.L;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;

/**
 * 基类
 * 
 * @ClassName: BaseActivity
 * @Description: TODO
 * @author nyw
 * @date 2014-9-28
 */
public class BaseActivity extends Activity {
	protected static ArrayList<Activity> activityList = new ArrayList<Activity>();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityList.add(this);
	}

	/** 退出程序 */
	public static void exitProgram() {
		if (activityList.size() > 0) {
			for (Activity activity : activityList) {
				activity.finish();
			}
			Process.killProcess(Process.myPid());

		}
	}


	/** 关闭activity */
	public void finishActivity() {
		if (BaseActivity.activityList.size() > 0) {
			for (Activity activity : activityList) {
				activity.finish();
			}
		}

	}

}

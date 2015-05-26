package com.niu.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.niu.adapter.CarCostListViewAdapter;
import com.niu.app.R;
import com.niu.base.BaseActivity;
import com.niu.bean.CarCostBean;

public class AddCarCostActivity extends BaseActivity implements OnClickListener{

	/**数据*/
	private List<CarCostBean> dataList;
	/**上下文context*/
	private Context context;
	/**listView*/
	private ListView listView;
	/**返回按钮*/
	private RelativeLayout back_layout;
	/**标头*/
	private View header_view;
	/**底部*/
	private View footer_view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_addcar);
		context=this;
		initView();
		initData();
	}

	/**初始化控件*/
	public void initView(){
		listView=(ListView) this.findViewById(R.id.addcar_listview);
		back_layout=(RelativeLayout) this.findViewById(R.id.addcar_back_layout);
		back_layout.setOnClickListener(this);
		header_view=this.getLayoutInflater().inflate(R.layout.addcar_header, null);
		footer_view=this.getLayoutInflater().inflate(R.layout.addcar_listview_footer, null);
	}
	
	/**初始化数据*/
	public void initData(){
		dataList=new ArrayList<CarCostBean>();
		CarCostBean bean=new CarCostBean();
		dataList.add(bean);
		dataList.add(bean);
		listView.addHeaderView(header_view);
		listView.addFooterView(footer_view);
		CarCostListViewAdapter adapter=new CarCostListViewAdapter(context, dataList);
		listView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		/**返回*/
		case R.id.addcar_back_layout:
			this.finish();
			break;
		}
	}
}

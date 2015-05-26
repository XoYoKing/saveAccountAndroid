package com.niu.adapter;

import java.util.List;

import com.niu.adapter.MsgExpandableListView.ViewHolder;
import com.niu.app.R;
import com.niu.bean.CarCostBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CarCostListViewAdapter extends BaseAdapter {

	private List<CarCostBean> dataList;
	private Context context;
	private LayoutInflater inflater;
	
	public CarCostListViewAdapter(Context context,List<CarCostBean> dataList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.dataList = dataList;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder=new ViewHolder();
			convertView = inflater.inflate(R.layout.addcar_listview_item,
					null);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	
	class ViewHolder{
		
	}

}

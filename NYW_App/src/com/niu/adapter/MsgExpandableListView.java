package com.niu.adapter;

import java.util.List;

import com.niu.app.R;
import com.niu.bean.MsgBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MsgExpandableListView extends BaseExpandableListAdapter{

	/**数据*/
	private List<List<MsgBean>> child;
	/**群组*/
	private List<String>group;
	/**上下文context*/
	private Context context;
	private LayoutInflater inflater;
	public MsgExpandableListView(Context context,List<List<MsgBean>> child,List<String> group) {
		this.group=group;
		this.child=child;
		this.context=context;
		this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return group.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return child.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=inflater.inflate(R.layout.msg_exlistview_group, null);
		String title=group.get(groupPosition);
		TextView title_tv=(TextView) convertView.findViewById(R.id.msg_listview_group_title);
		title_tv.setText(title);
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder viewHolder;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.msg_exlistview_child_item, null);
			viewHolder = new ViewHolder();		
			viewHolder.title_tv=(TextView)convertView.findViewById(R.id.msg_listview_item_title);
			viewHolder.date_tv=(TextView) convertView.findViewById(R.id.msg_listview_item_date);
			viewHolder.content_tv=(TextView) convertView.findViewById(R.id.msg_listview_item_content);	
			viewHolder.status_tv=(TextView) convertView.findViewById(R.id.msg_listview_item_status);
			viewHolder.iv=(ImageView) convertView.findViewById(R.id.msg_listview_item_image);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
//			viewHolder.box.setChecked(mChecked.get(groupPosition).get(childPosition).get(childPosition));
		}
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	class ViewHolder{
		TextView title_tv;
		TextView date_tv;
		TextView content_tv;
		TextView status_tv;
		ImageView iv;
	}

}

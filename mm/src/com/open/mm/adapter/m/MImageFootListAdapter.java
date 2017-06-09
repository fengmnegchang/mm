/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:24:17
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.adapter.m;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.adapter.CommonAdapter;
import com.open.mm.R;
import com.open.mm.activity.m.MImagePullListActivity;
import com.open.mm.bean.m.MArticleBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:24:17
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MImageFootListAdapter extends CommonAdapter<MArticleBean>{

	public MImageFootListAdapter(Context mContext, List<MArticleBean> list) {
		super(mContext, list);
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_m_image_foot, parent, false);
			viewHolder.text_title = (TextView) convertView.findViewById(R.id.text_title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final MArticleBean bean = (MArticleBean) getItem(position);
		if (bean != null) {
			viewHolder.text_title.setText(bean.getAlt());
			 
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					MImagePullListActivity.startMImagePullListActivity(mContext, bean.getHref());
				}
			});

		}
		return convertView;
	}

	class ViewHolder {
		TextView text_title;
	}
}
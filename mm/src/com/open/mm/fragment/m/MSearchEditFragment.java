/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-8上午11:27:26
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.m;

import java.net.URLEncoder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.open.android.fragment.BaseV4Fragment;
import com.open.android.json.CommonJson;
import com.open.mm.R;
import com.open.mm.activity.m.MSearchArticlePullListActivity;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-8上午11:27:26
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MSearchEditFragment extends BaseV4Fragment<CommonJson, MSearchEditFragment> implements OnClickListener{
	private EditText edit_search;
	private Button btn_search;
	
	public static MSearchEditFragment newInstance(String url, boolean isVisibleToUser) {
		MSearchEditFragment fragment = new MSearchEditFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_m_search_edit, container, false);
		edit_search = (EditText) view.findViewById(R.id.edit_search);
		btn_search = (Button) view.findViewById(R.id.btn_search);
		return view;
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		btn_search.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_search:
			startSearch(edit_search.getText().toString());
			break;
		default:
			break;
		}
	}
	
	public void startSearch(String keys){
		try {
			keys = URLEncoder.encode(keys, "gb2312");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//http://m.mm131.com/search.php?text=%C3%C3%C3%C3&page=2
		String kurl = UrlUtils.MM_M_SEARCH+"text="+keys+"&page=";
		MSearchArticlePullListActivity.startMSearchArticlePullListActivity(getActivity(), kurl);
	}
}

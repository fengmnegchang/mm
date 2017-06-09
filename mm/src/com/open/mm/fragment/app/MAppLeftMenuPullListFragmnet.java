/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-9上午11:38:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.app;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;

import com.open.mm.bean.m.MSlideMenuBean;
import com.open.mm.fragment.m.MLeftMenuPullListFragmnet;
import com.open.mm.json.m.MSlideMenuJson;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-9上午11:38:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MAppLeftMenuPullListFragmnet extends MLeftMenuPullListFragmnet{
	public static MAppLeftMenuPullListFragmnet newInstance(String url, boolean isVisibleToUser) {
		MAppLeftMenuPullListFragmnet fragment = new MAppLeftMenuPullListFragmnet();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.fragment.common.CommonPullToRefreshListFragment#call()
	 */
	@Override
	public MSlideMenuJson call() throws Exception {
		// TODO Auto-generated method stub
		MSlideMenuJson mMSlideMenuJson = new MSlideMenuJson();
//		mMSlideMenuJson.setList(MLeftMenuJsoupService.parseList(url, pageNo));
		List<MSlideMenuBean> list = new ArrayList<MSlideMenuBean>();
		MSlideMenuBean bean = new MSlideMenuBean();
		bean.setTitle("我的收藏");
		list.add(bean);
		
		bean = new MSlideMenuBean();
		bean.setTitle("浏览历史");
		list.add(bean);
		
		
		bean = new MSlideMenuBean();
		bean.setTitle("清空缓存");
		list.add(bean);
		
		
		bean = new MSlideMenuBean();
		bean.setTitle("关于我们");
		list.add(bean);
		mMSlideMenuJson.setList(list);
		return mMSlideMenuJson;
	}
	
	/* (non-Javadoc)
	 * @see com.open.mm.fragment.m.MLeftMenuPullListFragmnet#onItemClick(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
//		super.onItemClick(parent, view, position, id);
	}
}

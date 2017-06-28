/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:13:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.pc;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.open.mm.R;
import com.open.mm.adapter.m.MArticleListAdapter;
import com.open.mm.fragment.m.MArticlePullListFragmnet;
import com.open.mm.json.m.MArticleJson;
import com.open.mm.jsoup.m.MArticleJsoupService;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:13:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PCSearchArticlePullListFragment extends MArticlePullListFragmnet{
	public View headview;
	public String keys;
	
	public static PCSearchArticlePullListFragment newInstance(String url,String keys, boolean isVisibleToUser) {
		PCSearchArticlePullListFragment fragment = new PCSearchArticlePullListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		fragment.keys = keys;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pulllistview, container, false);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		headview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_expend_footview, null);
		return view;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
		PCSearchHeadExpendListFragmnet ffragment = PCSearchHeadExpendListFragmnet.newInstance(url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_expend_foot, ffragment).commit();
		// TODO Auto-generated method stub
		mMArticleListAdapter = new MArticleListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mMArticleListAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.fragment.common.CommonPullToRefreshListFragment#call()
	 */
	@Override
	public MArticleJson call() throws Exception {
		// TODO Auto-generated method stub
		MArticleJson mMArticleJson = new MArticleJson();
		mMArticleJson.setList(MArticleJsoupService.parsePCSearchList(url,keys,pageNo));
		return mMArticleJson;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.fragment.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		default:
			break;
		}
	}

}

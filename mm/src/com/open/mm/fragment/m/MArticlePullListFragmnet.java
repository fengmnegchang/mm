/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:33:37
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.m;

import android.util.Log;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.open.android.fragment.common.CommonPullToRefreshListFragment;
import com.open.mm.adapter.m.MArticleListAdapter;
import com.open.mm.bean.m.MArticleBean;
import com.open.mm.json.m.MArticleJson;
import com.open.mm.jsoup.m.MArticleJsoupService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:33:37
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MArticlePullListFragmnet extends CommonPullToRefreshListFragment<MArticleBean, MArticleJson> {
	public MArticleListAdapter mMArticleListAdapter;

	public static MArticlePullListFragmnet newInstance(String url, boolean isVisibleToUser) {
		MArticlePullListFragmnet fragment = new MArticlePullListFragmnet();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		mMArticleListAdapter = new MArticleListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mMArticleListAdapter);
		mPullToRefreshListView.setMode(Mode.PULL_FROM_START);
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
		mMArticleJson.setList(MArticleJsoupService.parseList(url, pageNo));
		return mMArticleJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.fragment.common.CommonPullToRefreshListFragment#onCallback
	 * (com.open.android.json.CommonJson)
	 */
	@Override
	public void onCallback(MArticleJson result) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
			list.clear();
			list.addAll(result.getList());
			pageNo = 1;
		} else {
			if (result.getList() != null && result.getList().size() > 0) {
				list.addAll(result.getList());
			}
		}
		mMArticleListAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullToRefreshListView.onRefreshComplete();
	}

}

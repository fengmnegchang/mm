/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:31:34
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.pc;

import com.open.mm.fragment.m.MImageFootExpendListFragmnet;
import com.open.mm.json.m.MArticleJson;
import com.open.mm.jsoup.pc.PCNavJsoupService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:31:34
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PCSearchHeadExpendListFragmnet extends MImageFootExpendListFragmnet{
	public static PCSearchHeadExpendListFragmnet newInstance(String url, boolean isVisibleToUser) {
		PCSearchHeadExpendListFragmnet fragment = new PCSearchHeadExpendListFragmnet();
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
	public MArticleJson call() throws Exception {
		// TODO Auto-generated method stub
		MArticleJson mMArticleJson = new MArticleJson();
		mMArticleJson.setList(PCNavJsoupService.parsePCSearchHeadList(url, pageNo));
		return mMArticleJson;
	}

}

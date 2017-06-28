/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:05:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.fragment.pc;

import java.net.URLEncoder;

import com.open.mm.activity.pc.PCSearchArticlePullListActivity;
import com.open.mm.adapter.m.MSlideMenuAdapter;
import com.open.mm.bean.m.MSlideMenuBean;
import com.open.mm.fragment.m.MSearchEditFragment;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:05:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PCSearchKeysFragment extends MSearchEditFragment {
	public static PCSearchKeysFragment newInstance(String url, boolean isVisibleToUser) {
		PCSearchKeysFragment fragment = new PCSearchKeysFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		MSlideMenuBean bean = new MSlideMenuBean();
		bean.setTitle("性感美女");
		list.add(bean);
		
		bean = new MSlideMenuBean();
		bean.setTitle("mm");
		list.add(bean);
		
		bean = new MSlideMenuBean();
		bean.setTitle("图片");
		list.add(bean);
		
		bean = new MSlideMenuBean();
		bean.setTitle("妹子图");
		list.add(bean);
		
		bean = new MSlideMenuBean();
		bean.setTitle("人体艺术");
		list.add(bean);
		
		mMSlideMenuAdapter = new MSlideMenuAdapter(getActivity(), list);
		grid_hot.setAdapter(mMSlideMenuAdapter);
	}
	@Override
	public void startSearch(String keys){
		String title = keys;
		try {
			keys = URLEncoder.encode(keys, "gb2312");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//http://www.mm131.com/search/?kwtype=0&keyword=%D0%D4%B8%D0%C3%C0%C5%AE 
		//key=%D0%D4%B8%D0%C3%C0%C5%AE&page=2
		String kurl = UrlUtils.MM_PC_SEARCH+keys;
		PCSearchArticlePullListActivity.startPCSearchArticlePullListActivity(getActivity(), kurl,keys);
	}
}

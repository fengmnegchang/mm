/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:12:36
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.activity.pc;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.open.mm.R;
import com.open.mm.activity.m.MCommonTitleBarActivity;
import com.open.mm.fragment.pc.PCSearchArticlePullListFragment;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:12:36
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PCSearchArticlePullListActivity extends MCommonTitleBarActivity{
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
//		super.initValue();
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.MM_PC;
		}
		try {
			setCenterTextValue(URLDecoder.decode(getIntent().getStringExtra("TITLE"),"gb2312"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		setRightVisivableGone();
		setLeftImageResId(R.drawable.left01);
		setLeftTextVisivable(false);
		addfragment();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
		Fragment fragment = PCSearchArticlePullListFragment.newInstance(url,getIntent().getStringExtra("TITLE"), true);
		getSupportFragmentManager().beginTransaction().replace(R.id.layout_content, fragment).commit();
	}

	public static void startPCSearchArticlePullListActivity(Context context, String url,String title) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.putExtra("TITLE", title);
		intent.setClass(context, PCSearchArticlePullListActivity.class);
		context.startActivity(intent);
	}
}

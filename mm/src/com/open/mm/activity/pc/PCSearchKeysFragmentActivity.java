/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:03:38
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.activity.pc;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.open.mm.R;
import com.open.mm.activity.m.MCommonTitleBarActivity;
import com.open.mm.fragment.pc.PCSearchKeysFragment;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-28上午10:03:38
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PCSearchKeysFragmentActivity extends MCommonTitleBarActivity {
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
		setCenterTextValue("搜索");
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
		Fragment fragment = PCSearchKeysFragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.layout_content, fragment).commit();
	}

	public static void startPCSearchKeysFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, PCSearchKeysFragmentActivity.class);
		context.startActivity(intent);
	}
 
}

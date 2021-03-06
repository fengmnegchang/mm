/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-8上午10:26:02
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.activity.m;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.open.mm.R;
import com.open.mm.fragment.m.MArticlePullListFragmnet;
import com.open.mm.fragment.m.MLeftMenuPullListFragmnet;
import com.open.mm.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-8上午10:26:02
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMainSlideMenuActivity extends SlidingFragmentActivity {
	private String url = UrlUtils.MM_M;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setStatusBarColor(getResources().getColor(R.color.status_bar_color));
		setContentView(R.layout.activity_m_main_slide);
		// 初始化SlideMenu
		initRightMenu();

		// url = "http://www.umei.cc/bizhitupian/diannaobizhi/7628.htm";
		// Fragment fragment = UmeiArticlePagerFragment.newInstance(url, true);
//		Fragment fragment = MIndexPagerFragment.newInstance(url,true);
		Fragment fragment = MArticlePullListFragmnet.newInstance(url,true);
		getSupportFragmentManager().beginTransaction().replace(R.id.layout_viewpager, fragment).commit();
	}

	private void initRightMenu() {

		setBehindContentView(R.layout.left_menu_frame);
//		getSupportFragmentManager().beginTransaction().replace(R.id.id_left_menu_frame,new MenuLeftFragment()).commit();
		getSupportFragmentManager().beginTransaction().replace(R.id.id_left_menu_frame,MLeftMenuPullListFragmnet.newInstance(url, true)).commit();
		
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		// 设置滑动菜单视图的宽度
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// menu.setBehindWidth()
		// 设置渐入渐出效果的值
		menu.setFadeDegree(0.35f);
		// menu.setBehindScrollScale(1.0f);
		menu.setSecondaryShadowDrawable(R.drawable.shadow);
		// // 设置右边（二级）侧滑菜单
		// menu.setSecondaryMenu(R.layout.right_menu_frame);
		// Fragment rightMenuFragment = new MenuRightFragment();
		// getSupportFragmentManager().beginTransaction().replace(R.id.id_right_menu_frame,
		// rightMenuFragment).commit();
	}

	public void showLeftMenu(View view) {
		getSlidingMenu().showMenu();
	}
	
	public void toSearch(View view) {
//		MSearchEditFragmentActivity.startMSearchEditFragmentActivity(this, url);
		MCommonTitleBarSearchEditFragmentActivity.startMCommonTitleBarSearchEditFragmentActivity(this, url);
	}

}
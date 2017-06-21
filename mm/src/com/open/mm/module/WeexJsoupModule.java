/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-21下午4:25:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.module;

import android.util.Log;

import com.google.gson.Gson;
import com.open.andenginetask.CallEarliest;
import com.open.andenginetask.Callable;
import com.open.andenginetask.Callback;
import com.open.android.module.WeexBaseJsoupModule;
import com.open.mm.json.m.MArticleJson;
import com.open.mm.jsoup.m.MArticleJsoupService;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModuleAnno;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-21下午4:25:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class WeexJsoupModule extends WeexBaseJsoupModule {
	public String TAG = WeexBaseJsoupModule.class.getSimpleName();

	/***
	 * 头部pager导航
	 * @param params
	 * @param callback
	 */
	@SuppressWarnings("unchecked")
	@WXModuleAnno(moduleMethod = true, runOnUIThread = true)
	public void mMArticle(final String params, final String callback) {
		Log.d(TAG, "focuspager ========" + params);
		JSONObject jsonObject = null;
		try {
			jsonObject = JSON.parseObject(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		final String url = jsonObject.getString("url");
		final int pageNo = jsonObject.getInteger("pageNo");
		try {
			doAsync(new CallEarliest<MArticleJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MArticleJson>() {
				@Override
				public MArticleJson call() throws Exception {
					MArticleJson mMArticleJson = new MArticleJson();
					mMArticleJson.setList(MArticleJsoupService.parseList(url, pageNo));
					return mMArticleJson;
				}
			}, new Callback<MArticleJson>() {
				@Override
				public void onCallback(MArticleJson result) {
					Gson gson = new Gson();
					WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callback, gson.toJson(result));
				}
			});
			// 发起请求
			// new Thread(new Runnable() {
			// @Override
			// public void run() {
			// MSwiperJson mIndexFocusJson = new MSwiperJson();
			// mIndexFocusJson.setList(MSwiperService.parsePCFocus(params));
			// Gson gson = new Gson();
			// WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(),
			// callback, gson.toJson(mIndexFocusJson));
			// }
			// }).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

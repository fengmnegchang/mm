/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:45:37
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.react.modules;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.Gson;
import com.open.andenginetask.CallEarliest;
import com.open.andenginetask.Callable;
import com.open.andenginetask.Callback;
import com.open.mm.json.m.MSlideMenuJson;
import com.open.mm.jsoup.m.MLeftMenuJsoupService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:45:37
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ReactMMJsoupModule extends ReactBaseJsoupModule{

	public ReactMMJsoupModule(ReactApplicationContext reactContext) {
		super(reactContext);
	}
	
	/***
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void mleftmenu(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "mleftmenu ========" + params);
		try {
			doAsync(new CallEarliest<MSlideMenuJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MSlideMenuJson>() {
				@Override
				public MSlideMenuJson call() throws Exception {
					MSlideMenuJson mMSlideMenuJson = new MSlideMenuJson();
					mMSlideMenuJson.setList(MLeftMenuJsoupService.parseList(params, 1));
					return mMSlideMenuJson;
				}
			}, new Callback<MSlideMenuJson>() {
				@Override
				public void onCallback(MSlideMenuJson result) {
					Gson gson = new Gson();
					successCallback.invoke("data",gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			errorCallback.invoke("error",e.toString());
		}
	}

}

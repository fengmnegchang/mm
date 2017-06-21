/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-21下午4:55:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.module;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;

import com.open.android.activity.common.CommonWebViewActivity;
import com.open.android.module.WXEventModule;
import com.taobao.weex.common.WXModuleAnno;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-6-21下午4:55:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class WeeXEventModule extends WXEventModule {

	/**
	 * 跳转公共webview
	 * 
	 * @param url
	 */
	@WXModuleAnno(runOnUIThread = true)
	public void startWebViewActivity(String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(mWXSDKInstance.getContext(), CommonWebViewActivity.class);
		mWXSDKInstance.getContext().startActivity(intent);
	}
	
	/**
	 * 跳转到原生activity
	 * @param className
	 * @param optionJson
	 *            要去的activity intent传值必须为String
	 * @description:
	 */
	@WXModuleAnno(runOnUIThread = false)
	public void startNativeActivity(String className, String optionJson) {
		try {
			Class<?> cls = Class.forName(className);
			Intent intent = new Intent(mWXSDKInstance.getContext(), cls);
			if (optionJson != null && optionJson.length() > 0) {
				JSONObject jsonObject = new JSONObject(optionJson);
				if (jsonObject != null) {
					Iterator<String> iterator = jsonObject.keys();
					while (iterator.hasNext()) {
						String key = (String) iterator.next();
						String value = jsonObject.getString(key);
						intent.putExtra(key, value);
					}
				}
			}
			// 如跳帖子页面
			// var
			// optionJson='{"TOPIC_ID_KEY":"1415605","TOPIC_REPLY_ID_KEY":"0"}';
			// weexEventModule.startOtherNativeActivity("com.taoguba.app.activity.TaogubaTopicActivity",optionJson);
			mWXSDKInstance.getContext().startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到原生 任意activity
	 * @param className
	 *            要去的activity
	 * @param optionJson
	 *            intentKeyValueClassName为intent支持传值类型
	 *            String、double、ArrayList<String>、MsgAndReMsgBean
	 * @description:
	 */
	@WXModuleAnno(runOnUIThread = false)
	public void startOtherNativeActivity(String className, String optionJson) {
		try {
			Class<?> cls = Class.forName(className);
			Intent intent = new Intent(mWXSDKInstance.getContext(), cls);
			intent = getIntentFromOptionJson(mWXSDKInstance.getContext(), intent, optionJson, null);
			// 如跳帖子页面
			// var
			// optionJson=[{"intentKey":"intnet传值Key","intentKeyValueClassName":"intent传值类型名","intentKeyValue":"intent所传值"},{"intentKey":"intnet传值Key","intentKeyValueClassName":"intent传值类型名","intentKeyValue":"intent所传值"}];
			// weexEventModule.startOtherNativeActivity("com.taoguba.app.activity.TaogubaTopicActivity",optionJson);
			mWXSDKInstance.getContext().startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 从json中获取参数传入到intent中去 适合app中所有跳转
	 * @author :Atar
	 * @createTime:2017-5-24上午11:25:36
	 * @version:1.0.0
	 * @modifyTime:
	 * @modifyAuthor:
	 * @param intent
	 * @param list
	 * @return
	 * @description:
	 */
	public static Intent getIntentFromOptionJson(Context context, Intent intent, String optionJson, String onEventInfo) {
		try {
			if (optionJson != null && optionJson.length() > 0) {// 解析跳转传入参数
				JSONArray jsonArray = new JSONArray(optionJson);
				if (jsonArray != null && jsonArray.length() > 0) {
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						if (jsonObject != null) {
							if (jsonObject.has("intentKeyValueClassName")) {
								String intentKeyValueClassName = jsonObject.getString("intentKeyValueClassName");
								String intentKey = jsonObject.getString("intentKey");
								if ("int".equals(intentKeyValueClassName)) {
									int intentKeyValue = jsonObject.getInt("intentKeyValue");
									intent.putExtra(intentKey, intentKeyValue);
								} else if ("String".equals(intentKeyValueClassName)) {
									String intentKeyValue = jsonObject.getString("intentKeyValue");
//									if (intentKeyValue != null) {
//										if (intentKeyValue.contains(".js") && intentKeyValue.contains("build/src")) {
//											// 传入weex js地址 ，自动原生 拼接可切换环境
//											try {
//												String[] str = intentKeyValue.split("/");
//												if (str != null && str.length > 0) {
//													String path = str[0];
//													path = WeexUtils.IP.contains("com.cn") ? path + "/" : "";
//													intentKeyValue = WeexUtils.WEEX_HOST + path + intentKeyValue;
//												}
//											} catch (Exception e) {
//
//											}
//										} else if (intentKeyValue.contains(".html") && intentKeyValue.contains("assets/html")) {
//											// 传入html地址 ，自动原生 拼接可切换环境
//											intentKeyValue = WeexUtils.WEEX_HOST + intentKeyValue;
//										}
//									}
									intent.putExtra(intentKey, intentKeyValue);
								} else if ("double".equals(intentKeyValueClassName)) {
									double intentKeyValue = jsonObject.getDouble("intentKeyValue");
									intent.putExtra(intentKey, intentKeyValue);
								} else if ("ArrayList<String>".equals(intentKeyValueClassName)) {
									String json = jsonObject.getString("intentKeyValue");
									if (json != null && json.length() > 0) {
										JSONArray jsonArray1 = new JSONArray(json);
										ArrayList<String> list = new ArrayList<String>();
										for (int j = 0; j < jsonArray1.length(); j++) {
											list.add(jsonArray1.getString(j));
										}
										intent.putStringArrayListExtra(intentKey, list);
									}
								} 
								
//								else if ("MsgAndReMsgBean".equals(intentKeyValueClassName)) {
//									String json = jsonObject.getString("intentKeyValue");
//									Gson gson = new Gson();
//									MsgAndReMsgBean mMsgAndReMsgBean = gson.fromJson(json, MsgAndReMsgBean.class);
//									intent.putExtra(intentKey, (Serializable) mMsgAndReMsgBean);
//								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
//		try {
//			if (onEventInfo != null && onEventInfo.length() > 0) {// 解析点击统计事件
//				JSONObject onEventJson = new JSONObject(onEventInfo);
//				if (onEventJson != null) {
//					String eventType = "";
//					String eventID = "";
//					String eventName = "";
//					if (onEventJson.has("eventType")) {
//						eventType = onEventJson.getString("eventType");
//					}
//					if (onEventJson.has("eventID")) {
//						eventID = onEventJson.getString("eventID");
//					}
//					if (onEventJson.has("eventName")) {
//						eventName = onEventJson.getString("eventName");
//					}
//					if ("0".equals(eventType)) {
//						// 百度统计
//						StatService.onEvent(context, eventID, eventName, 1);
//					} else if ("1".equals(eventType)) {
//						// 友盟统计
//						MobclickAgent.onEvent(context, eventName);
//					}
//				}
//			}
//		} catch (Exception e) {
//		}
		return intent;
	}

}

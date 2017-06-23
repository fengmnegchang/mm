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

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;
import com.open.andenginetask.CallEarliest;
import com.open.andenginetask.Callable;
import com.open.andenginetask.Callback;
import com.open.mm.json.m.MArticleJson;
import com.open.mm.json.m.MSlideMenuJson;
import com.open.mm.jsoup.m.MArticleJsoupService;
import com.open.mm.jsoup.m.MLeftMenuJsoupService;
import com.open.mm.utils.UrlUtils;

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
	
	
	/***
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void marticle(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "marticle ========" + params);
		try {
			JSONObject jsonObject = null;
			try {
				jsonObject = JSONObject.fromObject(params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final String url = jsonObject.getString("url");
			final int pageNo = jsonObject.getInt("pageNo");
			if(pageNo==1){
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
						successCallback.invoke("data",gson.toJson(result));
					}
				});
			}else{
				String href = UrlUtils.MM_M_MAIN_MORE+pageNo;
				final Map<String, String> headers  = new HashMap<String, String>();
//				headers.put("Cookie", "yka_gid=45d53573-9ff3-c9a5-1ef9-2133b1f52365; UM_distinctid=15bd6a1663777-0924f97c4d1129-35414878-1aeaa0-15bd6a166381be; a=rYWRb0VDLuA6; analyse_author_id=808b3dabacb64e72be216db6393e80cf; not.use.page.proxy=http%3A%2F%2Fwww.yoka.com%2Fdna%2Fm%2Fa6; __SessionHandler=8897c5ca7f3fbae9661563e18fb96904; KM.PASSPORT.MEMBER=uid%3D8687946%26guid%3D18534ef9e1169780ecf03e9107fb1a88%26id%3D%E5%BE%A1%E5%AE%88uodaztspr%26nickName%3D%E5%BE%A1%E5%AE%88uodaztspr%26nick%3D%26third_source%3D1%26visitDate%3D1496211949%26pwd%3Dd41d8cd98f00b204e9800998ecf8427e%26sign2%3D7d2f1f5200957df4b3e9d23664ff9fc2%26sighbbs%3D87B2F99A1B36D348BCCD5332B4E5531C%26avatar_url%3Dhttp%3A%2F%2Fucenter.yoka.com%2Fdata%2Favatar%2F008%2F68%2F79%2F46_avatar_small.jpg%26expire_time%3D604800%26is_validate%3D0%26open_id%3D%26qq_nick%3D%26real_name%3D%26third%3D1%26sign%3D77f91d969b8b66b811d546a9b236207c; KM.PASSPORT.MEMBER.LastLogin=login_time%3D1496211949%26register_time%3D%26reg_source%3D%26login_source%3D; KM.PASSPORT.MEMBER.TRACK=uid%3D8687946%26nickName%3D%E5%BE%A1%E5%AE%88uodaztspr; KM.PASSPORT.MEMBERGUID=18534ef9e1169780ecf03e9107fb1a88; yokaATC=yoka,535,2743,2715,1496213180016,www.yoka.com%2Fdna%2Fm%2F; ADVS=35289fbbea9bd9; ASL=17318,ppzkk,74e218de74e218de74e218de74e218de74e218de; yka_ph=%7B%20%27value%27%3A%20%2700000000000000010000101100011%27%2C%27lastdate%27%3A%20%271496246400000%27%7D; yka_srchost=www.yoka.com/dna; __clickidc=149155608220710046; ADVC=34fd9c408bfbc0; yka_tid=19cc9c8b-e231-a8aa-723f-decf1001b468; Hm_lvt_a641a94f2a28291909af4213f237173a=1495611999,1495782766,1496198049,1496284030; Hm_lpvt_a641a94f2a28291909af4213f237173a=1496284423");  
				headers.put("User-Agent", UrlUtils.userAgent);
				//Accept-Language:zh-CN,zh;q=0.8
				headers.put("charset", "gb2312");
				RequestQueue requestQueue = Volley.newRequestQueue(getReactApplicationContext());
				StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET,href ,
						new Listener<String>() {
							@Override
							public void onResponse(String response) {
								MArticleJson mMArticleJson = new MArticleJson();
								mMArticleJson.setList(MArticleJsoupService.parseList(response, pageNo));
								Gson gson = new Gson();
								successCallback.invoke("data",gson.toJson(mMArticleJson));
							}
						}, null)
		 	{
					
//					/* (non-Javadoc)
//					 * @see com.android.volley.toolbox.StringRequest#getHeaders()
//					 */
//					@Override
//					public Map<String, String> getHeaders() throws AuthFailureError {
//						// TODO Auto-generated method stub
//						return headers;
//					}
		 
				
//				 protected Response<String>  parseNetworkResponse(NetworkResponse response)  
//			        {  
//					 
//					 String parsed = null;
//				        try {
//				            parsed = new String(response.data, "gb2312");
//				        } catch (UnsupportedEncodingException e) {
//				            try {
//								parsed = new String(response.data,"gb2312");
//							} catch (UnsupportedEncodingException e1) {
//								e1.printStackTrace();
//							}
//				        }
//				        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
//			        }
		 		}
				;
				requestQueue.add(jsonObjectRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCallback.invoke("error",e.toString());
		}
	}
	
	/***
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void msearch(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "msearch ========" + params);
		try {
			JSONObject jsonObject = null;
			try {
				jsonObject = JSONObject.fromObject(params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final String url = jsonObject.getString("url");
			final int pageNo = jsonObject.getInt("pageNo");
			doAsync(new CallEarliest<MArticleJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MArticleJson>() {
				@Override
				public MArticleJson call() throws Exception {
					MArticleJson mMArticleJson = new MArticleJson();
					mMArticleJson.setList(MArticleJsoupService.parseSearchList(url, pageNo));
					return mMArticleJson;
				}
			}, new Callback<MArticleJson>() {
				@Override
				public void onCallback(MArticleJson result) {
					Gson gson = new Gson();
					successCallback.invoke("data",gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			errorCallback.invoke("error",e.toString());
		}
	}
	
	
	/***
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void mimagehead(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "mimagehead ========" + params);
		try {
			doAsync(new CallEarliest<MArticleJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MArticleJson>() {
				@Override
				public MArticleJson call() throws Exception {
					MArticleJson mMArticleJson = new MArticleJson();
					mMArticleJson.setList(MArticleJsoupService.parseImageList(params, 1));
					return mMArticleJson;
				}
			}, new Callback<MArticleJson>() {
				@Override
				public void onCallback(MArticleJson result) {
					Gson gson = new Gson();
					successCallback.invoke("data",gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			errorCallback.invoke("error",e.toString());
		}
	}
	
	/***
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void mimagefoot(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "mimagefoot ========" + params);
		try {
			doAsync(new CallEarliest<MArticleJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MArticleJson>() {
				@Override
				public MArticleJson call() throws Exception {
					MArticleJson mMArticleJson = new MArticleJson();
					mMArticleJson.setList(MArticleJsoupService.parseFootList(params, 1));
					return mMArticleJson;
				}
			}, new Callback<MArticleJson>() {
				@Override
				public void onCallback(MArticleJson result) {
					Gson gson = new Gson();
					successCallback.invoke("data",gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			errorCallback.invoke("error",e.toString());
		}
	}
	
	
	/***
	 * 
	 * @param params
	 * @param callback
	 */
	@ReactMethod
	public void mimagelist(final String params, final com.facebook.react.bridge.Callback successCallback,final com.facebook.react.bridge.Callback errorCallback) {
		Log.d(getName(), "mimagelist ========" + params);
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		final String url = jsonObject.getString("url");
		final int pageNo = jsonObject.getInt("pageNo");
		try {
			doAsync(new CallEarliest<MArticleJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MArticleJson>() {
				@Override
				public MArticleJson call() throws Exception {
					MArticleJson mMArticleJson = new MArticleJson();
					mMArticleJson.setList(MArticleJsoupService.parseImageList(url, pageNo));
					return mMArticleJson;
				}
			}, new Callback<MArticleJson>() {
				@Override
				public void onCallback(MArticleJson result) {
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

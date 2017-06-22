/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:15:59
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.react.packages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.open.mm.react.modules.MMCircleManager;
import com.open.mm.react.modules.MMDialogModule;
import com.open.mm.react.modules.ReactMMJsoupModule;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:15:59
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMReactPackage implements ReactPackage {
	@Override
	public List<Class<? extends JavaScriptModule>> createJSModules() {
		return Collections.emptyList();
	}

	/**
	 * module
	 * 
	 * @param reactContext
	 * @return
	 */
	@Override
	public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
		List<NativeModule> modules = new ArrayList<NativeModule>();
//		modules.add(new ToastModule(reactContext));
//		modules.add(new MMDialogModule(reactContext));
		modules.add(new ReactMMJsoupModule(reactContext));
		return modules;
	}

	/**
	 * 创建原生UI组件控制器
	 * 
	 * @param reactContext
	 * @return
	 */
	@Override
	public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
		return Arrays.<ViewManager> asList(
//				new MMCircleManager()
//				new VideoViewManager(),
//				new RCTVideoViewManager(),
//				new RCTReactImageManager(),
//				new ReactWebViewManager(),
//				new ReactSwipeRefreshLayoutManager()
				);
	}
}


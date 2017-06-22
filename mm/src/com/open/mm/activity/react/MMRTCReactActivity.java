/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:08:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.activity.react;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.BuildConfig;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.shell.MainReactPackage;
import com.open.android.react.packages.CommonReactPackage;
import com.open.mm.react.packages.MMReactPackage;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:08:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMRTCReactActivity extends com.open.android.react.MainActivity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
        initReactRoot();
    }
    
    /**
     * 接受页面传参
     */
    @Override
    public void initIntent(){
//    	super.initIntent();
    	if(getIntent().getStringExtra("bundleAssetName")!=null){
    		bundleAssetName = getIntent().getStringExtra("bundleAssetName");
    	}
    	if(getIntent().getStringExtra("jSMainModuleName")!=null){
    		jSMainModuleName = getIntent().getStringExtra("jSMainModuleName");
    	}
    	if(getIntent().getStringExtra("moduleName")!=null){
    		moduleName = getIntent().getStringExtra("moduleName");
    	}
    }
    
    /**
     * 初始化rootview
     */
    @Override
    public void initReactRoot(){
//    	super.initReactRoot();
    	mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName(bundleAssetName)
                .setJSMainModuleName(jSMainModuleName)
                .addPackage(new MainReactPackage())
                .addPackage(new CommonReactPackage())
                .addPackage(new MMReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, moduleName, null);

        setContentView(mReactRootView);
    }

	
	  public static void startMMRTCReactActivity(Context context,String bundleAssetName,String jSMainModuleName,String moduleName){
	    	Intent intent = new Intent();
	    	intent.setClass(context, MMRTCReactActivity.class);
	    	intent.putExtra("bundleAssetName", bundleAssetName);
	    	intent.putExtra("jSMainModuleName", jSMainModuleName);
	    	intent.putExtra("moduleName", moduleName);
	    	context.startActivity(intent);
	    }
}

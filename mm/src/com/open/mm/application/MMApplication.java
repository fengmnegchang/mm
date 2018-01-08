/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:54:31
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.application;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import android.app.Application;

import com.facebook.drawee.BuildConfig;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.open.android.react.packages.CommonReactPackage;
import com.open.mm.react.packages.MMReactPackage;
import com.open.mm.utils.AuthImageDownloader;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:54:31
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
//implements ReactApplication
public class MMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        SoLoader.init(this, /* native exopackage */ false);
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration =   new ImageLoaderConfiguration.Builder(this).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs() // Remove for release app
                .imageDownloader(new AuthImageDownloader(this))
                .build();
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
    }
    
//    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
//		@Override
//		protected boolean getUseDeveloperSupport() {
//			return BuildConfig.DEBUG;
//		}
//
//		@Override
//		protected List<ReactPackage> getPackages() {
//			// return Arrays.<ReactPackage>asList(
//			// new MainReactPackage()
//			// );
//			return Arrays.<ReactPackage> asList(new MainReactPackage(), // 这个是自动创建
//					new CommonReactPackage(), // 这个类是我们创建的
//					new MMReactPackage()
//					);
//		}
//
//		/* (non-Javadoc)
//		 * @see com.facebook.react.ReactNativeHost#createReactInstanceManager()
//		 */
//		@Override
//		protected ReactInstanceManager createReactInstanceManager() {
//			// TODO Auto-generated method stub
//			ReactInstanceManager mReactInstanceManager = ReactInstanceManager.builder()
//					.setApplication(MMApplication.this)
//					.setBundleAssetName(getBundleAssetName())
//					.setJSMainModuleName(getJSMainModuleName())
//					.addPackage(new MainReactPackage())
////					.addPackage(new CommonReactPackage())
//					.addPackage(new MMReactPackage())
//					.setUseDeveloperSupport(BuildConfig.DEBUG)
//					.setInitialLifecycleState(LifecycleState.RESUMED).build();
//			return mReactInstanceManager;
////			return super.createReactInstanceManager();
//		}
//
//		/* (non-Javadoc)
//		 * @see com.facebook.react.ReactNativeHost#getBundleAssetName()
//		 */
//		@Override
//		@Nullable
//		protected String getBundleAssetName() {
//			// TODO Auto-generated method stub
//			return super.getBundleAssetName();
//		}
//
//		/* (non-Javadoc)
//		 * @see com.facebook.react.ReactNativeHost#getJSBundleFile()
//		 */
//		@Override
//		@Nullable
//		protected String getJSBundleFile() {
//			// TODO Auto-generated method stub
//			return super.getJSBundleFile();
//		}
//
//		/* (non-Javadoc)
//		 * @see com.facebook.react.ReactNativeHost#getJSMainModuleName()
//		 */
//		@Override
//		protected String getJSMainModuleName() {
//			// TODO Auto-generated method stub
//			return super.getJSMainModuleName();
//		}
//
//		/* (non-Javadoc)
//		 * @see com.facebook.react.ReactNativeHost#getReactInstanceManager()
//		 */
//		@Override
//		public ReactInstanceManager getReactInstanceManager() {
//			// TODO Auto-generated method stub
//			return super.getReactInstanceManager();
//		}
//		
//		
//	};
//
//	@Override
//	public ReactNativeHost getReactNativeHost() {
//		return mReactNativeHost;
//	}

}
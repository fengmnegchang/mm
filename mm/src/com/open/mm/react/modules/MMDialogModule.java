/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:21:19
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.react.modules;

import android.content.Context;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-22下午4:21:19
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMDialogModule extends ReactContextBaseJavaModule {
    private Context mContext;

    public MMDialogModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    // 复写方法，返回react-native中调用的 组件名
    @Override
    public String getName() {
        return "MMDialogModule";
    }

    // 使用 @ReactMethod注解返回react-native中可调用的 方法
    @ReactMethod
    public void show(final Callback successCallback) {
        //新建自定义对话框
//        final SelectDateDialog dialog = new SelectDateDialog(getCurrentActivity());
//        dialog.show();
//        //得到dialog的确定按钮并设置点击事件
//        dialog.getBtnCollectOk().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //回调方法，将所选日期返回
//                successCallback.invoke(dialog.getSelectDate());
//                dialog.dismiss();
//            }
//        });
    }
}
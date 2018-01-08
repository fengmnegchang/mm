/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-23上午11:14:49
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.activity.react;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.gson.Gson;
import com.open.android.react.RCTReactActivity;
import com.open.mm.R;
import com.open.mm.adapter.react.ReactAdapter;
import com.open.mm.bean.react.ReactBean;
import com.open.mm.json.react.ReactJson;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-23上午11:14:49
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ReactListActivity extends AppCompatActivity {
	ListView listview;
	ReactAdapter mReactAdapter;
	List<ReactBean> list = new ArrayList<ReactBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_all);
		listview = (ListView) findViewById(R.id.listview);
		
		mReactAdapter = new ReactAdapter(this, list);
		listview.setAdapter(mReactAdapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (id != -1 && list.get((int) id) != null) {
					ReactBean bean = list.get((int) id);
					MMRTCReactActivity.startMMRTCReactActivity(ReactListActivity.this, bean.getBundleAssetName(), bean.getjSMainModuleName(), bean.getModuleName());
//					RCTReactActivity.startRCTReactActivity(ReactListActivity.this, bean.getBundleAssetName(), bean.getjSMainModuleName(), bean.getModuleName());
				}
			}
		});
		
		new Thread(){
			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				reactlist();
//				if(list==null || list.size()==0){
//					readAsset();
//				}
				mHandler.sendEmptyMessage(1000);
			}
			
		}.start();
	}
	
	
	public Handler mHandler = new Handler(){

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			mReactAdapter.notifyDataSetChanged();
		}
		
	};

//	public void readAsset() {
//		AssetManager am = this.getAssets();
//		String[] path = null;
//		try {
//			// 列出files目录下的文件
//			path = am.list("react");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// 遍历assets目录下，files文件夹下的所有文件，读取这些文件的数据并输出。
//		ReactBean bean;
//		for (int i = 0; i < path.length; i++) {
//			bean = new ReactBean();
//			bean.setModuleName("helloworld");
//			bean.setBundleAssetName( path[i]);
//			bean.setjSMainModuleName(path[i].replace(".bundle", ""));
//			Log.d("", path[i]);
//			list.add(bean);
//		}
//
//	}

	public void reactlist() {
		String path = "http://192.168.1.5:8081/reactmm.json";
		 HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(5000);
	        conn.setRequestMethod("GET");
	        if(conn.getResponseCode() == 200){
	            InputStream json = conn.getInputStream();
	            parseJSON(json);
	        }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseJSON(InputStream jsonStream) {
        byte[] data = convertIsToByteArray(jsonStream);
        String json = new String(data);
        Log.d("", json);
        Gson gson = new Gson();
        ReactJson mReactJson = gson.fromJson(json, ReactJson.class);
        list.clear();
        list.addAll(mReactJson.getList());
	}
	   /**
     * 将输入流转化成ByteArray
     * @param inputStream
     * @return ByteArray
     */
    private byte[] convertIsToByteArray(InputStream inputStream) {
        // TODO Auto-generated method stub     
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte buffer[]=new byte[1024];
        int length=0;
        try {
            while ((length=inputStream.read(buffer))!=-1) {
                baos.write(buffer, 0, length);             
            }
            inputStream.close();
            baos.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
	 
}

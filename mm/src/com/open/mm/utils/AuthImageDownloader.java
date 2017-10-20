/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-10-20下午1:57:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.Uri;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-10-20下午1:57:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class AuthImageDownloader extends BaseImageDownloader {

	public static final String TAG = AuthImageDownloader.class.getName();

	/**
     * {@value}
     */
	public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5 * 1000; // milliseconds
	/**
     * {@value}
     */
	public static final int DEFAULT_HTTP_READ_TIMEOUT = 20 * 1000; // milliseconds

	public AuthImageDownloader(Context context) {
		this(context, DEFAULT_HTTP_CONNECT_TIMEOUT, DEFAULT_HTTP_READ_TIMEOUT);
	}

	public AuthImageDownloader(Context context, int connectTimeout, int readTimeout) {
		super(context, connectTimeout, readTimeout);
	}
	
	/* (non-Javadoc)
	 * @see com.nostra13.universalimageloader.core.download.BaseImageDownloader#createConnection(java.lang.String, java.lang.Object)
	 */
	@Override
	protected HttpURLConnection createConnection(String url, Object extra) throws IOException {
		// TODO Auto-generated method stub
		String encodedUrl = Uri.encode(url, ALLOWED_URI_CHARS);
		HttpURLConnection conn = (HttpURLConnection) new URL(encodedUrl).openConnection();
		conn.setConnectTimeout(connectTimeout);
		conn.setReadTimeout(readTimeout);
		if(encodedUrl.contains("img1.mm131.com")){
    		conn.setRequestProperty("Host", "img1.mm131.com");
    		conn.setRequestProperty("referer", "http://m.mm131.com/");
    		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");  
        }else if(encodedUrl.contains("img2.mm131.com")){
    		conn.setRequestProperty("Host", "img2.mm131.com");
    		conn.setRequestProperty("referer", "http://m.mm131.com/");
    		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");  
        }
		return conn;
	}

 
}
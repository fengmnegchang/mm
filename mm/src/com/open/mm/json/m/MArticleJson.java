/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:22:10
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.mm.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.mm.bean.m.MArticleBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-7下午5:22:10
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MArticleJson extends CommonJson {
	private List<MArticleBean> list;

	public List<MArticleBean> getList() {
		return list;
	}

	public void setList(List<MArticleBean> list) {
		this.list = list;
	}
	
	
}

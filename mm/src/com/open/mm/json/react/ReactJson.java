/** ***************************************************************************************************************************************************************************** *  * @author :fengguangjing * @createTime:2017-6-15上午10:21:48 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: ***************************************************************************************************************************************************************************** */package com.open.mm.json.react;import java.util.List;import com.open.mm.bean.react.ReactBean;/** ***************************************************************************************************************************************************************************** *  * @author :fengguangjing * @createTime:2017-6-15上午10:21:48 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: ***************************************************************************************************************************************************************************** */public class ReactJson {	private List<ReactBean> list;	private String title;	private String description;	public List<ReactBean> getList() {		return list;	}	public void setList(List<ReactBean> list) {		this.list = list;	}	public String getTitle() {		return title;	}	public void setTitle(String title) {		this.title = title;	}	public String getDescription() {		return description;	}	public void setDescription(String description) {		this.description = description;	}}
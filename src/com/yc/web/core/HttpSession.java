package com.yc.web.core;

import java.util.Hashtable;
import java.util.Map;

/**
 * HttpSession
 * @author 张孔洋
 * @data Aug 21, 2020
 */
public class HttpSession {
	public Map<String,Object> session = new  Hashtable<String, Object>();
	private String jsessionid = null;
	
	/**
	 * 往session中存值
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value) {
		this.session.put(key, value);
	}
	
	/**
	 * 从session中根据键获取对应的值
	 * @param key
	 * @return
	 */
	public Object getAttribute(String key) {
		if(!session.containsKey(key)) {
			return null;
		}
		return session.get(key);
	}
	
	/**
	 * 设置jsession的值
	 * @param jsession
	 */
	public void setJSessiodId(String jsession) {
		this.jsessionid = jsession;
	}
	


}

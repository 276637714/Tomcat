package com.yc.web.core;


/**
 * 包装http请求处理
 * @author 张孔洋
 * @data Aug 21, 2020
 */
public interface ServletRequest {
	/**
	 * 获取请求参数的方法
	 * @param key
	 * @return
	 */
	public String getParameter(String key);
	
	/**
	 * 解析请求的方法
	 */
	public void parse();
	
	/**
	 * 获取解析出来的请求地址
	 * @return
	 */
	public String getUrl();
	
	/**
	 * 请求方式
	 * @return
	 */
	public String getMethod();
	
	
	/**
	 * 获取Session
	 * @return
	 */
	public HttpSession  getSession();
	
	/**
	 * 获取Cookie
	 * @return
	 */
	public Cookie[]  gerCookies();
	
	/**
	 * 检查是否获取了JSeesionID
	 * @return
	 */
	public boolean checkJSessionId();
	
	/**
	 * 获取用户JSssionID
	 * @return
	 */
	public String getJSessionId();

}

package com.yc.tomcat.core;

import java.io.InputStream;
import java.util.Properties;

/**
 * 采用单例模式读取配置文件
 * @author 张孔洋
 * @data Aug 21, 2020
 */

public class ReadConfig extends Properties{
	private static final long serialVersionUID = -613052409643698399L;
	
	private static ReadConfig  instance =new ReadConfig();
	
	private ReadConfig() {
		try(InputStream is = this.getClass().getClassLoader().getResourceAsStream("web.properties")){
			load(is);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReadConfig getInstance() {
		return instance;
	}

}

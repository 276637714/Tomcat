package com.yc.tomcat.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

import com.yc.web.core.HttpServletRequest;
import com.yc.web.core.HttpServletResponse;
import com.yc.web.core.Servlet;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

public class ServerService implements Runnable{
	private Socket sk;
	private InputStream is;
	private OutputStream os;
	
	public ServerService(Socket sk) {
		this.sk=sk;
	}
	@Override
	public void run() {
		try {
			this.is =sk.getInputStream();
			this.os =sk.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		ServletRequest request = new HttpServletRequest(is);
		request.parse();
		
		String url = request.getUrl();
		String urlStr = url.substring(1);
		String projectName = urlStr.substring(0,urlStr.indexOf("/"));
		ServletResponse response = new HttpServletResponse("/"+projectName,os);
		
		String clazz = ParseUrlPattern.getClass(url);
		if (clazz==null||"".equals(clazz)) {
			response.sendRedirect(url);
			return;
		}
		URLClassLoader loader =null;
		URL classPath =null;
		try {
			classPath = new URL("file",null,TomcatConstants.BASE_PATH);
			loader = new URLClassLoader(new URL[] {classPath} );
			Class<?> cls = loader.loadClass(clazz);
			Servlet servlet =(Servlet) cls.newInstance();
			servlet.service(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

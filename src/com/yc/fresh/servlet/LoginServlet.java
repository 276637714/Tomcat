package com.yc.fresh.servlet;

import com.yc.web.core.HttpServlet;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	public void doGet(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	@Override
	public void doPost(ServletRequest request, ServletResponse response) {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		response.sendRedirect("index.html");
	}
}

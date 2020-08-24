package com.yc.fresh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.yc.web.core.HttpServlet;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

public class MemberServlet extends HttpServlet{
	@Override
	public void doGet(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	@Override
	public void doPost(ServletRequest request, ServletResponse response) {
		String id  =  request.getParameter("id");
		String name  =  request.getParameter("name");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("name="+name+"id="+id);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (out!=null) {
				out.close();
			}
		}
		
	}
}

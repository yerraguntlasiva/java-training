package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
//@WebServlet("/login")
public class Welcome extends HttpServlet {
	String username=null;
	
	
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("inint");
		this.config=config;//.getServletContext();
		this.config.getServletContext().setAttribute("username", "context_param");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("welcome serverlt called");
		String username=request.getParameter("username");
		if(username==null) {
			username=this.config.getInitParameter("username");
		}
		ServletContext context=config.getServletContext();
		System.out.println("context param : "+context.getAttribute("username12"));
		//Enumeration e2=context.getAttributeNames();
		String password=request.getParameter("password");
		System.out.println("username : "+username+" , and password :"+password);
		
		
	}

}

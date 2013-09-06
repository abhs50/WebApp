package com.analytics.main;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.analytics.db.Database;
import com.analytics.db.DatabaseDao;

public class HeaderServlet extends HttpServlet {
	
	// init: Fetches the classpath parameters (BG jar locations) from web.xml
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}
	/*
	 * Issues calls to respective functions to execute various operations
	 * : It checks the button parameter to decide which function to call
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(" inside do post "+request.getParameter("message"));
		create(request.getParameter("message"));
		

	}
	
	public void create(String message){

		ApplicationContext context = 
	           new ClassPathXmlApplicationContext("Beans.xml");
		DatabaseDao dbTemplate = (DatabaseDao)context.getBean("DatabaseDao");
		dbTemplate.createTransaction(message);
	}

}

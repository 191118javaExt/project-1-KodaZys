package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

public class LoadEmployeeHomeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static Logger log = Logger.getLogger(LoadEmployeeHomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//log.trace("In LoadEmployeeHome Servlet");
		req.getRequestDispatcher("employee-home.html").forward(req, resp);
	}
	
}

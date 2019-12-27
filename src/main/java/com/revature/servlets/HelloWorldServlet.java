package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// servlets are singltons! --> 3 primary methods in lifeclycle
	// 1. init() --> called to instantiate servlet if it is not already instantiated because it's singlton
	// 2. service() --> 
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " IS INSTANTIATED!");
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println(this.getServletName() + " SERVICE METHOD CALLED!");

			/*
			 * In order to create the response, we must write to it.
			 * The way we write to the response is with its own PrintWriter object
			 */
			
			// This will send back an HTML page
			
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			
			out.println("<h1><em>Hello World!</em></h1>");
			
	}
	
	/*
	 * never override service() method
	 * Service() is used for the business logic and to populate the response;
	 */
	
}

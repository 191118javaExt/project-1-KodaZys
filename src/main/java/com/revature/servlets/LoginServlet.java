package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.service.UserService;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class);
	static UserService us = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("index.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Login functionality -- (User and password)
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		log.trace(username);
		log.trace(password);
		
		// Validate -- invoke service method to check that user EXISTS
		User u = us.getUserByLogin(username, password);
		log.trace(u);
		
// ****** IDEA !!! I COULD ADD A POPUP ALERT if the username or password is wrong in JAVASCRIPT ******
		// refresh login page if wrong login info
		if (u == null) {								// this essentially acts as my authentication service 
			req.getRequestDispatcher("index.html").forward(req, res);
		}
		else {
			// otherwise start a session to store user data
			HttpSession session = req.getSession();
			session.setAttribute("user", u);		// create user object in the session - save info to it
			log.trace("USER ADDED TO SESSION: " + session.getId());
			// Employee login logic
			if(u.getUserRoleId() == 1) {
				res.sendRedirect("employee-home");
			}
			// Manager login logic
			else if(u.getUserRoleId() == 2) {
				res.sendRedirect("manager-home");
			}
		}
	}
}
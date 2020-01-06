package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.User;
import com.revature.service.UserService;

@WebServlet("/create-account")
public class CreateAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Logger log = Logger.getLogger(CreateAccountServlet.class);
	UserService us = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//log.trace("In CreateUser Servlet");
		
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		//log.trace(u);
		u = us.create(u);
		//log.trace(u);
		
		String uJson = mapper.writeValueAsString(u);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(uJson);		
	}
	
}

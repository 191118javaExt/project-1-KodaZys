package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbType;
import com.revature.service.ReimbTypeService;
//import com.revature.models.ReimbType;
//import com.revature.service.ReimbTypeService;

/**
 * 
 * Gets reimbursement types to load into submit reimbursement dropdown.
 *
 */
@WebServlet("/r-type")
public class RTypeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static Logger logger = LogManager.getLogger(RTypeServlet.class);
	private static ReimbTypeService typeService = new ReimbTypeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ReimbType> types = new ArrayList<ReimbType>();
		types = typeService.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String typesJson = mapper.writeValueAsString(types);
//		logger.debug(typesJson);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(typesJson);
	}
	

}

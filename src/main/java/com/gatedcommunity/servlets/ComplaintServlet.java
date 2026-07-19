package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.ComplaintDAO;
import com.gatedcommunity.dao.ResidentDAO;
import com.gatedcommunity.model.Complaint;
import com.gatedcommunity.model.Resident;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/complaint")
public class ComplaintServlet extends HttpServlet{

	//private static final Logger log =LoggerFactory.getLogger(ComplaintServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     String username = req.getParameter("username"); 
		 Resident resident = ResidentDAO.findByName(username);
		int userID = resident.getId();
		String category = req.getParameter("category");
		String subject = req.getParameter("subject");
		//log.info("request came to here");
		String complaintDetails = req.getParameter("complaintDetails");
		//log.info("injecting into hibernate");
		Complaint compl = new Complaint(userID,category,subject,complaintDetails,"Pending");
		ComplaintDAO.saveComplaint(compl);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
          requestDispatcher.forward(req, resp);
		
	  
	  
	  
	}
}

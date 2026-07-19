package com.gatedcommunity.servlets;

import java.io.IOException;
import java.util.List;

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
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewcomplaints")
public class ViewComplaintServlet extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession ses = req.getSession(false);
       String username = (String) ses.getAttribute("username");
		 Resident resident = ResidentDAO.findByName(username);
		 int userId = resident.getId();
		
		List<Complaint> complaints = ComplaintDAO.getComplaintsById(userId);
		
		req.setAttribute("compList", complaints);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewcomplaints.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	}
		


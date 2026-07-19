package com.gatedcommunity.servlets;

import java.io.IOException;
import java.util.List;

import com.gatedcommunity.dao.AdminDAO;
import com.gatedcommunity.model.Complaint;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewallcomplaints")
public class ViewAllComplaintsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Complaint> viewAllComplaints = AdminDAO.viewAllComplaints();
	      req.setAttribute("allcomplaints", viewAllComplaints);
	      
	      RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewallcomplaints.jsp");
	      requestDispatcher.forward(req, resp);
	}
	
	
}

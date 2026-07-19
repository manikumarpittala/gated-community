package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdrawcomplaint")
public class WithdrawComplaintServlet extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int compId =Integer.parseInt(req.getParameter("id"));
		   ComplaintDAO.deleteComplaint(compId);
		 resp.sendRedirect("viewcomplaints");
		
		
	}
}

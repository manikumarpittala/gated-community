package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.ComplaintDAO;
import com.gatedcommunity.model.Complaint;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatecomplaint")
public class UpdateComplaintServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Complaint complaintById = ComplaintDAO.findComplaintById(id);
        req.setAttribute("complaint", complaintById);
        RequestDispatcher rd = req.getRequestDispatcher("updatecomplaint.jsp");
        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int compId = Integer.parseInt(req.getParameter("complaintId"));
         String category = req.getParameter("category");
	     String subject = req.getParameter("subject");
	     String description = req.getParameter("description");
	     Complaint comp = new Complaint(compId,category,subject,description);
	     ComplaintDAO.updateComplaint(comp);
	     resp.sendRedirect("viewcomplaints");
	}
	
	
}

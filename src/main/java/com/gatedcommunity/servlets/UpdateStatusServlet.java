package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.AdminDAO;
import com.gatedcommunity.model.Complaint;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatestatus")
public class UpdateStatusServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Complaint complaintById = AdminDAO.findComplaintById(id);
        req.setAttribute("complaint", complaintById);
        RequestDispatcher rd = req.getRequestDispatcher("updatestatus.jsp");
        rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stringId = req.getParameter("complaintId");
		  int compId = Integer.parseInt(stringId);
	     String status = req.getParameter("status");
	     Complaint comp = new Complaint(compId,status);
	     AdminDAO.updateStatus(comp);
	    resp.sendRedirect("updatecomplaintstatus");
	 
	}
}

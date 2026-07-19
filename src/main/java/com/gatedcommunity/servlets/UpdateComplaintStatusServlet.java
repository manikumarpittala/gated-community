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

@WebServlet("/updatecomplaintstatus")
public class UpdateComplaintStatusServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Complaint> viewAllComplaints = AdminDAO.viewAllComplaints();
       req.setAttribute("complaints", viewAllComplaints);
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("updatecomplaintstatus.jsp");
         requestDispatcher.forward(req, resp);
	}
	
}

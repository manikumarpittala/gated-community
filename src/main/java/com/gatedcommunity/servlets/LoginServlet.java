package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.AdminDAO;
import com.gatedcommunity.dao.ResidentDAO;
import com.gatedcommunity.model.Resident;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	
   
	Resident rs = new Resident(username,password);
	HttpSession session = req.getSession();
	if(ResidentDAO.validateResident(rs)==true) {
		   Resident resident = ResidentDAO.findByName(username);
		    String fullName = resident.getFullName();
		    String email = resident.getEmail();
		    int userId = resident.getId();
	 session.setAttribute("username",username);
	 session.setAttribute("fullName", fullName);
	 session.setAttribute("email", email);
	 session.setAttribute("userId", userId);
	 
	 
	 RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
	   requestDispatcher.forward(req, resp);
	
	   
	}
	   else {
		   if(AdminDAO.validAdmin(username) == true){
			   RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin.jsp");
			   requestDispatcher.forward(req, resp);   
	   }
		   
	   }
	   
	   
	 if(ResidentDAO.validateResident(rs)==false && AdminDAO.validAdmin(username)==false){
		 RequestDispatcher requestDispatcher = req.getRequestDispatcher("incorrectlogin.jsp");
		   requestDispatcher.forward(req, resp);
	}
	
	}
	
}

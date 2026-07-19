package com.gatedcommunity.servlets;

import java.io.IOException;

import com.gatedcommunity.dao.ResidentDAO;
import com.gatedcommunity.model.Resident;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
         @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	 String email = req.getParameter("email");
        	 String username = req.getParameter("username");
        	 String password = req.getParameter("password");
        	 String fullName = req.getParameter("fullname");
        	 Resident rs = new Resident(username,password,email,fullName,"Resident");
        	 
        	 ResidentDAO.saveResident(rs);
        	 
        	 RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
      	   requestDispatcher.forward(req, resp);
         }
}

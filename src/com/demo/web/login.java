package com.demo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.impl.UserDaoImpl;
import com.demo.domain.UserCredentials;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = null ;
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String databasePassword;
		
		if(userName != null  && password != null) {
			
				UserCredentials uc = new UserCredentials(userName);
				UserDaoImpl ud= new UserDaoImpl();
				
				try {				
						ud.sqlSelectPassword(uc);
				}catch (SQLException e) {
						e.printStackTrace();
				}
				databasePassword=uc.getResult();
	
				
				if(password.equals(databasePassword) ) {		
							HttpSession  session = request.getSession();
							session.setAttribute("user_name", userName );
							response.sendRedirect("home");
				
				}else {
							error = "UserName or Password incorrect";
				}
		}else {
				error = "invalid UserName or Password";
		}
		
		if(error != null) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
			
			
		
		
	
		
	}

}

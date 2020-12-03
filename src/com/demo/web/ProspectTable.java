package com.demo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.impl.ProspectDaoImpl;

@WebServlet("/ProspectTable")
public class ProspectTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {				
		try {
			request.setAttribute("prospectRecSet", new ProspectDaoImpl().selectAllProspects() );
			request.getRequestDispatcher("/prospectTable.jsp").forward(request, response);
			//response.sendRedirect("ProspectTable");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//request.getRequestDispatcher("/prospectTable.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}

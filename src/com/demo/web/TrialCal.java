package com.demo.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.impl.ProspectDaoImpl;
import com.demo.domain.Prospect;

@WebServlet("/trialCal")
public class TrialCal extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/*String error = null ;
		if(req.getParameter("loanAmt") != null) {
			if(req.getParameter("repayPeriod") != null) {
				if(req.getParameter("interestRate") != null) {
						double loanAmt=Double.parseDouble(req.getParameter("loanAmt"));
						int repayPeriod = Integer.parseInt(req.getParameter("repayPeriod"));
						double interestRate=Double.parseDouble(req.getParameter("interestRate"));
						
						//double instalmentVal =Calculation.calInstalmentVal( loanAmt, interestRate, repayPeriod); 					
						
				}else {
						error="Enter value for Interest Rate";
				}
			}else {
				error="Enter value for Repayment Period";
			}
		}else {
			error="Enter value for Loan Amount ";
		}
			
		if(error != null) {
			req.setAttribute("error", error);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}*/
		
		//************************************************
		
		if(req.getParameter("viewbutton") != null) {
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
		String nic=req.getParameter("nic");
		double loanAmt=Double.parseDouble(req.getParameter("loanAmt"));
		int repayPeriod = Integer.parseInt(req.getParameter("repayPeriod"));
		double interestRate=Double.parseDouble(req.getParameter("interestRate"));
		double installmentValue=Double.parseDouble(req.getParameter("installmentValue"));
		
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));*/
		
				
		Prospect p1=new Prospect(fname, lname, nic, loanAmt, repayPeriod, interestRate, installmentValue, new Date());
		ProspectDaoImpl pd1=new ProspectDaoImpl();
		try {
			pd1.insertProspect(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		//******************************
		
		//PrintWriter out = resp.getWriter();
		if(req.getParameter("viewprospectbutton") != null) {
				
			//Prospect p1=new Prospect();
			//p1.setfName("abi");
			//ProspectDaoImpl pd1=new ProspectDaoImpl();
			
			//ProspectTable pt=new ProspectTable();
			//pt.doGet(req, resp);
			//HttpSession  session = req.getSession();
			resp.sendRedirect("ProspectTable");
			//resp.sendRedirect("ProspectTable");
			//ArrayList<Prospect> prospect = new ArrayList<Prospect>();
			
			//try {
				// prospect = pd1.selectAllProspects();
				
				//for(int i=0; i<prospect.size(); i++) {
					/*System.out.println(prospect.get(i).getId());
					System.out.println(prospect.get(i).getfName());
					System.out.println(prospect.get(i).getlName());
					System.out.println(prospect.get(i).getNic());
					System.out.println(prospect.get(i).getLoanAmt());
					System.out.println(prospect.get(i).getRepayPeriod());
					System.out.println(prospect.get(i).getInterestRate());
					System.out.println(prospect.get(i).getInstallmentVal());
					System.out.println(prospect.get(i).getDate());*/
					
				/*	out.println(prospect.get(i).getId());
					out.println(prospect.get(i).getfName());
					out.println(prospect.get(i).getlName());
					out.println(prospect.get(i).getNic());
					out.println(prospect.get(i).getLoanAmt());
					out.println(prospect.get(i).getRepayPeriod());
					out.println(prospect.get(i).getInterestRate());
					out.println(prospect.get(i).getInstallmentVal());
					out.println(prospect.get(i).getDate());*/
					
					
					/*DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
			        tableModel.setRowCount(0);
			        for (Customer customer : customerList) {
			            Object rowData[] = {customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()};
			            tableModel.addRow(rowData);*/
			        }

					
				/*	
				}*/
			
			/*}catch (SQLException e) {
				e.printStackTrace();
			}*/
			
			
			
			//p1.getResult();
			
			//ResultSet r=p1.getResult();
			//int count=r.getRow();
			
			/*try {
				while (r.next()) {
					out.println(r.getInt(1)+"	"+r.getString(2)+"	"+r.getString(3)+"	"+r.getString(4)+"	"+r.getDouble(5)+"	"+r.getInt(6)+"	"+r.getDouble(7)+"	"+r.getDouble(8)+"  "+r.getDate(9)	);
				//System.out.println(passwordFromDatabase);
				}*/
				
		/*	} catch (SQLException e) {
				e.printStackTrace();
			}*/
			
		//}
		
		//******************************************
	}

}



































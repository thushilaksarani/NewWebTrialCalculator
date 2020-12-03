package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.ProspectDaoInterface;
import com.demo.connection.JDBCconnection;
import com.demo.domain.Prospect;

// import domain.Person;

public class ProspectDaoImpl implements ProspectDaoInterface {

	private final String insertSql = "INSERT INTO prospect(fName, lName, nic, loanAmt, repayPeriod, InterestRate, installmentVal, date) VALUES(?,?,?,?,?,?,?,?)";
	//private final String selectSql = "SELECT lNeam FROM prospect WHERE fName=?";
	private final String selectSql = "SELECT * FROM prospect ";
	
	Connection con;
	PreparedStatement ps;
	
	@Override
	public void insertProspect(Prospect p) throws SQLException {
		 
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(insertSql);
			ps.setString(1,p.getfName());
			ps.setString(2,p.getlName());
			ps.setString(3,p.getNic());
			ps.setDouble(4,p.getLoanAmt());
			ps.setInt(5,p.getRepayPeriod());
			ps.setDouble(6,p.getInterestRate());
			ps.setDouble(7,p.getInstallmentVal());
			ps.setDate(8, new java.sql.Date(p.getDate().getTime()));
			
			ps.execute();
		 	
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}	 
	
	public ArrayList<Prospect> selectAllProspects() throws SQLException {	
	//public ResultSet selectAllProspects() throws SQLException {	
		ResultSet r=null;
		ArrayList<Prospect> prospectRecSet = new ArrayList<Prospect>();	
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return prospectRecSet;
						//return;
				}
			//con.setAutoCommit(false);
			ps=con.prepareStatement(selectSql);
			r =ps.executeQuery();
			System.out.println("retrivePerson => "+ ps.toString());
			try {
				while (r.next()) {
					Prospect pro=new Prospect();
					pro.setId(r.getInt(1));
					pro.setfName(r.getString(2));
					pro.setlName(r.getString(3));
					pro.setNic(r.getString(4));
					pro.setLoanAmt(r.getDouble(5));
					pro.setRepayPeriod(r.getInt(6));
					pro.setInterestRate(r.getDouble(7));
					pro.setInstallmentVal(r.getDouble(8));
					pro.setDate(r.getDate(9));
					prospectRecSet.add(pro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//p.setResult(r);
			//PrintOutput.printSeletPersonDetails(r);
			
			//con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeResulrSet(r);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		 
		 return prospectRecSet;
			
		}
}

package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.connection.JDBCconnection;
import com.demo.domain.UserCredentials;


public class UserDaoImpl {
	private final String selectSql = "SELECT password FROM user WHERE uName=? ";
	Connection con;
	PreparedStatement ps;
	
	public void sqlSelectPassword(UserCredentials uc) throws SQLException {	
		 ResultSet r=null;
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(selectSql);
			ps.setString(1,uc.getUserName());
			r =ps.executeQuery();
			uc.setResult(r);
			//PrintOutput.printSeletPersonDetails(r);
			
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
					JDBCconnection.closeResulrSet(r);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
			
		}
}

package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCconnection {

	private static Connection con;
	private static final String driverName ="com.mysql.cj.jdbc.Driver" ; 
	private static final String url = "jdbc:mysql://127.0.0.1:3306/trialcal";
	private static final String userName = "root";
	private static final String password = "root";
	
	static {
        try {
            Class.forName(driverName);             
        } catch (ClassNotFoundException e) {
        	System.out.println("Driver class not found" );
        	e.printStackTrace();
        } 
	}
	
	public static Connection getMyConnection() throws SQLException{   
        con=DriverManager.getConnection(url,userName,password);
        return con;
	}
    
    public static void closeConnection(Connection con)throws SQLException{
		if(con != null) {
			con.close();
		}
	}
    
    public static void closePreparedStatement(PreparedStatement stmt)throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
	}
    
    public static void closeResulrSet(ResultSet rs)throws SQLException{
		if(rs != null) {
			rs.close();
		}
	}
    
	
}

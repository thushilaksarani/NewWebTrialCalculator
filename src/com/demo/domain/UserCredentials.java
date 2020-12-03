package com.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCredentials {
	 String  userId ;
	 String userName ;
	 String 	password ;
	 String passwordFromDatabase;
	
	public UserCredentials() {
	}
	
	public UserCredentials(String userName, String password) {	
		this.userName = userName;
		this.password = password;
	}
	
	public UserCredentials(String userName) {
		this.userName = userName;
	}
	
	public void setResult(ResultSet r) {
		try {
			while (r.next()) {
			this.passwordFromDatabase=r.getString(1);
			//System.out.println(passwordFromDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getResult() {
		return passwordFromDatabase;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}

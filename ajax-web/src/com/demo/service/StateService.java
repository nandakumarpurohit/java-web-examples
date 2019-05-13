package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StateService {
	
	Connection con;
	Statement st;
	
	public StateService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subaru?serverTimezone=UTC", "root", "password");
			if(con != null) {
				st = con.createStatement();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<String> fetchAllStates() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			if(con != null) {
				ResultSet rs = st.executeQuery("select name from states");
				while(rs.next()) {
					list.add(rs.getString(1));
				}
				return list;
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

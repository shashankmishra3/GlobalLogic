package com.global.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
public static Connection getConnection() {
	
	Connection connection = null;
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/milestone", "root", "root");
			
//			System.out.println("Query executed");
		}
		
		catch (Exception e) {
			System.out.println("inside getConnection catch");
			e.printStackTrace();
		}
		return connection;	
	}

}
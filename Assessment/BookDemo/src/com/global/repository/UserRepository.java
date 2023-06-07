package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.global.db.DBConnection;
import com.global.to.UserTO;

public class UserRepository {
	
	
	Connection connection  = DBConnection.getConnection();
	

	
	
public void register(UserTO user) {
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?, ?,?)");

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.executeUpdate();
			System.out.println("Query executed");
		}
		catch (Exception e) {
			System.out.println("inside regsiter of UserRepository");
			e.printStackTrace();
		}

		
	}
	
	
	public int login(String userName, String password) {
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("select * from user where username = ? and password=?");

			statement.setString(1, userName);
			statement.setString(2, password);
			
			ResultSet resultset =  statement.executeQuery();
			
			if(resultset.next() == true) {
				return 1;
			}
			
		}
		catch(Exception e) {
			
			System.out.println("inside catch of Login of UserRepo");
		}
		
		return 0;
	}

}
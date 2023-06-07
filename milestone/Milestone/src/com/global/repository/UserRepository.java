package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.global.db.DBConnection;
import com.global.to.UserTO;


public class UserRepository {


	Connection connection = DBConnection.getConnection();

	public boolean register(UserTO user) {
	
	try {
			
			PreparedStatement statement = connection.prepareStatement("insert into userin values(?, ?, ?, ? ,?,?)");

			
			statement.setInt(1, user.getId());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getRole());
			statement.setString(6,user.getStatus());
			

			statement.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("inside regsiter of UserRepository");
			return false;
		}
		
	}

	public boolean login(int id,String password,String role) {
		
		
try {
			
			PreparedStatement statement = connection.prepareStatement("select * from user where id = ? and (password = ? and role = ?)");

			statement.setInt(1, id);
			statement.setString(2,password);
			statement.setString(3,role);
			
			ResultSet resultset =  statement.executeQuery();
			
			if(resultset.next() == true) {
			
				if(role.equals("user")) {
					if(resultset.getString(6).equals("unblock")){
						return true;
					}
				}else {
					return true;
				}
			}
			
		}
		catch(Exception e) {
			
			System.out.println("inside catch of Login of UserRepo");
		}
		
		return false;
		
	}
	
	
	public void updateStatus(int uid) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement statement = connection
					.prepareStatement("update user set status = ? where id = ?");
			statement.setString(1, "block");
			statement.setInt(2, uid);

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

	}

}

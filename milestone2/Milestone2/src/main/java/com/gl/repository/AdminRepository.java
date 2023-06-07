package com.gl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gl.db.DBConnection;
import com.gl.to.Admin;
//import com.gl.to.User;

public class AdminRepository {

	Connection conn = DBConnection.getConnection();

	public void addAdmin(Admin admin) {

		try {

			

			PreparedStatement statement = conn.prepareStatement("insert into admin values(?, ?, ?, ?)");
//			name, password, adminID,  role
			statement.setString(1, admin.getName());
			statement.setString(2, admin.getPassword());
			statement.setString(3, admin.getAdminID());
			statement.setString(4, admin.getRole());
		

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of addAdmin() of AdminRepository");
			e.printStackTrace();
		}
	}

	public Admin findAdmin(String name, String password) {
		Admin admin = null;

		try {

			PreparedStatement statement = conn
					.prepareStatement("select * from admin where name = ? and password = ?");

			statement.setString(1, name);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
//				name, password, adminID(int),  role(int)
				String adminID = resultSet.getString(3);
				
				String role = resultSet.getString(4);
				
				admin = new Admin(name, password, adminID, role);
			}
		} catch (Exception e) {
			System.out.println("inside catch of findAdmin() of AdminRepository");
			e.printStackTrace();
		}
		
		return admin;
	}
	
public List<Admin> findAllAdmin() {
		
		List<Admin> admins = new ArrayList<Admin>();
		
		try {
			
			PreparedStatement statement =  conn.prepareStatement("select * from admin");
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
//				name, password, adminID(int),  role(int)
				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				
				String adminID = resultSet.getString(3);
				String role = resultSet.getString(4);
					
				Admin admin = new Admin(name, password, adminID, role);
				admins.add(admin);
				
			}
			
		}
		catch (Exception e) {
			System.out.println("inside catch of findAllAdmin of AdminRepository");
			e.printStackTrace();
		}
		
		return admins;
	}
}

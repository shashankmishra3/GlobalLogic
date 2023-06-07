package com.gl.to;

public class Admin {

//	Name, adminID, password, role
	private String name;
	private String adminID;
	private String password;
	private String role;
	
	public Admin() {
		
	}
	
	public Admin(String name, String password, String adminID,  String role) {
		this.name=name;
		this.adminID=adminID;
		this.password=password;
		this.role=role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

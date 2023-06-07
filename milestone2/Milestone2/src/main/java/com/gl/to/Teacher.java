package com.gl.to;

public class Teacher {

	private String name;
	private String teacherID;
	private String password;
	private String subject;
	private String role;
	private String status;
	
	public Teacher() {
		
	}
	
	public Teacher(String name, String password, String teacherID, String subject, String role, String status) {
		this.name=name;
		this.teacherID=teacherID;
		this.password=password;
		this.subject=subject;
		this.role=role;
		this.status=status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

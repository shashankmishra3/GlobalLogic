package com.gl.to;

public class Student {

	private String name;
	private String password;
	private String className;
	private String section;
	private String studentRollNo;
	private String role;
	private String status;
//	Name, studentRollNo, password, className, Section,
	
	public Student() {
		
	}
	public Student(String name, String password, String className, String section, String studentRollNo, String role, String status) {
		this.name=name;
		this.password=password;
		this.className=className;
		this.section=section;
		this.studentRollNo=studentRollNo;
		this.role=role;
		this.status=status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
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

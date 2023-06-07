package com.gl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gl.db.DBConnection;
import com.gl.to.Student;
import com.gl.to.Teacher;


public class TeacherRepository {

	Connection conn = DBConnection.getConnection();

	public void addTeacher(Teacher teacher) {

		try {

			PreparedStatement statement = conn.prepareStatement("insert into teacher values(?, ?, ?, ?, ?, ?)");
//			name, password,  teacherID, subject, role, status
			statement.setString(1, teacher.getName());
			statement.setString(2, teacher.getPassword());
			statement.setString(3, teacher.getTeacherID());
			statement.setString(4, teacher.getSubject());
			statement.setString(5, teacher.getRole());
			statement.setString(6, teacher.getStatus());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of addTeacher() of TeacherRepository");
			e.printStackTrace();
		}
	}

	public Teacher findTeacher(String name, String password) {
		Teacher teacher = null;

		try {

			PreparedStatement statement = conn
					.prepareStatement("select * from teacher where name = ? and password = ?");

			statement.setString(1, name);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
//				name, password,  teacherID, subject, role, status
				String teacherID = resultSet.getString(3);
				String subject = resultSet.getString(4);
				String role = resultSet.getString(5);
				String status=resultSet.getString(6);
				
				if(status.equalsIgnoreCase("unblock")) {
					teacher = new Teacher(name, password, teacherID, subject, role, status);
				}

				
			}
		} catch (Exception e) {
			System.out.println("inside catch of addTeacher() of TeacherRepository");
			e.printStackTrace();
		}

		return teacher;
	}

	public List<Teacher> findAllTeacher() {

		List<Teacher> teachers = new ArrayList<Teacher>();

		try {

			PreparedStatement statement = conn.prepareStatement("select * from teacher");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
//				name, password,  teacherID, subject, role
				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				String teacherID = resultSet.getString(3);
				String subject = resultSet.getString(4);
				String role = resultSet.getString(5);
				String status=resultSet.getString(6);

				Teacher teacher = new Teacher(name, password, teacherID, subject, role, status);
				teachers.add(teacher);

			}

		} catch (Exception e) {
			System.out.println("inside catch of findAllTeacher of TeacherRepository");
			e.printStackTrace();
		}

		return teachers;
	}

	public void rmvTeacher(String name) {

		try {

			PreparedStatement statement = conn.prepareStatement("delete from teacher where name = ?");

			statement.setString(1, name);

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of rmvTeacher");
		}

	}
	
	public void updationByAdmin(Teacher teacher) {
		
		try {
			
//			name, password,  teacherID, subject, role, status
//			System.out.println("update "+user.getCompleteName()+" "+user.getEmail()+", "+user.getUsername());
			PreparedStatement statement = conn.prepareStatement("update teacher set password = ?, teacherID = ?, "
					+ "subject=?, status=? where name = ?");
			statement.setString(1, teacher.getPassword());
			statement.setString(2, teacher.getTeacherID());
			statement.setString(3, teacher.getSubject());
			statement.setString(4, teacher.getStatus());
			statement.setString(5, teacher.getName());
			
			statement.executeUpdate();
		}
		
		catch (Exception e) {
			System.out.println("inside catch of updateByAdmin of StudentRepo");
			e.printStackTrace();
		}
		
		
	}
	
public void updationBySelf(Teacher teacher) {
		
		try {
			
//			name, password,  teacherID, subject, role, status
//			System.out.println("update "+user.getCompleteName()+" "+user.getEmail()+", "+user.getUsername());
			PreparedStatement statement = conn.prepareStatement("update teacher set password = ?, teacherID = ?, "
					+ "subject=? where name = ?");
			statement.setString(1, teacher.getPassword());
			statement.setString(2, teacher.getTeacherID());
			statement.setString(3, teacher.getSubject());
			statement.setString(4, teacher.getName());
			
			statement.executeUpdate();
		}
		
		catch (Exception e) {
			System.out.println("inside catch of updateByAdmin of StudentRepo");
			e.printStackTrace();
		}
		
		
	}
}

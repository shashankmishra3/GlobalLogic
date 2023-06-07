package com.gl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gl.db.DBConnection;
import com.gl.to.Student;


public class StudentRepository {

	Connection conn = DBConnection.getConnection();

	public void addStudent(Student student) {

		try {

//			name, password,  className, section, studentRollNo,  role, status
			PreparedStatement statement = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?)");

			statement.setString(1, student.getName());
			statement.setString(2, student.getPassword());
			statement.setString(3, student.getClassName());
			statement.setString(4, student.getSection());
			statement.setString(5, student.getStudentRollNo());
			statement.setString(6, student.getRole());
			statement.setString(7, student.getStatus());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of addStudent() of StudentRepository");
			e.printStackTrace();
		}
	}

	public Student findStudent(String name, String password) {
		Student student = null;

		try {

			PreparedStatement statement = conn
					.prepareStatement("select * from student where name = ? and password = ?");

			statement.setString(1, name);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String className = resultSet.getString(3);
				String section = resultSet.getString(4);
				String studentRollNo = resultSet.getString(5);
				String role = resultSet.getString(6);
				String status=resultSet.getString(7);
				
				if(status.equalsIgnoreCase("unblock")) {
					student = new Student(name, password, className, section, studentRollNo, role, status);
				}
				
			}
		} catch (Exception e) {
			System.out.println("inside catch of findStudent() of StudentRepository");
			e.printStackTrace();
		}

		return student;
	}

	
	//To find all the Students present
	public List<Student> findAllStudents() {

		List<Student> students = new ArrayList<Student>();

		try {

			PreparedStatement statement = conn.prepareStatement("select * from student");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				String className = resultSet.getString(3);
				String section = resultSet.getString(4);
				String studentRollNo = resultSet.getString(5);
				String role = resultSet.getString(6);
				String status=resultSet.getString(7);

				Student student = new Student(name, password, className, section, studentRollNo, role,status);
				students.add(student);

			}

		} catch (Exception e) {
			System.out.println("inside catch of findAllStudents of StudentRepository");
			e.printStackTrace();
		}

		return students;
	}
	
	
	//To delete the students data
	public void rmvStudent(String name) {

		try {

			PreparedStatement statement = conn.prepareStatement("delete from student where name = ?");

			statement.setString(1, name);

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of rmvStudent of repo");
		}

	}
	
	
public void updationBySelf(Student student) {
		
		try {
			
//			name, password,  className, section, studentRollNo,  role, status
//			System.out.println("update "+user.getCompleteName()+" "+user.getEmail()+", "+user.getUsername());
			PreparedStatement statement = conn.prepareStatement("update student set password = ?, className = ?, "
					+ "section=?, studentRollNo=? where name = ?");
			statement.setString(1, student.getPassword());
			statement.setString(2, student.getClassName());
			statement.setString(3, student.getSection());
			statement.setString(4, student.getStudentRollNo());
			statement.setString(5, student.getName());
			
			statement.executeUpdate();
		}
		
		catch (Exception e) {
			System.out.println("inside catch of updateBySelf of StudentRepo");
			e.printStackTrace();
		}
		
		
	}


public void updationByAdmin(Student student) {
	
	try {
		
//		name, password,  className, section, studentRollNo,  role, status
//		System.out.println("update "+user.getCompleteName()+" "+user.getEmail()+", "+user.getUsername());
		PreparedStatement statement = conn.prepareStatement("update student set password = ?, className = ?, "
				+ "section=?, studentRollNo=?, status=? where name = ?");
		statement.setString(1, student.getPassword());
		statement.setString(2, student.getClassName());
		statement.setString(3, student.getSection());
		statement.setString(4, student.getStudentRollNo());
		statement.setString(5, student.getName());
		statement.setString(6, student.getStatus());
		
		statement.executeUpdate();
	}
	
	catch (Exception e) {
		System.out.println("inside catch of updateByAdmin of StudentRepo");
		e.printStackTrace();
	}
	
	
}
}

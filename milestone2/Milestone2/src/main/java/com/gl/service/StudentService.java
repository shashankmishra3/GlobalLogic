package com.gl.service;

import java.util.List;

import com.gl.repository.StudentRepository;
import com.gl.to.Student;


public class StudentService {

StudentRepository repository = new StudentRepository();
	
	public void register(Student student) {
		
		
		
		repository.addStudent(student);
	}
	
	public Student login(String username, String password) {
		
		return repository.findStudent(username, password);
	}
	
	
	public List<Student> getAllStudents() {
		
		return repository.findAllStudents();
	}
	
	public void removeStudent(String name) {
		// TODO Auto-generated method stub

		repository.rmvStudent(name);

	}
	
	public void updateBySelf(Student student) {
		repository.updationBySelf(student);
	}
	
	public void updateByAdmin(Student student) {
		repository.updationByAdmin(student);
	}
}

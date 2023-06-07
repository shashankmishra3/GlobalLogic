package com.gl.service;

import java.util.List;

import com.gl.repository.TeacherRepository;
//import com.gl.repository.UserRepository;
import com.gl.to.Teacher;
//import com.gl.to.User;

public class TeacherService {

TeacherRepository repository = new TeacherRepository();
	
	public void register(Teacher teacher) {
		
		
		
		repository.addTeacher(teacher);
	}
	
	public Teacher login(String name, String password) {
		
		return repository.findTeacher(name, password);
	}
	
	public List<Teacher> getAllTeachers() {
		
		return repository.findAllTeacher();
	}
	
	public void removeTeacher(String name) {
		// TODO Auto-generated method stub


		repository.rmvTeacher(name);

	}
	
	public void updateBySelf(Teacher teacher) {
		repository.updationBySelf(teacher);
	}
	
	public void updateByAdmin(Teacher teacher) {
		repository.updationByAdmin(teacher);
	}
}

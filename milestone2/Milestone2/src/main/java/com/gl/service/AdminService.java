package com.gl.service;

import java.util.List;

import com.gl.repository.AdminRepository;

import com.gl.to.Admin;


public class AdminService {

AdminRepository repository = new AdminRepository();
	
	public void register(Admin admin) {
		
		
		
		repository.addAdmin(admin);
	}
	
	public Admin login(String name, String password) {
		
		return repository.findAdmin(name, password);
	}
	
	public List<Admin> getAllAdmin() {
		
		return repository.findAllAdmin();
	}
}

package com.global.service;

import java.util.Scanner;

import com.global.repository.UserRepository;
import com.global.to.UserTO;

public class UserService {
	UserRepository repository = new UserRepository();

	Scanner sc = new Scanner(System.in);

	public boolean register() {

		System.out.println("Enter your UserID!!");
		int id = sc.nextInt();

		System.out.println("Enter your password");
		String password = sc.next();

		System.out.println("Enter your firstname");
		String firstName = sc.next();

		System.out.println("Enter your lasttname");
		String lastName = sc.next();

		System.out.println("Enter your Role : Input  Admin : for registering as a 'admin' \n"
				+ "\t \t Input User : for registering as a 'user' ");
		String role = sc.next();

		UserTO user = new UserTO(id, password, firstName, lastName, role, "unblock");

		if (repository.register(user)) {
			return true;
		} else {
			return false;
		}

	}

	// Login User
	public boolean loginuser() {
		System.out.println("Enter your userID");
		int id = sc.nextInt();
		System.out.println("Enter your password");
		String password = sc.next();

		return repository.login(id, password, "user");

	}

//login Admin
	public boolean loginadmin() {

		System.out.println("Enter your AdminID");
		int id = sc.nextInt();
		System.out.println("Enter your password");
		String password = sc.next();

		return repository.login(id, password, "admin");
	}

	public void block(int uid) {
		repository.updateStatus(uid);
	}

}

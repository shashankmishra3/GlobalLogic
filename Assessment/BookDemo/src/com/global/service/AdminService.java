
package com.global.service;

//import java.util.List;
import java.util.Scanner;

import com.global.repository.AdminRepository;
//import com.global.repository.UserRepository;
//import com.global.to.UserTO;
import com.global.to.AdminTO;
//import com.global.service.BookService;
//import com.global.to.BookTO;

public class AdminService {

	AdminRepository repository=new AdminRepository();
	BookService bookService = new BookService();

	Scanner sc = new Scanner(System.in);


	public void register() {

		System.out.println("Enter your UserName");
		String userName = sc.next();

		System.out.println("Enter your Password");
		String password = sc.next();

		System.out.println("Enter the First Name");
		String firstName = sc.next();

		System.out.println("Enter the Last Name");
		String lastName = sc.next();

		AdminTO admin = new AdminTO(userName, password, firstName, lastName);
		repository.register(admin);

		System.out.println("Successfully Registered");
		System.out.println("To Login Press 1 or To Exit Press 0");
		int choice1 = sc.nextInt();

		switch (choice1) {
		case 1:
			login();
			break;
		case 2:
			System.out.println("Logged-out Successfully...");
			break;
		}
	}

	public void login() {

		System.out.println("Enter your UserName");
		String userName = sc.next();

		System.out.println("Enter your Password");
		String password = sc.next();

		if (repository.login(userName, password) == 1) {
			System.out.println("Welcome to Global Logic Book Store...");

			int userMenuChoice = userMenu();

			} else {

			System.out.println("Wrong Credentials...");
		}

	}

	public int userMenu() {
		System.out.println("Enter 1 to List all Books and 2 to Search a Book and 3 to Insert a Book"
				+ "and 4 to Update a Book and 5 to Remove a Book and 6 to find total count of Books and"
				+ "7 to arrange the books");
		int userChoice = sc.nextInt();
		return userChoice;
	}

	
}
package com.global;

//import java.util.List;
import java.util.Scanner;

//import com.global.service.BookService;
import com.global.service.UserService;
import com.global.service.AdminService;

//import com.global.service.BookService;

//import com.global.to.BookTO;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		UserService userService = new UserService();

		AdminService adminService=new AdminService();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 for Admin and 2 for User and 0 for exit");
		
		int mainMenuChoice = sc.nextInt();
		
		System.out.println("Press 1 for Registration and 2 for login");
		
		
		switch (mainMenuChoice) {

		case 1:
			
			int adminChoice=sc.nextInt();
			if(adminChoice==1) {
				adminService.register();
			}else {
				adminService.login();
			}
			
			break;

		case 2:

			int userChoice=sc.nextInt();
			if(userChoice==1) {
				userService.register();
			}else {
				userService.login();
			}
			
			break;
			
		case 0:
			System.out.println("Logged-out Successfully...");
		}

	}
	
	

}
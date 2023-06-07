package com.global;


public class Menu {
	public static void menu() {
		System.out.println("Select options to Perform The task");
		System.out.println("Enter 1 to register");
		System.out.println("Enter 2 to Login as User"); 
		System.out.println("Enter 3 to Login as Admin");  
		System.out.println("Enter 0 to Log Out");
	}
	


	public static void subMenuUser() {
		System.out.println("Welcome User: Select option to perform the task");
		System.out.println("Enter 1 for list all Products");
		System.out.println("Enter 2 to Place order");
		System.out.println("Enter 3 to Print Order History");
		System.out.println("Enter 4 to Show the products lowest to highest price");
		System.out.println("Enter 5 to Show the products highest to lowest price");
		
		
	}
	

	
	public static void subMenuAdmin() {
		System.out.println("Welcome Admin: Select option to perform the task");
		System.out.println("Enter 1 To insert a product");
		System.out.println("Enter 2 To delete a product");
		System.out.println("Enter 3 To update a product");
		System.out.println("Enter 4 To Show all the orders");
		System.out.println("Enter 5 to Search Product by id");
		System.out.println("Enter 6 To Block customer");
		
		
	}
	
	
}

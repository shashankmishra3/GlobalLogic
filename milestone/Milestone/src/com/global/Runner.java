package com.global;

import java.util.List;
import java.util.Scanner;

import com.global.service.OrderService;
import com.global.service.ProductService;
import com.global.service.UserService;
import com.global.to.ProductTO;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		UserService service = new UserService();
		ProductService proservice=new ProductService();
		OrderService oservice=new OrderService();
		System.out.println("Welcome to the Console Application");
		String s = "";
		
		do {

			Menu.menu();
			System.out.println("Enter your Choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				// register
				
				if(service.register()){
					System.out.println("you register succesfully");
				}
				
				
				break;
			}
			
			case 2: {
				// login as user
				if(service.loginuser()) {
					
					System.out.println("user Logged in succesfully");
				}
				else {
					System.out.println("login failed");
					break;
				}
				
				do {

					Menu.subMenuUser();

					int userChoice = sc.nextInt();
					switch (userChoice) {

					case 1: {
						//To list all Products
						List<ProductTO> products = proservice.getAllProducts();
						
						for(ProductTO to : products) {
							
		
							System.out.println(to);
						}
						break;
					}
					case 2: {
						//to Place order
						oservice.addOrder();
						break;
					}
					case 3: {
						//to Print Order History By User
						oservice.getAllOrdersByUser();
						break;
					}
					case 4: {
//						to Show the products lowest to highest price
						proservice.getAllProductsByPriceAsc();
						break;
					}
					case 5: {
//						to Show the products highest to lowest price
						proservice.getAllProductsByPriceDsc();
						break;
					}
					
	
					default: {
						System.out.println("Invalid Input");
						break;
					}
					}

					System.out.println("Do you Wish to Continue : select Yes or No ");
					s = sc.next();
				} while (s.equalsIgnoreCase("yes"));

				break;

			}
			case 3: {
				// login with adminprivillage
				
				if(service.loginadmin()) {
					
					System.out.println("Admin Logged in succesfully");
				}
				else {
					
					System.out.println("login failed");
					break;
				}
				do {

					Menu.subMenuAdmin();

					int adminChoice = sc.nextInt();
					switch (adminChoice) {

					case 1: {//insert new product
						proservice.addProduct();
						break;
					}
					case 2: {
						//remove product;
						proservice.removeProduct();
						break;
					}
					case 3: {
						//update product
						proservice.updateProduct();
						break;
					}
					case 4: {
						//To Show all the orders
						oservice.getAllOrders();
						break;
					}
					case 5: {
						//to Search Product by id
						List<ProductTO> products = proservice.getProductsByProductID();
						for(ProductTO to : products) {
							
							System.out.println(to);
						}
						break;
					}
					case 6: {
						//To Block customer
						System.out.println("Enter the user ID to be blocked");
						int uid=sc.nextInt();
						service.block(uid);
						break;
					}
					
					default: {
						System.out.println("Input input");
						break;
					}
					}
					
					System.out.println("Do you Wish to Continue : select Yes or No ");
					s = sc.next();
				} while (s.equalsIgnoreCase("yes"));
				break;
			}
			case 0: {
				// log out
				System.out.println("Loggged out SuccesFully");
				System.exit(0);

			}
			default: {
				System.out.println("Invaild Output");

				break;
			}
			}
			System.out.println();
			
			System.out.println("Do you Wish to Continue : select Yes or No ");
			s = sc.next();

		} while (s.equalsIgnoreCase("yes"));
		System.out.println("Bye Thanks for using me");
		
	}

}

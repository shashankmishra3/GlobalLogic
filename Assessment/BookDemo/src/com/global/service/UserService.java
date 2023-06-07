package com.global.service;

import java.util.List;
import java.util.Scanner;

import com.global.repository.UserRepository;
import com.global.to.UserTO;
//import com.global.service.BookService;
import com.global.to.BookTO;

public class UserService {

	UserRepository repository = new UserRepository();
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

		UserTO user = new UserTO(userName, password, firstName, lastName);
		repository.register(user);

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

			switch (userMenuChoice) {
			case 1:
				listAllBooks();
				break;
			case 2:
				searchByAuthorName();
				break;
			case 3:
				searchByTitleName();
				break;
			case 4:
				searchByPublicationName();
				break;
			case 5:
				searchById();
				break;
			default:
				System.out.println("You have Entered a wrong Choice");
				userMenu();
				break;
			}
		} else {

			System.out.println("Wrong Credentials...");
		}

	}

	public int userMenu() {
		System.out.println("Enter 1 to List all Books and 2 to Search by Author Name and 3 to search by Title Name"
				+ "and 4 to search by Publication Name and 5 to search by Id");
		int userChoice = sc.nextInt();
		return userChoice;
	}

	public void listAllBooks() {
		List<BookTO> books = bookService.getAllBooks();

		for (BookTO to : books) {

			System.out.println(to.getBookID() + ", " + to.getPrice() + ", " + to.getAuthorName() + ", "
					+ to.getBookName() + ", " + to.getPublicationName() + ", " + to.getNoOfCopiesSold());

		}
	}

	public void searchByAuthorName() {
		System.out.println("Enter the Author Name to be searched");
		String SearchAuthorName = sc.next();
		List<BookTO> books = bookService.getByAuthorName(SearchAuthorName);
		for (BookTO to : books) {

			System.out.println(to.getBookID() + ", " + to.getPrice() + ", " + to.getAuthorName() + ", "
					+ to.getBookName() + ", " + to.getPublicationName() + ", " + to.getNoOfCopiesSold());

		}

	}

	public void searchByTitleName() {
		System.out.println("Enter the Title Name to be searched");
		String SearchTitleName = sc.next();
		List<BookTO> books = bookService.getByTitleName(SearchTitleName);
		for (BookTO to : books) {

			System.out.println(to.getBookID() + ", " + to.getPrice() + ", " + to.getAuthorName() + ", "
					+ to.getBookName() + ", " +  to.getPublicationName() + ", " + to.getNoOfCopiesSold());

		}

	}

	public void searchByPublicationName() {
		System.out.println("Enter the Publication Name to be searched");
		String SearchPublicationName = sc.next();
		List<BookTO> books = bookService.getByPublicationName(SearchPublicationName);
		for (BookTO to : books) {

			System.out.println(to.getBookID() + ", " + to.getPrice() + ", " + to.getAuthorName() + ", "
					+ to.getBookName() + ", " + to.getPublicationName() + ", " + to.getNoOfCopiesSold());

		}

	}

	public void searchById() {
		System.out.println("Enter the Book Id to be searched");
		int SearchId = sc.nextInt();
		List<BookTO> books = bookService.getById(SearchId);
		for (BookTO to : books) {

			System.out.println(to.getBookID() + ", " + to.getPrice() + ", " + to.getAuthorName() + ", "
					+ to.getBookName() + ", " + to.getPublicationName() + ", " + to.getNoOfCopiesSold());

		}

	}

}
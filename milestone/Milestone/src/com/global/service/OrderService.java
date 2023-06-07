package com.global.service;

import java.util.List;
import java.util.Scanner;

import com.global.repository.OrderRepository;

import com.global.to.OrderTO;

public class OrderService {
	Scanner sc = new Scanner(System.in);
	OrderRepository repository = new OrderRepository();
	String oid = "0";

	// For admin to show all orders
	public List<OrderTO> getAllOrders() {

		return repository.findAllOrders();
	}

//For user to show order
	public List<OrderTO> getAllOrdersByUser() {
		System.out.println("Enter the user id");
		String uid = sc.next();

		return repository.findAllOrdersByUser(uid);
	}

// To add order
	public void addOrder() {
		// TODO Auto-generated method stub

		System.out.println("Enter User ID");
		String userid = sc.next();
		System.out.println("enter Product ID");
		String productid = sc.next();
		System.out.println("enter Today Date");
		String date = sc.next();

		OrderTO p1 = new OrderTO(oid, userid, productid, date);
		repository.addOrder(p1);
		oid += "0";
	}

}

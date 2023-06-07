package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.global.db.DBConnection;
import com.global.to.OrderTO;

public class OrderRepository {

	Connection connection = DBConnection.getConnection();

	// To find all orders by the admin

	public List<OrderTO> findAllOrders() {

		List<OrderTO> orders = new ArrayList<OrderTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from orders");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String orderid = resultSet.getString(1);
				String userid = resultSet.getString(2);
				String productid = resultSet.getString(3);
				String date = resultSet.getString(4);

				OrderTO orderTO = new OrderTO(orderid, userid, productid, date);
				orders.add(orderTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return orders;

	}

	// To find all orders by the User

	public List<OrderTO> findAllOrdersByUser(String uid) {

		List<OrderTO> orders = new ArrayList<OrderTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from orders");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
//				orderid,userid,productid, date
				String orderid = resultSet.getString(1);
				String userid = resultSet.getString(2);
				String productid = resultSet.getString(3);
				String date = resultSet.getString(4);

				if (userid.equals(uid)) {
					OrderTO orderTO = new OrderTO(orderid, userid, productid, date);
					orders.add(orderTO);

				}
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return orders;

	}

	// To add a order

	public void addOrder(OrderTO p1) {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = connection.prepareStatement("insert into orders values(?,?,?,?)");

			statement.setString(1, p1.getOrderid());
			statement.setString(2, p1.getUserid());
			statement.setString(3, p1.getProductid());
			statement.setString(4, p1.getDate());

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

	}
}

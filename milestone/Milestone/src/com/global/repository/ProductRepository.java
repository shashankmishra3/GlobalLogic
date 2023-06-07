package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.global.db.DBConnection;
import com.global.to.ProductTO;

public class ProductRepository {

	Connection connection = DBConnection.getConnection();

	public List<ProductTO> findAllProducts() {

		List<ProductTO> products = new ArrayList<ProductTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from product");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int productID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String category = resultSet.getString(4);

				ProductTO productTO = new ProductTO(productID, price, productName, category);
				products.add(productTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return products;

	}

	// To find the products by the productID

	public List<ProductTO> findAllProductsByID(int productID) {
		// TODO Auto-generated method stub
		List<ProductTO> products = new ArrayList<ProductTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from product where productID = ?");

			statement.setInt(1, productID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

//				int productID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String category = resultSet.getString(4);

				ProductTO productTO = new ProductTO(productID, price, productName, category);
				products.add(productTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return products;

	}

	public void addProduct(ProductTO p1) {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = connection.prepareStatement("insert into product values(?,?,?,?)");

			statement.setInt(1, p1.getProductID());
			statement.setInt(2, p1.getPrice());
			statement.setString(3, p1.getProductName());
			statement.setString(4, p1.getCategory());

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

	}

	public void rmvProduct(int productID) {

		try {

			PreparedStatement statement = connection.prepareStatement("delete from product where productID = ?");

			statement.setInt(1, productID);

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

	}

	public void updateProduct(int productID, int price) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement statement = connection
					.prepareStatement("update product set price = ? where productID = ?");
			statement.setInt(1, price);
			statement.setInt(2, productID);

			statement.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

	}

	public List<ProductTO> findAllProductsByPriceAsc() {

		List<ProductTO> products = new ArrayList<ProductTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from product order by price");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int productID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String category = resultSet.getString(4);

				ProductTO productTO = new ProductTO(productID, price, productName, category);
				products.add(productTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return products;

	}

	public List<ProductTO> findAllProductsByPriceDsc() {

		List<ProductTO> products = new ArrayList<ProductTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from product order by price desc");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int productID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String category = resultSet.getString(4);

				ProductTO productTO = new ProductTO(productID, price, productName, category);
				products.add(productTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of ProductRepository");
		}

		return products;

	}

}

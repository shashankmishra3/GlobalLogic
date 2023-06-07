package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.global.db.DBConnection;
import com.global.to.BookTO;

public class BookRepository {

	Connection connection = DBConnection.getConnection();

	public List<BookTO> findAllBooks() {

		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int bookID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				int noOfCopiesSold = resultSet.getInt(3);
				String authorName = resultSet.getString(4);
				String bookName = resultSet.getString(5);
				String publicationName = resultSet.getString(6);

				BookTO bookTO = new BookTO(bookID, price, noOfCopiesSold, authorName, bookName, publicationName);
				books.add(bookTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of BooKRepo");
		}

		return books;

	}

	public List<BookTO> findByAuthorName(String SearchAuthorName) {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where authorName=?");
			statement.setString(1, SearchAuthorName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int bookID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				int noOfCopiesSold = resultSet.getInt(3);
				String authorName = resultSet.getString(4);
				String bookName = resultSet.getString(5);
				String publicationName = resultSet.getString(6);

				BookTO bookTO = new BookTO(bookID, price, noOfCopiesSold, authorName, bookName, publicationName);
				books.add(bookTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of BooKRepo");
		}

		return books;
	}

	public List<BookTO> findByTitleName(String SearchTitleName) {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where titleName=?");
			statement.setString(1, SearchTitleName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int bookID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				int noOfCopiesSold = resultSet.getInt(3);
				String authorName = resultSet.getString(4);
				String bookName = resultSet.getString(5);
				String description = resultSet.getString(6);

				BookTO bookTO = new BookTO(bookID, price, noOfCopiesSold, authorName, bookName, description);
				books.add(bookTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of BooKRepo");
		}

		return books;
	}

	public List<BookTO> findByPublicationName(String SearchPublicationName) {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where publicationName=?");
			statement.setString(1, SearchPublicationName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int bookID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				int noOfCopiesSold = resultSet.getInt(3);
				String authorName = resultSet.getString(4);
				String bookName = resultSet.getString(5);
				String description = resultSet.getString(6);

				BookTO bookTO = new BookTO(bookID, price, noOfCopiesSold, authorName, bookName, description);
				books.add(bookTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of BooKRepo");
		}

		return books;
	}

	public List<BookTO> findById(int SearchId) {
		List<BookTO> books = new ArrayList<BookTO>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from book where bookID=?");
			statement.setInt(1, SearchId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int bookID = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				int noOfCopiesSold = resultSet.getInt(3);
				String authorName = resultSet.getString(4);
				String bookName = resultSet.getString(5);
				String description = resultSet.getString(6);

				BookTO bookTO = new BookTO(bookID, price, noOfCopiesSold, authorName, bookName, description);
				books.add(bookTO);
			}

		}

		catch (Exception e) {
			System.out.println("inside catch of BooKRepo");
		}

		return books;
	}

}
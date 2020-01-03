package com.library.dao;

import java.sql.*;
import java.util.*;

import com.deloitte.library.model.Books;

public class BooksDAO {
	public static Connection connectToDB() {
		Connection connection = null;
		try {// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void addBook(Books book) {
		try {
			Connection con = connectToDB();
			// Create Statement
			PreparedStatement stmt1 = con.prepareStatement("select bookid.NEXTVAL from dual");
			ResultSet rs = stmt1.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			PreparedStatement stmt = con.prepareStatement("insert into books values(?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, book.getBookName());
			stmt.setFloat(3, book.getBookPrice());
			// Execute SQL query
			int affectedrows = stmt.executeUpdate();
			System.out.println("Affected Rows = " + affectedrows);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Books> displayBooks() {
		List<Books> booksList = new ArrayList<Books>();
		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("select * from books");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookPrice(rs.getFloat(3));
				booksList.add(book);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booksList;

	}

	public static List<Books> searchBooks(String name1) {
		List<Books> booksList = new ArrayList<Books>();
		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("select * from books where bookname = '" + name1 + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookPrice(rs.getFloat(3));
				booksList.add(book);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booksList;

	}

	public static boolean deleteBooks(int id) {
		boolean flag = false;
		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("delete from books where bookid = '" + id + "'");
			int affectedrows = stmt.executeUpdate();
			if (affectedrows == 1)
				return flag = true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

}

package com.visa.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.visa.prj.entity.Book;

public class BookDaoJdbcImpl implements BookDao {
	
	private static String INSERT_SQL = "INSERT INTO books (id, title, price) VALUES (0,?,?)";
	private static String SELECT_SQL = "SELECT id, title, price FROM books";

	@Override
	public void addBook(Book book) throws PersistenceException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setString(1, book.getTitle());
			ps.setDouble(2, book.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException("Unable to add book", e);
		} finally {
			DBUtil.closeConnection(con);
		}
		
		
	}

	@Override
	public List<Book> getBooks() throws FetchException {
		List<Book> books = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(SELECT_SQL);
			while(rs.next()) {
				Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
				books.add(b);
			}
		} catch (SQLException e) {
			throw new FetchException("Unable to add book", e);
		} finally {
			DBUtil.closeConnection(con);
		}
		return books;
	}

}

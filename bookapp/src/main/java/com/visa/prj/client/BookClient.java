package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.BookDao;
import com.visa.prj.dao.BookDaoJdbcImpl;
import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.entity.Book;

public class BookClient {
	public static void main(String[] args) {
		while(true) {
			printOptions();
			int choice = KeyboardUtil.getInt("Select Option:");
			if(choice == 1) {
				
				String bookName = KeyboardUtil.getString("Enter book name:");
				Double bookPrice = KeyboardUtil.getDouble("Enter price:");
				Book book = new Book(0, bookName, bookPrice);
				BookDao bookDao = new BookDaoJdbcImpl();
				try {
					bookDao.addBook(book);
					System.out.println("Book added successfully!!!");
				} catch (PersistenceException e) {
//					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
			} else if(choice == 2) {
				BookDao bookDao = new BookDaoJdbcImpl();
				try {
					List<Book> book = bookDao.getBooks();
					for(Book b : book) {
						System.out.println(b.getId() + " : " + b.getTitle() + " : " + b.getPrice());
					}
				} catch (FetchException e) {
//					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
			} else if(choice == 3) {
				System.exit(0);
			}
		}
	}

	private static void printOptions() {
		System.out.println("1. Add book");
		System.out.println("2. List books");
		System.out.println("3. Exit");
		System.out.println("Select [1/2/3]");
	}
}

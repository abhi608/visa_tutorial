package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.visa.prj.entity.Book;

public class ListExample {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
//		List<Book> books = new ArrayList<Book>();
//		ArrayList<Book> books= new ArrayList<>();
//		List<Book> books = new LinkedList<>Book();
		
		books.add(new Book(144, "Hibernate in Action", 1200.00));
		books.add(new Book(809, "Alchemist", 899.00));
		books.add(new Book(713, "Java", 500.00));
		books.add(new Book(623, "GoT", 900.00));
		
//		Collections.sort(books);
		
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		
		for(Book book: books) {
			System.out.println(book.getTitle());
		}
	}
}

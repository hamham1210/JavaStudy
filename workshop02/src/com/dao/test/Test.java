package com.dao.test;
import java.sql.SQLException;


import java.util.List;

import com.dao.dao.BookDAO;
import com.dao.exception.DMLException;
import com.dao.exception.DuplicateNumException;
import com.dao.exception.RecordNotException;
import com.edu.vo.Book;


public class Test {

	public static void main(String[] args) throws DMLException, DuplicateNumException  {
		BookDAO dao = BookDAO.getInstance();
	
		// 1.
		try {
			dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
			dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
			dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
		} catch (DuplicateNumException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		
		// 2.
		printAllBooks(dao.listBooks());
		
		// 3.
		try {
			System.out.println(dao.findBook("a1101"));
		} catch (DuplicateNumException | DMLException | RecordNotException e) {
			System.out.println(e.getMessage());
		}
		
		// 4.
//		dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		
		// 5.
		dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
		try {
			dao.deleteBook("a1103");
		} catch (DuplicateNumException | DMLException |RecordNotException e) {
			System.out.println(e.getMessage());
		}
		printAllBooks(dao.listBooks());
		
		// 6.
		
		try {
			printAllBooks(dao.listBooks());
		} catch (DMLException e) {
			System.out.println(e.getMessage());
		}
		
		// 7.
		System.out.println(dao.count());
	}
	
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
	}

	
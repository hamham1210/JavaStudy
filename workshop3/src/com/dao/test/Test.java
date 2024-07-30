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
	
		printAllBooks(dao.searchBookbytitle("JAVA"));
		printAllBooks(dao.searchBookbypublisher(""));
		printAllBooks(dao.searchBookbyprice(13000));
		dao.saleBook(10);
	}
	
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
	}

	

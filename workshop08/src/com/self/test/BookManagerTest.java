package com.self.test;



import javax.sql.rowset.serial.SQLOutputImpl;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerTest {

	public static void main(String[] args) {
		BookManager service = BookManager.getInstance();
		
		service.insertBook(new Magazine(111,"NW","하승현","승현출판",10000.0,5));
		service.insertBook(new Novel(222,"노인과 바다","허밍웨이", "믿음출판",15000.0,"그래도 살아있다."));
		service.insertBook(new Magazine(333,"KJN","김지남","지남출판",155000.0,5));
	
	Book[] books = service.getAllBook();
	for(Book b: books) {
		if(b==null) {
			break;}
		System.out.println(b);
	}
	System.out.println(service.searchBookByIsbn(111));
	Book[] bookTitle = service.searchBookByTitle("NW");
	for(Book b : bookTitle) {
		if(b == null) {
			break;
		}
		System.out.println(b);
	}
	Book[] bookPulbisher = service.searchBookByPulbisher("지남출판");
	for(Book b : bookPulbisher) {
		if(b == null) {
			break;
		}
		System.out.println(b);
	}
	System.out.println("최소최대");
	Book[] bookPrice = service.searchBookByPrice(100000.0, 1556000.0);
	for(Book b : bookPrice) {
		if(b == null) {
			break;
		}
	
		System.out.println(b);
	}
		System.out.println("총가격");
		System.out.println(service.getSumPriceOfBooks());
		System.out.println("평균");
		System.out.println(service.getAvgPriceOfBooks());
		System.out.println("총 책수");
		System.out.println(service.getNumberOfBooks());
	
	
	}

}

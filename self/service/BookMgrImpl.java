package com.self.service;

import java.util.ArrayList;

import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookMgrImpl implements BookMgr{
	private ArrayList<Book> books = null;
	//싱글톤
	private static BookMgrImpl mgr = new BookMgrImpl();
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	
	@Override
	public void addBook(Book b) {
		
	}

	@Override
	public ArrayList<Book> getAllBook() {
		//
		return null;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = null;
		//
		return book;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> onlySearchMagazin() {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		//
		
		return total;
	}
	@Override
	public int getAvgPrice() {		
		//
		return 0;
	}
}

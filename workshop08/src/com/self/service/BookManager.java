package com.self.service;



import com.self.vo.Book;
/**
 * <pre>
 * {@code
 * 
 *  
 * 이번 Java Document 주석 사용법 예시로 작성
 * 이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
 * 개발자가 자신의 코드를 보완설명하기 위해서 작업하는 방식이다.
 * 
 * }
 * 
 * </pre>
 * 책 정보를 처리하는 클래스
 @author PHR
 @version Test Project version 1.0.1
 @since (만들어 온 날짜, JDK버전 등) JDK 17
 */
public class BookManager {
	/**
	 * 최대로 받을 수 있는 책의 수
	 */
	private static final int MAX_BOOK = 100;
	/**
	 * 현재 책의 수
	 */
	private int numberOfBook;
	/**
	 * 배열의 길이
	 */
	private int idx;
	/**
	 * Book클래스의 배열
	 */
	private Book[] books;
	/**
	 * BookManager 클래스 객체 생성
	 */
	static private BookManager manager = new BookManager();//1
	/**
	 * BookManager 명시적 생성자
	 * @param books
	 * @param numberOfBook
	 * @param idx
	 */
	private BookManager() {
		books = new Book[MAX_BOOK];
		numberOfBook =0;
		idx = 0;
	}//2
	/**
	 * BookManager의 인스턴스 생성
	 * @return
	 */
	public static BookManager getInstance() { //3
		return manager;
	}//싱글톤
	/**
	 * 현재 책의 갯수를 세는 함수
	 * @return
	 */
	
	public int getNumberOfBooks() {
		return numberOfBook;
	}
	/**
	 * Book 배열에 책을 넣어주는 함수
	 * @param b
	 */
	public void insertBook(Book b) {
		if(numberOfBook< MAX_BOOK) {
		books[numberOfBook++] = b;
		}
	}
	/**
	 * 모든 책을 보여주는 함수
	 * @return
	 */
	public Book[] getAllBook() {
		return books;
	}
	/**
	 * i로 들어온 ISbn 값을 찾는 함수
	 * @param i
	 * @return
	 */
	public Book searchBookByIsbn(int i) {
		for(Book b : books) {
			if(b == null) break;
			if(b.getIsbn() == i) {
				return b;
			}
		}
		return null;
	}
	/**
	 * t로 들어온 책의 Title을 찾는 함수
	 * @param t
	 * @return
	 */
	public Book[] searchBookByTitle(String t) {
		Book[] temp = new Book[MAX_BOOK];
		
		for(Book b : books) {
			if (b == null) {
				break;
			}
			if(b.getTitle().equals(t)) {
				temp[idx++] = b;
			}
		}
		return temp;
	}
	/**
	 * p로 들어온 책의 Pulbisher를 찾는 함수
	 * @param p
	 * @return
	 */
	public Book[] searchBookByPulbisher(String p) {
		Book[] temp = new Book[MAX_BOOK];
		for(Book b : books) {
			if(b == null)break;
		if(b.getPubliser().equals(p)) {
			temp[idx++] =b;
		}
		}
		return temp;
	}
	/**
	 * 최소 가격과 최대 가격 사이의 값을 보여주는 함수
	 * @param min
	 * @param max
	 * @return
	 */
	public Book[]searchBookByPrice(double min, double max){
		Book[] temp = new Book[MAX_BOOK];
		for(Book b : books) {
			if(b == null)break;
			if(b.getPrice()>min) {
				temp[idx++] = b;
			}
			else if(b.getPrice()<max) {
				temp[idx++] = b;
			}
			
		}
		
		return temp;
	}
	/**
	 * isn값을 키로 책의 가격을 다 가져온다.
	 * @param isn
	 * @return
	 */
	public int getAPrice(int isn) {		
		int total  = 0;
		for(Book b : books) {
			if(b.getIsbn() == isn) {
				total += b.getPrice();
				break;
			}			
		}//for		
			
		return total;
	}
	/**
	 * 책의 가격들을 모두 더한다.
	 * @return
	 */
	public double getSumPriceOfBooks() {
		double total = 0;
		for(Book b : books) {
			if(b == null) 
				break;
				total += getAPrice(b.getIsbn());
		}
		return total;
	}
	/**
	 * 책의 평균값을 구한다.
	 * @return
	 */
	public double getAvgPriceOfBooks() {
		double avg = getSumPriceOfBooks()/getNumberOfBooks();
		
		return avg;
	}
	
}

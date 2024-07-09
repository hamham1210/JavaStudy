package com.self.vo;
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
 * 책의 정보를 저장하는 클래스
 @author PHR
 @version Test Project version 1.0.1
 @since (만들어 온 날짜, JDK버전 등) JDK 17
 */
public class Book {
	/**
	 * ISBN 번호
	 */
	private int isbn;
	/**
	 * 책 제목
	 */
	private String title;
	/**
	 * 책 저자
	 */
	private String author;
	/**
	 * 출판소
	 */
	private String publiser;
	/**
	 * 책 가격
	 */
	private double price;
	/**
	 * Book 명시적 생성자
	 */
	public Book() {}
	/**
	 * Book 생성자
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publiser
	 * @param price
	 */
	public Book(int isbn, String title, String author, String publiser, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publiser = publiser;
		this.price = price;
	}	
	/**
	 * isbn 돌려주는 함수
	 * @return
	 */
	public int getIsbn() {
		return isbn;
	}
	/**
	 * isbn을 가져오는 함수
	 * @param isbn
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	/**
	 * title을 돌려주는 함수
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 제목을 가져오는 함수
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 작가를 돌려주는 함수
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 작가을 가져오는 함수
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 출판사를 돌려주는 함수
	 * @return
	 */
	public String getPubliser() {
		return publiser;
	}
	/**
	 * 출판사를 가져오는 함수
	 * @param publiser
	 */
	public void setPubliser(String publiser) {
		this.publiser = publiser;
	}
	/**
	 * 가격을 돌려주는 함수
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 가격을 가져오는 함수
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 책정보를 돌려주는 함수
	 */
	@Override
	public String toString() {
		return "Book [Isbn=" + isbn + ", Title=" + title + ", Author=" + author
				+ ", publiser=" + publiser + ", price"+ price+"]";
	}
	
}

package com.edu.vo;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String description;
	private int authorno;
	public Book(String isbn, String title, String author, String publisher, int price, String description ) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
	}

	public Book(String author, String title, String isbn,String publisher ) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	public Book(String title, String author, String publisher,int price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	public Book(String title, String publisher) {
		super();
		this.title = title;
		this.publisher = publisher;
	}


	public Book() {
		super();
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Book [");

		if (isbn != null && !isbn.equals("N/A")) {
			sb.append("isbn=").append(isbn).append(", ");
		}
		if (title != null) {
			sb.append("title=").append(title).append(", ");
		}
		if (author != null) {
			sb.append("author=").append(author).append(", ");
		}
		if (publisher != null) {
			sb.append("publisher=").append(publisher).append(", ");
		}
		if (price != -1) { // 가격이 설정된 경우에만 포함
			sb.append("price=").append(price).append(", ");
		}
		if (description != null && !description.equals("N/A")) {
			sb.append("description=").append(description).append(", ");
		}

		// 마지막 쉼표와 공백 제거
		int length = sb.length();
		if (length > 6) {
			sb.delete(length - 2, length);
		}

		sb.append("]");
		return sb.toString();
	}

}    

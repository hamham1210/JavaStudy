package com.dao.dao;

import com.dao.exception.DuplicateNumException;
import com.dao.exception.RecordNotException;
import com.dao.exception.DMLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.confing.Config;
import com.edu.vo.Book;

public class BookDAO {
	private static BookDAO instance = new BookDAO();
	//인스턴스 생성

	private BookDAO( ){
		try {
			Class.forName(Config.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		}
		catch(Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	public static BookDAO getInstance() {
		//인스턴스 반환
		return instance;
	}
	public Connection getConnection()throws SQLException{
		Connection con = DriverManager.getConnection(Config.URL,Config.USER,Config.PASSWORD);
		System.out.println("DB연결 성공");
		return con;
		//DB 연결
	}
	public void close(Connection c)throws SQLException  {
		if(c != null) c.close();
	}
	public void close(PreparedStatement p)throws SQLException  {
		if(p != null) p.close();
	}
	public void close(ResultSet rs)throws SQLException  {
		if(rs != null) rs.close();
	}
	
	public void insertBook(Book book) throws DuplicateNumException, DMLException {
		String query = "INSERT INTO BOOK(isbn, title, author, publisher, price, description) VALUES(Rpad(?,8,' '), ?, ?, ?, ?, ?)";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query) ){
//			String paddedIsbn = String.format("%-8s", book.getIsbn()).replace(' ', '*');
			p.setString(1, book.getIsbn());
			p.setString(2,book.getTitle());
			p.setString(3,book.getAuthor());
			p.setString(4, book.getPublisher());
			p.setInt(5, book.getPrice());
			p.setString(6, book.getDescription());
			//바인딩
			
			System.out.println("[Result ok message] =>"+p.executeUpdate()+"책 정보를 추가 했습니다.");
		}
			catch(SQLIntegrityConstraintViolationException e){ //중복오류
				throw new DuplicateNumException("[Result error message] => 이미 있는 책정보입니다.");
			}catch(SQLException e) {// 문법오류 
				 e.printStackTrace(); 
				throw new DMLException("[Result error message] =>책정보 등록 실패");
			}
		}

	public void updateBook(Book book)throws DuplicateNumException, DMLException {
		String query = "update book set title=?, author= ?,publisher=?,price=?,description=? where isbn=?";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query) ){
//		String paddedIsbn = String.format("%-8s", book.getIsbn()).replace(' ', '*');	
		p.setString(1, book.getTitle());
		p.setString(2, book.getAuthor());
		p.setString(3, book.getPublisher());
		p.setInt(4, book.getPrice());
		p.setString(5, book.getDescription());
		p.setString(6, book.getIsbn());
		
	System.out.println(p.executeUpdate()+"업데이트 성공");	
		
	}
		catch(SQLIntegrityConstraintViolationException e){
			throw new DuplicateNumException("이미 있는 책정보입니다.");
		}catch(SQLException e) {
			 e.printStackTrace(); 
			throw new DMLException("책정보 등록 실패");
		}
	}
	
public void deleteBook(String isbn)throws DuplicateNumException, DMLException,RecordNotException {
	String query = "DELETE FROM book WHERE isbn=?";
	try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
		p.setString(1, isbn);
		
		if(p.executeUpdate() == 0)
		throw new RecordNotException();
		System.out.println(p.executeUpdate()+"삭제 성공");
	}
	catch(SQLIntegrityConstraintViolationException e){
		throw new DuplicateNumException("이미 있는 책정보입니다.");
	}catch(SQLException e) {
		  
		throw new DMLException("책 삭제 실패");
	}
	}

public Book findBook(String isbn)throws DuplicateNumException, DMLException, RecordNotException {
	Book book = null;
	String query ="select isbn, title, author, publisher, price, description from book where isbn= trim(?)";
	
	try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query); ){
		p.setString(1, isbn);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			book = new Book(isbn, rs.getString("title"),rs.getString("author"),rs.getString("publisher"),rs.getInt("price"),rs.getString("description"));
		}
		else {
			throw new RecordNotException("일치하는 도서가 없습니다.");
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new DMLException("책 정보를 찾지 못했습니다.");
	}
	return book;
}
	public List<Book> listBooks() throws DMLException{
		List<Book> list = new ArrayList<Book>();
		String query = "select isbn, title, author, publisher, price, description from book";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query); ){
	
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				list.add(new Book (rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description")
						));
			};
		}catch(SQLException e){
			e.printStackTrace();
			throw new DMLException("책 정보를 찾지 못했습니다.");
		}
		
		return list;
	}
	
	
	public int count()throws DMLException  {
		String query = "select count(isbn) count from book";
		int count = 0;
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
			ResultSet rs = p.executeQuery();
			if(rs.next()) count = rs.getInt("count");
		}catch(SQLException e) {
			throw new DMLException("카운트 실패");
		}
		return  count;
	}
	
	public List<Book> searchBookbytitle(String title) throws DMLException{
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE title like ?";

		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
	
		p.setString(1,  "%" + title + "%");
		ResultSet rs = p.executeQuery();
		
			while(rs.next()) {
				
				list.add(new Book (rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description")
						));
			
		};
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DMLException("책 정보를 찾지 못했습니다.");
			}
		return list;
		}
			
			
			
		
		
	
	
	public List<Book> searchBookbyauthor(String author) throws DMLException{
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE author like ?";

		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
	
		p.setString(1,  "%" + author + "%");
		ResultSet rs = p.executeQuery();
		
			while(rs.next()) {
				
				list.add(new Book (rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description")
						));
			
		};
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DMLException("책 정보를 찾지 못했습니다.");
			}
		return list;
		
	}
	public List<Book> searchBookbypublisher(String publisher) throws DMLException{
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE publisher like ?";

		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
	
		p.setString(1,  "%" + publisher + "%");
		ResultSet rs = p.executeQuery();
		
			while(rs.next()) {
				
				list.add(new Book (rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description")
						));
			
		};
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DMLException("책 정보를 찾지 못했습니다.");
			}
		return list;
	}
	public List<Book> searchBookbyprice(int price) throws DMLException{
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT isbn, title, author, publisher, price, description FROM book where price BETWEEN ? AND ? ";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query)){
			p.setInt(1, price);
			int maxPrice = price+10000;
	        p.setInt(2, maxPrice);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				
				list.add(new Book (rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description")
						));
			
		};
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DMLException("책 정보를 찾지 못했습니다.");
			}
		return list;
		
	}
	public void saleBook(int discountRate) throws DMLException {
		String searchquery = "select isbn, title, author, publisher, price, description from book";
		String query = "update book set price = ? where  publisher like ? ";
		
		try(Connection con = getConnection(); 
				PreparedStatement p = con.prepareStatement(searchquery);
				PreparedStatement ps = con.prepareStatement(query);){
			ResultSet rs = p.executeQuery();
		if(rs.next()) {
			
			   int originalPrice = rs.getInt("price");
	            double discountAmount = originalPrice * (discountRate / 100.0); // 여기서 할인 금액을 정확히 계산
	            int newPrice = (int) (originalPrice - discountAmount); // 새 가격을 계산
	            
			  
			ps.setInt(1, newPrice);
			ps.setString(2,  "%" + rs.getString("publisher") + "%");
		 System.out.println("자앤 출판사 반값할인"+ps.executeUpdate());	
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("책 정보를 찾지 못했습니다.");
		}
	
	}
}


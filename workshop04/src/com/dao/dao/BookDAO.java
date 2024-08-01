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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
	// Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능을 구현한다. 
	
	public List<String> showBookList() throws DMLException {
		List<String> list = new ArrayList<>();
		String query = "SELECT concat(b.title,',', b.price,',', a.name) from book b,author a where b.authorno = a.authorno;";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query); ){
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("concat(b.title,',', b.price,',', a.name)"));
			};
		}catch(SQLException e){
			e.printStackTrace();
			throw new DMLException("책 정보를 찾지 못했습니다.");
		}
		return list;
	}
	// 이름이 ‘ 김XX ’인 저자의 도서명, isbn, 출판사를 출력하는 기능을 작성한다. 
	public List<Book> searchBookByLastname(String lastname) throws DMLException {
		List<Book> list = new ArrayList<>();
		String query = "SELECT a.name,b.title,b.isbn ,b.publisher from book b, author a where b.authorno = a.authorno and name like ?";
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query); ){
			
			p.setString(1,  lastname + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("b.isbn"),
						rs.getString("b.title"),
						rs.getString("a.name"),
						rs.getString("b.publisher")));	
			};
		}catch(SQLException e){
			e.printStackTrace();
			throw new DMLException("책 정보를 찾지 못했습니다.");
		}
		return list;
		
	}
	//Author 테이블에 있는 저자명 별로 출간된 도서들을 도서명, 출판사, 가격,저자명을 출력하는 기능을 구현한다.
	
	public List<Book>  searchByName() throws DMLException {
		
		List<Book> list = new ArrayList<>();
	
		String query = "SELECT b.title,b.publisher,b.price,a.name from book b, author a where b.authorno = a.authorno ORDER BY a.name;";
		
		try(Connection con = getConnection(); PreparedStatement p = con.prepareStatement(query); ){
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				list.add(new Book(null,rs.getString("b.title"),
						rs.getString("a.name"),
						rs.getString("b.publisher"),
						rs.getInt("b.price"),null));	
			};
		
		}catch(SQLException e){
			e.printStackTrace();
			throw new DMLException("책 정보를 찾지 못했습니다.");
		}
		List<Book> filteredObjects = list.stream()
	            .filter(obj -> obj.getIsbn() != null && obj.getDescription() != null)
	            .collect(Collectors.toList());
		System.out.println(filteredObjects);
			return filteredObjects;
		}
	
	
	
	
	
//	 6. Book 테이블에 있는 title와 publisher를 이용하여 서로의 관계를 다음과 같이
//	 출력되도록 기능을 구현한다. ( ‘IoT세상은 미래닷컴에서 출판했다’)

	public void printTitle(String title, String publisher) {
		
	}
}


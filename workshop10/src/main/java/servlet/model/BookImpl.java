package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookImpl implements BookDAO {
	private DataSource ds;
	private static BookImpl dao = new BookImpl();
	private BookImpl() {
		//Naming Service작업 진행.
				try {
				InitialContext ic = new InitialContext();
				ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
				System.out.println("DataSource lookup...Succuece");
				}catch(NamingException e) {
					System.out.println("DataSource lookup...Fail");
				}
	}
	
	public static BookImpl  getInstance() {
		return dao;
		
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null)ps.close();
		if(conn != null)conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		if(rs!=null)rs.close();
	}

	@Override
	public void registerBook(Book vo) throws SQLException {
		String query = "INSERT INTO book(isbn,title,catalogue,nation,publish_date,publisher,author,price,currency,description )"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
		ResultSet rs= null;
		try(Connection conn= getConnection(); PreparedStatement ps = conn.prepareStatement(query);){
			
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			ps.executeUpdate();
		}
	}


	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		String query = "SELECT isbn, title, catalogue, author FROM book";
		ArrayList<Book> list = new ArrayList<Book>();
		
		try(Connection conn= getConnection(); PreparedStatement ps = conn.prepareStatement(query);){
			ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			list.add(new Book(rs.getString("isbn"),
					rs.getString("title"),
					rs.getString("catalogue"),
					rs.getString("author")));
		}
		}
		/*
		 * for(Book b : list) { System.out.println(b); }
		 */
		return list;
	}

	@Override
	public ArrayList<Book> searchBook(String cond, String condDesc) throws SQLException {

	    String query = "SELECT isbn, title, catalogue, author FROM book WHERE " + cond + " LIKE ?";

	    ArrayList<Book> list = new ArrayList<Book>();

	    try (Connection conn = getConnection(); 
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        
	        ps.setString(1, "%" + condDesc + "%");

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            list.add(new Book(rs.getString("isbn"),
	                    rs.getString("title"),
	                    rs.getString("catalogue"),
	                    rs.getString("author")));
	        }
	    }

	    return list;
	}

	@Override
	public Book searchTitle(String title) throws SQLException {
	
	    String query = "SELECT isbn, title, catalogue, author FROM book WHERE title=?";

	    Book book = new Book();

	    try (Connection conn = getConnection(); 
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        // 전체 패턴을 하나의 문자열로 만들어 설정합니다.
	        ps.setString(1, title);

	        ResultSet rs = ps.executeQuery();
	       if (rs.next()) {
	            book = (new Book(rs.getString("isbn"),
	                    rs.getString("title"),
	                    rs.getString("catalogue"),
	                    rs.getString("author")));
	        }
	    }

	    return book;
	}

}
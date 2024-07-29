package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

/*
 * JDBC기본 4단계 작업
 * 1. 서버정보를 담고 있는... 드라이버 로딩
 * 2. 디비서버 연결...Connection반환
 * 3. PreparedStatement 객체 생성.
 * 4. SQL 쿼리문 실행 
 * */


public class JDBC4ProcessTest1 {
	
	public JDBC4ProcessTest1() {
		//1. 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //FQCN
		System.out.println("Driver Loading Success...");
		//2.
		String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		Connection conn = DriverManager.getConnection(url, "root", "1234");
		System.out.println("DBconnection");
		
		//3.
		String query = "Insert into custom (id, name, address) values(?,?,?)";

		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("Preparedstatement Creating...");
		
		//4. 1)?에 값 바인딩 2)sql 실행.. 이때 디비에 데이터가 입력됨
		
		ps.setInt(1, 111);
		ps.setString(2,"james");
		ps.setString(3, "NY");
		
		int row = ps.executeUpdate();
		System.out.println(row + "Row Record 등록 성공");
		
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
		catch(SQLException e) {
			System.out.println("Driver Connection Fail...");
		}
	}

	public static void main(String[] args) {
		new JDBC4ProcessTest1();

	}

}

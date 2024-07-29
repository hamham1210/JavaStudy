package com.edu.jdbc.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import config.SeverInfo;

/*
 * 서버 주소
 * 계정 명
 * 게정 비번
 * 이런 값들을 프로그램 코드에 노출되면 안되는 값들이다.
 * 프로그램에 이런 실제값이 들어가는 것 == 하드코딩 
 * 
 * 서버의 파편적인 정보를 외부에 모듈화(메타데이터화)시켜야 한다.
 * String(key) = String(value)... properties파일 사용
 * */


public class JDBC4ProcessTest4 {
	
	static String driver;
	static String url;
	static String user;
	static String pass;
	static String qurey;
	
	public JDBC4ProcessTest4()throws Exception {
		Class.forName(SeverInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공");
		Connection conn = DriverManager.getConnection(url,user,pass);
		System.out.println("db연결 성공");
	
		PreparedStatement ps = conn.prepareStatement(qurey);
		ResultSet rs = ps.executeQuery();
		System.out.println("-----------------------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("address"));
		}
		System.out.println("-----------------------------------------------");
	}
	public static void main(String[] args)throws Exception  {
		new JDBC4ProcessTest4();
	}
	static {
		try {Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties"));
		
		driver = p.getProperty("jdbc.mysql.driver");
		url = p.getProperty("jdbc.mysql.url");
		user= p.getProperty("jdbc.mysql.user");
		pass= p.getProperty("jdbc.mysql.pass");
		qurey = p.getProperty("jdbc.sql.query");
			
			
}catch(Exception e) {
	System.out.println("드라이버 로딩 실패");
}
	
			
		
		
			
			
			
		
			
			
			
			
			
	}
	
	

}

package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import config.SeverInfo;

/*
 * 서버 주소
 * 계정 명
 * 게정 비번
 * 이런 값들을 프로그램 코드에 노출되면 안되는 값들이다.
 * 프로그램에 이런 실제값이 들어가는 것 == 하드코딩 
 * 서버의 파편적인 정보를 외부에 모듈화(메타데이터화)시켜야 한다.
 * */


public class JDBC4ProcessTest3 {
	
	
	public JDBC4ProcessTest3() {
		//1. 
		try {
		 Connection conn = DriverManager.getConnection(SeverInfo.URL,SeverInfo.USER,SeverInfo.PASSWORD);
		 System.out.println("디비 연결 성공");
		 /*
		 //INSERT
		 String query = "Insert into custom (id, name, address) values(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 System.out.println("3.Preparedstatemaent 생성");
		 
		 ps.setInt(1, 444);
		 ps.setString(2,"이진영");
		 ps.setString(3,"부산");
		 
		 System.out.println(ps.executeUpdate()+ "로우 인서트 오케이");
		 */
		 /*
		 //Delet..id가 2인 사람 삭제
		 String query = "DELETE FROM custom where id=?";
		 PreparedStatement ps = conn.prepareStatement(query);
		 System.out.println("Preparedstatemaent 생성");
		 ps.setInt(1, 222);
		 
		 System.out.println(ps.executeUpdate()+"한 줄 삭제 완료");
		 */
		 /*
		 //update.. id 값이 4인 사람의 정보를 수정.. name(오상욱), address(광주)
		 String query = "Update custom set name = ?, address = ? where id=?";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, "오상욱");
		 ps.setString(2, "광주");
		 ps.setInt(3, 444);

		 System.out.println(ps.executeUpdate()+"수정완료");
		 */
		 //select문 하기
		 
		 String query = "select id, name, address from custom";
		 
		 PreparedStatement ps = conn.prepareStatement(query);
		 
		 ResultSet rs =  ps.executeQuery();
		 
		 while (rs.next()) {
			System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("address"));
		}
		
		}
		catch(SQLException e) {
			System.out.println("DB Connection Fail...");
		}
	}

	public static void main(String[] args) {
		new JDBC4ProcessTest3();
	}
	static {
		try {
			Class.forName(SeverInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}

}

package com.edu.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.edu.vo.Custom;

import config.ServerInfo;

public class SimpleJDBCtest {
	
	public SimpleJDBCtest() throws Exception {
		
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공");
	}
	public Connection getConnect() throws Exception{
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("1. db연결 성공");
		return conn;
		//1. 디비 연결
	}
	public void closeAll(PreparedStatement p, Connection conn)throws SQLException {
		if(p != null) p.close();
		if (conn != null)conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement p, Connection conn)throws SQLException {
		if(rs != null)rs.close();
		closeAll(p, conn);
	}
	
	public void addCustom(Custom c)throws Exception {
		//insert into 
		PreparedStatement p = null;
		Connection conn = null;
		conn = getConnect();
		String query = "Insert into custom (id, name, address) values(?,?,?)";
		p = getConnect().prepareStatement(query);
		 System.out.println("2.Preparedstatemaent 생성");
		//2. PrepareStatement 생성
		 p.setInt(1, c.getId());
		 p.setString(2, c.getName());
		 p.setString(3, c.getAddress());
		 System.out.println("3.바인딩");
		//3. 바인딩
		 System.out.println(p.executeUpdate()+"값을 넣었습니다.");
		//4. 쿼리문 실행
	}
	
	public Custom getCustom(int id)throws Exception { //BusinessLogic(중요한 로직.. 디비 AccessLogic)
		Custom custom = null;
		PreparedStatement p = null;
		Connection conn = null;
		ResultSet rs =null;
		 conn = getConnect();
		System.out.println("db연결 성공");
		//select where
		//2. 디비 연결
				//2. PrepareStatement 생성
		String query = "select id,name,address from custom where id=?";
		 p = conn.prepareStatement(query);
				//3. 바인딩
		p.setInt(1, id);
				//4. 쿼리문 실행
		 rs = p.executeQuery();
		System.out.println("-----------------------------------------------");
		if (rs.next()) {
			custom = new Custom(id,
					rs.getString("name"),rs.getString("address"));
		}
		//5.자원반환
		closeAll(rs,p, conn);
		return custom;
	}
	
	public ArrayList<Custom> getCustom()throws Exception {
		ArrayList<Custom> list = new ArrayList<Custom>(); 
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("db연결 성공");
		//select where
		//2. 디비 연결
				//2. PrepareStatement 생성
		String query = "select id,name,address from custom ";
		PreparedStatement p = conn.prepareStatement(query);
				//3. 바인딩
				//4. 쿼리문 실행
		ResultSet rs = p.executeQuery();
		System.out.println("-----------------------------------------------");
		while (rs.next()) {
			list.add(new Custom(rs.getInt("id"),
					rs.getString("name"),rs.getString("address")));
		}
		return list;
	}
	public static void main(String[] args)throws Exception {
		
		SimpleJDBCtest dao = new SimpleJDBCtest();
//		dao.addCustom(new Custom(555,"blake","LA"));
//		System.out.println(dao.getCustom(111));
		dao.getCustom().stream().forEach(i->System.out.println(""));
		
	}
	
	static {
		
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		
		}
		catch(Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
		
	}

}

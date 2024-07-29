package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.config.ServerInfo;
import com.edu.vo.Employee;



public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	//인스턴스 생성

	private EmployeeDAOImpl( ){
		//생성자 생성
	}
	public static EmployeeDAOImpl getInstance() {
		//인스턴스 반환
		return instance;
	}
		
	 @Override
	 public Connection getConnect() throws Exception{
		 Connection con = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		 System.out.println("db연결 완료");
		 return con;
	 }

	@Override
	public void closeAll(PreparedStatement p, Connection c)throws SQLException {
		if(p != null)p.close();
		if(c != null)c.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement p, Connection c) throws SQLException{
		if(rs != null)rs.close();
		closeAll(p, c);
	}

	@Override
	public void insertEmployee(Employee emp)throws Exception {
		PreparedStatement p = null;
		Connection con = null;
		con = getConnect();//db연결, 위의 코드에서 연결된 db 가져옴
		String query = "Insert into employee (num,name,salary,address) values(?,?,?,?)";
		System.out.println("2. PreparedStatement생성");
		p = getConnect().prepareStatement(query);
		p.setInt(1, emp.getNum());
		p.setString(2, emp.getName());
		p.setFloat(3, emp.getSalary());
		p.setString(4, emp.getAddress());
		System.out.println("3. 바인딩");
		System.out.println(p.executeUpdate()+"값을 넣었습니다.");
		
	}

	@Override
	public void removeEmployee(int num)throws Exception {
		PreparedStatement p = null;
		Connection con = null;
		con = getConnect();
		String query = "DELETE FROM employee where num=?";
		System.out.println("2. PreparedStatement생성");
		p = con.prepareStatement(query);
		p.setInt(1, num);
		 System.out.println(p.executeUpdate()+"한 줄 삭제 완료");
	}

	@Override
	public void UpdateEmployee(Employee emp)throws Exception {
		PreparedStatement p = null;
		Connection con = null;
		con = getConnect();
		String query = "Update employee set name = ?, salary = ?,address = ? where num=?";
		p = con.prepareStatement(query);
		p.setString(1,emp.getName());
		p.setFloat(2, emp.getSalary());
		p.setString(3, emp.getAddress());
		p.setInt(4, emp.getNum());
		 System.out.println(p.executeUpdate()+"업데이트 완료");
	}

	@Override
	public ArrayList<Employee> selectEmployee()throws Exception {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement p = null;
		Connection con = null;
		ResultSet rs = null;
		con = getConnect();
		String query = "select num,name,salary,address from employee ";
		p = con.prepareStatement(query);
		rs = p.executeQuery();
		 while (rs.next()) {
				System.out.println(rs.getInt("num")+","+rs.getString("name")+","+rs.getFloat("salary")+rs.getString("address"));
			}
		return list;
		
	}

	@Override
	public Employee selectEmployee(int num)throws Exception {
		Employee e = null;
		PreparedStatement p = null;
		Connection con = null;
		ResultSet rs = null;
		con = getConnect();
		String query = "select * from employee where num = ?";
		p = con.prepareStatement(query);
		p.setInt(1, num);
		rs= p.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt("num")+","+rs.getString("name")+","+rs.getFloat("salary")+rs.getString("address"));
		}
		return e;
		
	}
static {
	//드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		
		}
		catch(Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
		
	}
	
	
	
}

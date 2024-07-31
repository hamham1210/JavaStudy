package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DuplicateNumException;
import com.edu.vo.Employee;

import config.ServerInfo;

public class EmployeeDAO {
	private static EmployeeDAO dao = new EmployeeDAO();

	private EmployeeDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		}
	}
	
	public static EmployeeDAO getinstance(){
		return dao;
	} 
	/////////////////////// 공통적인 로직 ////////////////////////////////////////////
	public Connection getConnect() throws SQLException {
		System.out.println("db연결 성공....");
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	///////////////////////// 비지니스 로직 //////////////////////////////////
	
	private boolean isExist(int num, Connection conn) throws SQLException{ //PK에 해당하는 사람이 있는지여부
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT num FROM employee WHERE num=?";
				
		ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		rs = ps.executeQuery();
		return rs.next();
	}
	public void insertEmployee(Employee emp) throws DuplicateNumException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			//isExist() 함수를 호출해서 사람이 없을때만 아래 코드가 실행되도록 로직을 제어한다.
			if(!isExist(emp.getNum(), conn)) { //추가하려는 사람이 없다면...
				String query = "INSERT INTO employee(num, name, salary, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, emp.getNum());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setString(4, emp.getAddress());
				
				ps.executeUpdate();
			}else {
				throw new DuplicateNumException(emp.getName()+" 님은 이미 회원입니다.");
			}	
			}finally {			
				closeAll(ps, conn);//무조건 자원 반환은 된다.			
		}
	}
	
	public void removeEmployee(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		String query = "DELETE FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}
	
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		String query = "UPDATE employee SET name=?, salary=?, address=? WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, emp.getNum());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}
	
	public List<Employee> selectEmployee() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		conn = getConnect();
		String query = "SELECT num, name, salary, address FROM employee";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			employees.add(new Employee(rs.getInt("num"),
					          rs.getString("name"),
					          rs.getDouble(3),
					          rs.getString(4))); 
		}
		
		closeAll(rs, ps, conn);
		
		return employees;
	}
	
	public Employee selectEmployee(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		
		conn = getConnect();
		String query = "SELECT num, name, salary, address FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			employee = new Employee(num,
					          rs.getString("name"),
					          rs.getDouble(3),
					          rs.getString(4)); 
		}
		
		closeAll(rs, ps, conn);
		
		return employee;
	}
	
}



















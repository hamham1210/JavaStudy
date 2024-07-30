package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DMLException;
import com.edu.exception.DuplicateNumException;
import com.edu.exception.RecordNotFoundException;
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
	
//	private boolean isExist(int num, Connection conn) throws SQLException{ //PK에 해당하는 사람이 있는지여부
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		String query = "SELECT num FROM employee WHERE num=?";
//				
//		ps = conn.prepareStatement(query);
//		ps.setInt(1, num);
//		rs = ps.executeQuery();
//		return rs.next();
//	}//해당 코드를 쓰면 쿼리르 두 번 날리기 때문에 좋지 않다.
	
	//isExist() 사용안하는 경우..(쿼리문 2번 동작할 이유가 없다.)
	public void insertEmployee(Employee emp)throws DMLException, DuplicateNumException{
	
		String query = "INSERT INTO employee(num, name, salary, address) VALUES(?,?,?,?)";
		try (Connection conn = getConnect();PreparedStatement ps = conn.prepareStatement(query)){
			//닫아야 하는  리소스를 모두 try에 인자 값으로 주면 해당 인자는 코드가 끝날 때 자동으로 닫힌다.
				ps.setInt(1, emp.getNum());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setString(4, emp.getAddress());
				
				ps.executeUpdate();
			}	
		catch(SQLIntegrityConstraintViolationException e) {
			throw new DuplicateNumException("이미 회원가입된 상태입니다.");
		}catch(SQLException e) {
			throw new DMLException("회원가입 실패");
		}
								
		}//화면에서 예외는 일반인이 보기 편하게 터져야한다.
	
	public void removeEmployee(int num) throws DMLException, RecordNotFoundException {
		
		String query = "DELETE FROM employee WHERE num=";
		
		try(Connection conn = getConnect();PreparedStatement ps=conn.prepareStatement(query)){
	
		ps.setInt(1, num);
		
		ps.executeUpdate();
		System.out.println(ps.executeUpdate()+"명 삭제 했습니다.");
		if(ps.executeUpdate()==0)throw new RecordNotFoundException("해당하는 "+ num +"이 존재하지 않습니다.");
	}catch(SQLException e) {
		throw new DMLException("삭제에 실패했습니다.");
	}
	}
		

	
	public void updateEmployee(Employee emp) throws RecordNotFoundException,DMLException {
		String query = "UPDATE employee SET name=?, salary=?, address=? WHERE num=";
		
		try(Connection conn = getConnect(); PreparedStatement ps=conn.prepareStatement(query)){
		
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, emp.getNum());
		
		ps.executeUpdate();
		System.out.println(ps.executeUpdate()+"수정사항 확인");
		if(ps.executeUpdate() ==0)throw new RecordNotFoundException("수정하고자 하는 인원이 없습니다.");
		//업데이트 할 인원이 없을 때 터지는 에러.
		}catch(SQLException e){
			throw new DMLException("업데이트에 실패했습니다.");
			//퀴리문이 틀렸을 때 터지는 에러
		}
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



















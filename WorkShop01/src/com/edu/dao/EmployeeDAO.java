package com.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.vo.Employee;

public interface EmployeeDAO {
	Connection getConnect()throws Exception;
	 void closeAll(PreparedStatement p, Connection c)throws SQLException ;
	 void closeAll(ResultSet rs, PreparedStatement p, Connection c)throws SQLException;
	 void insertEmployee(Employee emp)throws Exception ;
	 void removeEmployee(int num)throws Exception;
	 void UpdateEmployee(Employee emp)throws Exception ;
	ArrayList<Employee> selectEmployee()throws Exception ;
	Employee selectEmployee(int num)throws Exception;
		
}

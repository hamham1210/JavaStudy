package com.edu.service;

import java.util.ArrayList;


import com.edu.excepetion.DuplicateEmpIdExcetion;
import com.edu.service.excepetion.RecordNotFoundException;
import com.edu.vo.Employee;

//기능의 Template을 모아놓은 인터페이스....
public interface EmployeeListService {
	void addEmployee(Employee e) throws DuplicateEmpIdExcetion;//public abstract가 생략....
	//예외처리 시 상속 받는 부모에서도 같이 해야한다.
	void deleteEmployee(String empId) throws RecordNotFoundException;
	void updateEmployee(Employee e) throws  RecordNotFoundException;
	
	//Method Overloading
	ArrayList<Employee> findEmployees(String addr);
	void findEmployees();
}

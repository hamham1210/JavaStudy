package com.edu.test;

import com.edu.dao.EmployeeDAOImpl;
import com.edu.vo.Employee;

public class EmployeeDAOTest {

	public static void main(String[] args) throws Exception{
		EmployeeDAOImpl impl = EmployeeDAOImpl.getInstance();
	System.out.println("------------------정보 삽입----------------------");
//		impl.insertEmployee(new Employee(111,"승현",500,"서울"));
//		impl.insertEmployee(new Employee(222,"유리",600,"서울"));
//		impl.insertEmployee(new Employee(333,"철수",600,"서울"));
//		impl.insertEmployee(new Employee(444,"인수",600,"서울"));
	System.out.println("------------------정보 삭제----------------------");
//		impl.removeEmployee(111);
	System.out.println("------------------정보 업데이트----------------------");
//		impl.UpdateEmployee(new Employee(111,"james",400,"NY"));
	System.out.println("------------------정보 조회----------------------");
//		impl.selectEmployee();
		impl.selectEmployee(111);
	}
	
	

}

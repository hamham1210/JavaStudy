package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{

	
	public Manager() {
		super();//부모클래스의 기본생성자를 가르킴.
//		public Employee(); 
	}
	private String dept;
	
	public Manager(String name, double salary, MyDate mydate,String dept) {
		super(name,salary,mydate);//부모 접근할 때
		this.dept = dept;//자식에서 접근할 때
	}
	
	public String getDetails() {
		//상속에서 선언부는 못 고치고 구현부만 변경함...Method Overriding
		return super.getDetails()+","+ dept;
	}
	
	public void manage() {
		System.out.println("매니저...");
	}
}

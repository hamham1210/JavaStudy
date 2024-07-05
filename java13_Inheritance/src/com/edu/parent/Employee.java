package com.edu.parent;

import com.edu.util.MyDate;

//부모 클래스
public class Employee {

	private String name;
	private double salary;
	private MyDate mydate;
	
	public Employee() {}
	public Employee(String name, double salary, MyDate mydate) {
		this.name = name;
		this.salary = salary;
		this.mydate = mydate;
	}
	public String getDetails() {
		return name+","+salary+","+mydate;
	}
	
}

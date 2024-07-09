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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public MyDate getMydate() {
		return mydate;
	}
	public void setMydate(MyDate mydate) {
		this.mydate = mydate;
	}
	public String getDetails() {
		return name+","+salary+","+mydate;
	}
	
}

package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeManager {
	private static final int MAX_EMPLOYEES = 10;
	private Employee[] emps;
	private int currentEmps;s
	
	static private EmployeeManager service = new EmployeeManager();//1
	private EmployeeManager() {
		emps = new Employee[MAX_EMPLOYEES];
		currentEmps = 0;
	}//2
	
	public static EmployeeManager getInstance() { //3
		return service;
	}
	
	public Employee[] findEmployee() {
		return emps;
	}
	
	public Employee findEmployee(int empno) {
		
		return null;
	}
	
	public Employee[] findEmployee(String addr) {
		Employee[] result = new Employee[MAX_EMPLOYEES];
		int index = 0;

		for (Employee e : emps) {
			if (e == null)
				break;
			if (e.getAddr().equals(addr))
				result[index++] = e;
		}

		return result;
	}
	
	public void addEmployee(Employee e) {
			
	}

	public int getTotalCost() {
		int total = 0;
		for (Employee e : emps) {
			if (e == null)
				break;
			total += getAnnualSalary(e.getEmpId());
		}
		return total;
	}
	
	public int getAnnualSalary(int empId) {		
		int annualSalary  = 0;
		for(Employee e : emps) {
			if(e.getEmpId() == empId) {
				annualSalary+= e.getSalary() * 12;
				if(e instanceof Engineer)
					annualSalary += ((Engineer)e).getBonus();
				
				break;
			}			
		}//for		
			
		return annualSalary;
	}
	
	public String getJob(Employee e) {
		
		return "";
	}
	
}






































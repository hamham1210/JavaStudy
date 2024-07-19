package com.edu.service;

import com.edu.vo.Employee;

//Template 기능 만으로 구성된 클래스...
public interface EmployeeService {
	 Employee[ ] getAllEmployee(Employee[ ] ea);
	 Employee findEmployee(Employee[ ] ea, int empId);
	 Employee[ ] findEmployee(Employee[ ] ea, String addr);
	 int getAnnualSalary(Employee e);
	 int getTotalCost(Employee[ ] ea);
}

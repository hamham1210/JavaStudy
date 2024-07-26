package com.edu.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmployeeServiceTest {

	public static void main(String[] args) {
	
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1,"SCOTT",30000.0));
		employees.add(new Employee(2,"ADAMS",25000.0));
		employees.add(new Employee(3,"SMITH",21000.0));
		employees.add(new Employee(4,"KING",50000.0));
		
		EmployeeService service = new EmployeeService();
		
		Consumer<Employee> consumer  = i ->{
			i.setSalary(i.getSalary()*1.15);
		};
		service.raiseSalary(consumer.andThen(System.out::println), employees);
	}
	
	
}

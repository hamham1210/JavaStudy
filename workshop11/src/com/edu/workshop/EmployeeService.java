package com.edu.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmployeeService {
	
	public static void raiseSalary(Consumer<Employee> c,List<Employee> list) {
		for(Employee e : list) {
			c.accept(e);
		}
}
}

package com.edu.test;

import com.edu.service.EmployeeManager;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeManagerTest {
	public static void main(String[] args) {	
		EmployeeManager service= EmployeeManager.getInstance();
	
		Employee m = new Manager(1234, "AAA", "천호동", 320, "개발부");
		Employee eg = new Engineer(5566, "BBB", "판교", 100, "JAVA", 500);
		Employee eg1= new Engineer(7090, "CCC", "판교", 400, "NodeJS", 50);
		Employee s= new Secretary(7369,"DDD", "상일동", 450, "AAA");
		//각각의 객체 생성
		service.addEmployee(m);
		service.addEmployee(eg);
		service.addEmployee(eg1);
		service.addEmployee(s);
		//Employee배열 안에 위에서 생성한 객체 주입
		System.out.println("===== 전체 사원 검색 =====");
		
		Employee[] employees = service.findEmployee();
		//employees안에 위에 넣었던 객체 값을을 리턴함
		for (Employee e : employees) {
			if (e == null)break;
			//employees를 for문으로 돌리고 Employee객체들로 하나씩 프린트함.
			System.out.println(e);
		}
		System.out.println();

		// 사번 사원 검색
		System.out.println("===== 사번이 5566인 사원 검색 =====");
		System.out.println(service.findEmployee(5566));
		System.out.println();
		
		// 주소가 천호동인 사원 검색
		System.out.println("===== 주소가 천호동인 사원 검색 =====");
		Employee[ ] empaddr = service.findEmployee("천호동");
		for (Employee e : empaddr) {
			if (e == null)
				break;
			System.out.println(e);
		}
		System.out.println();
		
		// 총 인건비 조회
		System.out.println("===== 총 인건비 조회 =====");
		System.out.println(service.getTotalCost()+" 만원");
		
		// 연봉 조회
		System.out.println("===== 연봉 조회 =====");
		System.out.println(service.getAnnualSalary(1234)+" 만원");
		System.out.println(service.getAnnualSalary(7090)+" 만원");

	}
}























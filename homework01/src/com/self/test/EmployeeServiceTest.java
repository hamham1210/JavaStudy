package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Engineer;
import com.self.vo.Manager;

import java.util.Scanner;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성

		
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		EmployeeService.getInstance().addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		EmployeeService.getInstance().addEmployee(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		EmployeeService.getInstance().addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		EmployeeService.getInstance().addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		EmployeeService.getInstance().printManagers();
		
		System.out.println("\n============ 1. addEngineer ============ ");
		EmployeeService.getInstance().addEmployee(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		EmployeeService.getInstance().addEmployee(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		EmployeeService.getInstance().addEmployee(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		EmployeeService.getInstance().printEngineers();
		
		System.out.println("\n============ 2. deleteManager(AAA 삭제) ============ ");
		EmployeeService.getInstance().deleteEmployee("EEE");
		System.out.println("============ Manager 정보확인 ============ ");
		EmployeeService.getInstance().printManagers();
		EmployeeService.getInstance().printEngineers();
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350) ============ ");
//		Scanner in = new Scanner(System.in);
//		System.out.println("검색할 사원의 이름을 입력해주세요.");
//		String scname = in.next();
//		System.out.println("수정할 사원의 상세정보를 입력해주세요.");
//		System.out.println("이름,생년월일,연봉,부서,보너스");
//		String name = in.next();
//		int year = in.nextInt();
//		int month = in.nextInt();
//		int day = in.nextInt();
//		double salary = in.nextInt();
//		String dept = in.next();
//		int deptno = in.nextInt();
//		Manager must = new Manager(name,new MyDate(year,month,day),salary,dept,deptno);
//		EmployeeService.getInstance().updateEmployee(must, name);
		
		
		System.out.println("============ Manager 정보확인 ============ ");
		EmployeeService.getInstance().printManagers();

		System.out.println("\n============ 4. findManager(BBB) ============ ");
		Manager retM1=EmployeeService.getInstance().findManager("BBB");
		Engineer reE1 = EmployeeService.getInstance().findEngineer("EEE");
		System.out.println(retM1.toString());
		System.out.println(reE1.toString());
		
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		Manager[ ] retMs1 = EmployeeService.getInstance(). findEmployee(10);
		for(Manager m : retMs1) {
			if(m==null) continue;
			System.out.println(m);
		}
		System.out.println("\n============ 5.직원 총급여 ============ ");
		EmployeeService.getInstance().salaryAverege();

		System.out.println("\n============ 5.이달의 생일자 ============ ");
		EmployeeService.getInstance().birthdayMonth(3);
	}
}








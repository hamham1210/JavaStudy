package com.edu.overloaing.test;

public class OverloadingTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(7369,"SCOTT",30000.0,"Texas");
		Employee e2 = new Employee(7521,"SCOTT",30000.0,"Texas");
		/*
		 * 생성자 오버로딩
		 * 필수정보만으로 객체생성을 할 수 있어야한다.
		 * 객체를 생성할때 인자값을 달리 입력해서 객체를 생성하는 기법
		 */
		Employee e3 = new Employee(7899,"BLAKE");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

}


//vo class... table... mapping
class Employee{
	private int empno;
	private String name;
	private double salary;
	private String address;
	
	Employee(){}//모든 클래스에서는 기본 생성자 하나가 있다.
	public static final double BASIC_SALARY = 100.0;
	public static final String BASIC_ADDR = "NY";//기본값
	public Employee(int empno, String name, double salary, String address) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	/*
	 * 
	 * this 키워드
	 * 1) this.empno = enmpoa;
	 * -->필드와 로컬변수의 이름이 같을 때 둘을 구분하기 위해서 필드 앞에 지정
	 * 
	 * 2) this(empno,name,BASIC_SALARY,BASIC_ADDR);
	 * --> 생성자 앞의 this는 같은 클래스 내에서 또 다른 생성자(인자값이 꽉찬 명시적 생성자)를 호출 할 때 사용
	 */
	
	public Employee(int empno, String name) {
		this(empno,name,BASIC_SALARY,BASIC_ADDR);
	}
	public String toString() {
		return empno +","+name+","+salary+","+address;
	}
}

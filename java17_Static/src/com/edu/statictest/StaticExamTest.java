package com.edu.statictest;
/*
 * static 키워드 특징
 * 1. static한 성질의 멤버는 객체생성 과정없이 메모리로 올라간다.
 * 2. compile | runtime(v)
 * 	static한 성질의 멤버는 class file loader단계에서 미리 메모리 올라간다.
 * 3. 클래스이름, static멤버
 * 	System.out
 * 	System.in
 * 	Integer.parseInt()
 * 	EmployeeService.getInstance()
 * 	Math.random
 * main()
 * 4. static한 멤버는 생성된 객체들이 다 공유되는 성질의 것이다.
 * 5. Member
 */
public class StaticExamTest {

	public static void main(String[] args) {
		
		Member m = new Member();
		System.out.println(Member.name);
		Member.memberInfo();

	}

}

class Member {
	int ssn = 1234;
	static String name ="길동";
	static int age = 19;
	
	public static void memberInfo() {
		System.out.println("우유빛깔"+name);
	}
}

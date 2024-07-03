package com.edu.oop.test;

import com.edu.oop.Greet;

//Test 클래스는 실행 대상이 된다.
/*
 1. Greet클래스를 메모리에 올리고 == 객체생성
 2. 멤버에 접근
 	 필드 --> 값할당
 */

public class GreetAppTest {

	public static void main(String[] args) {
		Greet g = new Greet();
		g.who = "코스타";
		g.message = "자바교육";//값 할당
		
		g.sayHello();//호출
		
	}

}

package com.edu.statictest;
/*
 * main 실행 --->
 * 객체생성 == 필드 initialization
 * 
 * Gobal initialization - main- 생성자 생성- 객체 생성- 필드 initialization
 */
public class StaticExamTest3 {
	static int i;
	public static void main(String[] args) {
		System.out.println("1. main method block......"+i);

	}//main

	//static initialization block (static 초기화 블럭)
	static {
		i = 300;
		System.out.println("2. static block......"+i);
	}
}//class
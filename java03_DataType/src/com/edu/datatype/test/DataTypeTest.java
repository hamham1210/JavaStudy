package com.edu.datatype.test;

public class DataTypeTest {

	public static void main(String[] args) {
		float salary = 100;
		System.out.println(salary);
		//long, float, double 은 값 뒤에 데이터 타입이 정해진 값이다.
		float salary1 = 100.0f;
		//실수의 기본은 double 이므로 float 을 쓸 경우는 데이터 타입을 정해줘야한다. 
		long salary2 = 100000000000000l;
		//정수의 기본은 int 이므로 long 을 쓸 경우는 데이터 타임을 long 으로 정해줘야한다.
		System.out.println(salary1);
		System.out.println(salary2);
		
		short a,b;
		a = 1;
		b = 2;
		//int를 제외한 다른 데이터 타입으로 사칙연산을 할 경우 해당 데이터 타입은 int로 승격된다.
		short c = (short) (a+b);
		System.out.println(c);
		
		
		System.out.println("============================================");
		
		int x = 24;
		byte e = (byte) x;
		byte n = 24;
	}

}

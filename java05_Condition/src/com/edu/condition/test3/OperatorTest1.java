package com.edu.condition.test3;

public class OperatorTest1 {
	
	public static void main(String[] args) {
		
		int i = 5;
		int j = 3;
		
		//% ...mod ... 나머지
		System.out.println("연산자 % : " + i%j);
		System.out.println("연산자 / : " + i/j);
		
		int n = 98;
		
		System.out.println(n/10);
		System.out.println(n%10);
		
		int k = 10;
		System.out.println(k++);
		System.out.println(k);
		System.out.println(++k);
		System.out.println(k);
		
		Operator2 o3 = new Operator2();
		System.out.println(o3);
		System.out.println(o3.test1() | o3.test2());
		String msg1 = "Hello";
		String msg =  "Hello";
		System.out.println("====================String equals=================");
		System.out.println(msg1.equals(msg));//truec

		
		
	}
	
}

	// 하나의 파일에 여러개의 클래스를 함께 작성 할 때 방법



class Operator {

	public boolean test1() {
		System.out.println("test1( calling....");
		return true;
		
	}
	public boolean test2() {
		System.out.println("test2( calling....");
		return true;
		
	
	}
}
	class Operator2 {

		public boolean test1() {
			System.out.println("test1( calling....");
			return true;
			
		}
		public boolean test2() {
			System.out.println("test1( calling....");
			return true;
		}
		
	}
	


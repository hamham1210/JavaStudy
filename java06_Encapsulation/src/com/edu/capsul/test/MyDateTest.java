package com.edu.capsul.test;

import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md = new MyDate();

		Scanner in = new Scanner(System.in);
		int month = in.nextInt();
		int day = in.nextInt();
		md.setMonth(month);
		md.setDay(day);
		System.out.println("Today is " + md.getMonth() + " 월" + md.getDay() + "일 입니다.");
		// 정보가 다른 클래스로 직접적으로 꼿히는 것을 막기 위해서 하는 것이 encapsulation(캡슐화)
		/*
		 * 1.필드 앞에 ------> private (다른 클래스에서 접근이 안되도록 막아둔다.
		 * 
		 * 2.set 메소드/get 메소드 ------->public
		 * 
		 * 3.set 메소드 구현부 안에서 필드 초기화 직전에 타당한 값만 필드에 할당되도록 문장을 제어 할 수 있다.
		 */
		/*
		 * 접근지정자, Access Modifier
		 * public(어디서든 접근허용) > Protected > default(제어자 없음: 같은 패키지 안에서 접근 허용)>private(해당 클래스에서만 접근허용)
		 */
	}

}

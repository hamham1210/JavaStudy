package com.edu.condition.test2;

import java.util.Random;

public class NoBreakSwitchTest2 {

	public static void main(String[] args) {
		//8-11 사이의 임의의 값이 할당되도록 로직을 작성
		
		Random random = new Random();
		int time = random.nextInt();
		
		

		switch (time) {
		case 8: 
			System.out.println("출근 준비를 합니다.");
		case 9: 
			System.out.println("회사 도착");
		case 10: 
			System.out.println("오전 업무");
		case 11: 
			System.out.println("외근 준비");
		default:
			System.out.println("점심시간");
		}

}
}
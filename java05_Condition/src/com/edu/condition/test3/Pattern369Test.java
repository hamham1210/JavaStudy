package com.edu.condition.test3;

import java.util.Scanner;

public class Pattern369Test {
	
public static void solv(int number) {
	
	int ten = (number/10)%3;
	int one = (number%10)%3;
	

	if(ten == 0 && one == 0) {
		System.out.println("@@");
	}
	else if(ten == 0 || one == 0) {
		System.out.println("@");
	}
	else {
		System.out.println(number);
	};
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("두 자리 숫자를 입력하세요.");
		int num = in.nextInt();
		solv(num);
		
		
			
	}

}

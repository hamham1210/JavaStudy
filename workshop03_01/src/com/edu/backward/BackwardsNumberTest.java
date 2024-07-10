package com.edu.backward;

import java.util.Scanner;

public class BackwardsNumberTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		do{
		System.out.println("1 이상의 숫자를 입력하세요.");
		int input = in.nextInt();
		int i = 1;
		if(input >= 1) {
		do {
			System.out.println(i);
			i++;
		
		}while(i <= input);
		System.exit(0);
		}
		else {System.out.println("입력값을 다시 확인하세요.");}
		}while(true);
		
	
	}
}

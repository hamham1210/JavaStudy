package com.edu.condition.test3;

import java.util.Scanner;

/*
 * switch(조건에 해당하는 변수){
 * case 95:
 * case 90:
 	//실행문
 	 break;
 	 
 	case 80;
 	case 85;
 	//실행문
 	break; switch 문을 나가는 키워드
 	---------------------------case는 if문에서 if에 해당함
 	defualt:
 	//실행문
 	--------------------------defualt는 if문에서 else에 해당한다.
 * }
 */
public class GradeSwitchTest3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int grade = 90;
		switch (grade) {
		case 90: 
		case 95: 
			System.out.println("A grade");
			break;
		case 80: 
		case 85: 
			System.out.println("B grade");
			break;
		case 70: 
		case 75: 
			System.out.println("C grade");
			break;
		
		default:
			System.out.println("Nuts");
		}
	}

}

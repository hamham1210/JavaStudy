package com.edu.condition.test2;

import java.util.Random;
import java.util.Scanner;

/*
 * static 한 기능을 가지고 있는
 * Math 클래스의 메소드 random()을 사용
 */
public class DIceIfTest1 {

	

	public static void main(String[] args) {
		//num이라는 변수에 1-6사이의 임의의 값이 할당되도록 로직을 작성
		Random random = new Random();
		int num = random.nextInt(7);
		System.out.println(num);
		
		if(num == 1) System.out.println("Dice1");
		if(num == 2) System.out.println("Dice2");
		if(num == 3) System.out.println("Dice3");
		if(num == 4) System.out.println("Dice4");
		if(num == 5) System.out.println("Dice5");
		else System.out.println("Dice6");
	}

}

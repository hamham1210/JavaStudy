package com.edu.condition.test3;

import java.util.Scanner;

public class CatchAMouseTest {
	public static String solv(int a, int b, int c) {
		if(Math.abs((c-a)) < Math.abs((c-b))) {
			System.out.println("Catch A Mouse");
		}
		if(Math.abs((c-a)) > Math.abs((c-b))) {
			System.out.println("Catch B Mouse");
		}
		if(Math.abs((c-a)) == Math.abs((c-b))) {
			System.out.println("Mouse Esacpe!");
		}
		return"";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int catA = in.nextInt();
		int catB = in.nextInt();
		int mouse = in.nextInt();
		
		String result = solv(catA, catB, mouse);
		System.out.println(result);
		
		in.close();
}

	
	
}

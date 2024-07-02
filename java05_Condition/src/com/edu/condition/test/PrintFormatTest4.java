package com.edu.condition.test;

import java.util.Random;

//Fromating 출력하기 | 삼항 연산자
public class PrintFormatTest4 {

	public static void main(String[] args) {
	 Random r = new Random();
	 String result = "";
	 
	 System.out.println("========================================================");
	 
		int num = r.nextInt(100);
		if (num > 50) {
			result = "큰수";
		} else {
			result = "작은수";
		}
		System.out.println(num + " 은 "+ result+" 이다 ");
		System.out.printf("%d은(는) %s이다" ,num,result);
		
		System.out.println("================== 짝수? 혹은 홀수 ======================");
		
		int num2 = r.nextInt(10); //0-9 임의의 정수
//		if(num2 % 2 == 0) {
//			result ="짝수";
//		}else {result ="홀수";
//	}
		result=(num2 % 2 == 0) ? "짝수" : "홀수";//삼항 연산자
		System.out.printf("%d은(는) %s이다" ,num2,result);

}
}

package com.edu.loop.test;
/*
 * 반복문을 이용해서 1-10까지의 총합을 구하는 로직 생성
 * 2. 반복문 안에서 조건 하나 추가
 * sum이 500을 넘으면 반복만 멈추고 빠져나가도록..
 */
public class LoopingBreakTest2 {

	public static void main(String[] args) {
		int sum = 0;//for 바깥
		for (int i = 1; i<=100; i++) {
			sum += i;
			if(sum>500)break;
		}
		System.out.println("총합 : " + sum);

	}

}

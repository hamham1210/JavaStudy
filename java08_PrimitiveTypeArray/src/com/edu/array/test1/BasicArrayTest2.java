package com.edu.array.test1;

/*
 * 배열 : Same Data Type
 * 1) 선언 
 * 2) 생성 --- 반드시 배열의 사이즈를 명시
 * 3) 초기화
 */
public class BasicArrayTest2 {

	public static void main(String[] args) {
		// 1) 선언 + 2) 생성(size 명시 필수)
		int[] arr = new int[3];
		
		// 3) 명시적 초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		


		for (int i = 0; i < arr.length; i++)
			//array는 class가 제공되지 않는 유일한 객체로 array는 legth로 사이즈를 알 수 있다.
			System.out.println(arr[i] + "");
	}

}

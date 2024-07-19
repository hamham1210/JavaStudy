package com.edu.array.test1;

/*
 * 배열
 * 1) 선언 
 * 2) 생성 --- 반드시 배열의 사이즈를 명시
 * 3) 초기화
 */
public class BasicArrayTest1 {

	public static void main(String[] args) {
		// 1) 선언
		int[] arr;

		// 2) 생성
		arr = new int[3];// 3칸 짜리 배열을 만들었다.
		System.out.println("배열 Container 주소값 :: " + arr);
		System.out.println("\n================배열 안의 각각의 요소==========================");

		for (int i = 0; i < 3; i++)
			System.out.println(arr[i] + "");

		// 3)초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		System.out.println("\n================배열 안의 각각의 요소==========================");

		for (int i = 0; i < 3; i++)
			//array는 class가 제공되지 않는 유일한 객체로 array는 legth로 사이즈를 알 수 있다.
			System.out.println(arr[i] + "");
	}

}

package com.edu.collection1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Map
 * |
 * HashMap
 * key(중복안됨)- value(중복가능)쌍으로 저장
 * 순서 없다.
 * 
 */
public class HashMapTest2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("강호동", 90);//Boxing
		map.put("이수근", 80);
		map.put("서장훈", 95);
		map.put("김희철", 80);
		 int total = 0;
		for(String key : map.keySet()) {
		 int score = map.get(key);
		 total += score;
		};
			System.out.println("모든 사람들의 성적의 총합은"+total+"점입니다.");
			System.out.println("모든 사람들의 성적의 평균은"+total/map.size()+"점입니다.");
		/*
		 * 1. 키캆을 뽑아서
		 * 2. 반복문을 통해서 키캆에 해당하는 점수를 뽑고
		 * 3.최종적으로 모든 성적의 합과 평균을 구하라
		 */
			System.out.println("===========valus()===============");
			int sum = 0;
			for(int v : map.values())sum+= v;
			System.out.println("모든 사람들의 성적의 총합은"+sum+"점입니다.");
			System.out.println("모든 사람들의 성적의 평균은"+sum/map.size()+"점입니다.");
			
			System.out.println("===========Collection===============");
			System.out.println(Collections.max(map.values())+"점입니다.");
			System.out.println(Collections.min(map.values())+"점입니다.");
			
			
	}

}

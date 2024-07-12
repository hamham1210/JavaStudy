package com.edu.collection2;

import java.util.Collections;
import java.util.HashMap;

import com.edu.vo.Customer;

public class HashMapTest3 {

	public static void main(String[] args) {
		
		HashMap<String, Customer> map = new HashMap<>();
		
		map.put("111", new Customer("111",111,"AAA"));
		map.put("222", new Customer("222",222,"BBB"));
		map.put("333", new Customer("333",333,"CCC"));
		
		//1. map에 들어 있는 사람 중에서 222찾기
		System.out.println(map.get("222"));
		
		//2. 이름이 CCC인 사람을 찾아서 그 사람의 나이를 콘솔로 출력
		for(Customer c : map.values())
			if(c.getName().equals("CCC"))
				System.out.println("CCC님의 나이는"+ c.getAge());
		
		//3.map에 있는 사람 중에서 최고연령과 최소연령의 사람을 각각 출력
		int max = 0;
		int min = 0;
		for(int i = 0;i<map.size();i++) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		
		System.out.println(min);
		System.out.println(max);
		
	}

}

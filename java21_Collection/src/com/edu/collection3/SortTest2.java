package com.edu.collection3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortTest2 {

	public static void main(String[] args) {
		System.out.println("Map정렬하기");
		System.out.println("====key값을 기준으로 정렬=====");
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		map.put(1, 10);
		map.put(11, 500);
		map.put(7, 300);
	
		ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			
			}});
		System.out.println(keyList);
		
		System.out.println("====value값을 기준으로 정렬=====");
		
		
	}

}

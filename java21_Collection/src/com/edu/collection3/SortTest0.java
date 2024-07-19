package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortTest0 {

	public static void main(String[] args) {
		System.out.println("List 정렬하기");
		
		List<Integer> list = new ArrayList();
		
		list.add(11);
		list.add(9);
		list.add(3);
		list.add(33);
		
		System.out.println(list);
		System.out.println("============ 오름차순 정렬 ============");
		Collections.sort(list);
		
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("============ 내림차순 정렬 ============");
		Collections.sort(list,new Comparator<Integer>() {
			//comparator는 interface고 익명의 함수가 상속받아서 구현되었기 때문에 Comparator를 객체생성으로 쓸 수 있다.
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;//큰수 - 작은수... 양수... 내림차순 정렬
			}
		});
		//내림차순
		Iterator<Integer> it2 =list.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
	}

}

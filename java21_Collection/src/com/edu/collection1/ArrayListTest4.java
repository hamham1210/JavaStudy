package com.edu.collection1;

import java.util.ArrayList;
import java.util.List;

/*
 * List
 * 순서를 가지면서 데이터를 핸들링하는 컬렉션
 * 순서를 가진다는 것은 내부적으로 index로 관리하는 시스템을 말한다.
 * 순서가 있고 중복은 허용한다.
 */
public class ArrayListTest4 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("서장훈");
		list.add("이수근");
		list.add("김희철");
		list.add("강호동");
		
		System.out.println(list);
		//1. 5번째 객체를 삭제
		String delName = list.remove(4);
		
		//2. "삭제된 사람은 ~~입니다를 출력
		System.out.println(delName);
		//3. 맨 처음 민경호를 추가
		list.add(0,"민경호");
		list.set(0, "신동");
		System.out.println(list);
		//4. 멤버들 중에서 서.. 자로 시작하는 사람을 찾아서 해당 정보를 출력
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).startsWith("서")) {
				System.out.println(list.get(i));
			}
		}
	}

}

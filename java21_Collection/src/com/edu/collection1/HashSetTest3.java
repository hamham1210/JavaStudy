package com.edu.collection1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest3 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("강호동");
		set.add("서장훈");
		set.add("이수근");
		set.add("김희철");
		set.add("강호동");
		System.out.println(set.size()+"명입니다.");//4
		System.out.println(set.toString());//Collection은 기본적으로 toString해준다. 바로 값이 출력되도록한다.
		
		//1.서장훈 씨가 포함되어져 있는지 확인..
		boolean flag =  set.contains("서장훈");
		System.out.println(flag);
		//2. 현재 Collection 안에 여부도 확인
		System.out.println(set.isEmpty());
		//3. 이수근 삭제 및 나머지 사람들 출력
		set.remove("이수근");
		System.out.println(set);
		//4. set 안에 들어 있는 모든 데이터를 삭제
		set.clear();
		//5. 정말로 비워졌는지 확인
		System.out.println(set.isEmpty());
	}

}

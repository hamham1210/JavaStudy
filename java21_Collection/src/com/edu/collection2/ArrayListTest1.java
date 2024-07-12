package com.edu.collection2;

import java.util.ArrayList;

import com.edu.vo.Person;

public class ArrayListTest1 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();//기본 10칸짜리 리스트
		//Generic (제너릭) List 안에 저장된 객체의 타입을 알려주는 역할
		//add
		list.add(new Person(11,"AA"));
		list.add(new Person(22,"BB"));
		list.add(new Person(33,"CC"));
		list.add(new Person(44,"DD"));
		list.add(new Person(55,"EE"));
		
		System.out.println(list);//toString이 생략되어 있어서 값이 나옴
		System.out.println(list.size());
		list.trimToSize();//사이즈와 Capacity 가 동일해진다.
		
		//list에 있는 사람 중에서 2번째 사람의 정보를 출력
		
		Person secondPerson =list.get(1);//해당 인덱스에 있는 객체를 가져오는 기능
		//Person secondPesrson (Person)list.get(0); 제네릭을 설정 시 Object Casting x
		//ArrayList는 어떤 값이든 다 들어간다.
		//list에 있는 사람들의 평균 나이를 구해보기
		int sum = 0;
		for(Object o : list) {
			 sum +=((Person) o).getAge();
			 
			 System.out.println("평균연령은 "+sum/list.size());
		}
	}

}

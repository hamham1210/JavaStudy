package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edu.collection2.ArrayListTest1;


public class SortTest3 {
	public static void main(String[] args) {
		//1.String 정렬
		List<String> names = new ArrayList<>();
		names.add("루시");
		names.add("아담스");
		names.add("줄리엣");
		names.add("밥");
		
		System.out.println("정렬 전 =====>"+names);
		Collections.sort(names);
		System.out.println("정렬 후 =====>"+names);
		
		//2.Person 클래스의 age순으로 정렬... Comparator방식
		List<Person> people = new ArrayList<Person>();
		people.add(new Person(11,"루시"));
		people.add(new Person(22,"아담스"));
		people.add(new Person(10,"줄리엣"));
		people.add(new Person(7,"밥"));
		//클래스 타입은 안에 객체로 정렬이 불가해서Comparator방식으로 정렬
		
		System.out.println("정렬 전 =====>"+people);
		/*
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
			
				return o1.getAge()-o2.getAge();
			}
		});//안 먹힌다...Person클래스는 Comparable 인터페이스 상속 안 받고 있다.
		*/
		Collections.sort(people);
		System.out.println("정렬 후 =====>"+people);
		
		
	}
}

//3. Comparable 상속...
class Person implements Comparable<Person>{
	private int age;
	private String name;
	
	public Person() {}
	public Person(int age, String name) {
	
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Person p) {
		
		return -name.compareTo(p.getName());//오름차순 -붙이면 내림차순
	}
}
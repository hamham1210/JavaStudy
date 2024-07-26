package test1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(100,45,200,30,44,3,1,99);
		//1. 익명클래스 사용
		/*
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		System.out.println(list);
		*/
		//2. 람다식 사용
		//Comparator에 있는 추상메소드를 상속받아서 구현하는 것이다.
		Collections.sort(list,(o1,o2)->o2-o1);
		System.out.println(list);
		
	}

}


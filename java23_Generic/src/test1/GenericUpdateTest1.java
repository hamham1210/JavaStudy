package test1;

import java.util.ArrayList;
import java.util.List;

/*
 * 해당 코드에서는 Generic기법을 사용
 * 1. 뭐든지 담을 수 있다...Box에
 * 2. 꺼낼때 Object casting을 해주지 않아도 된다.
 */
//class Box<T>{//T라는 클래스는 실제로 존재하지 않지만 Type을 의미한다.
//	T content; //Box엔, T타입의 내용물이 담겨진다.T타입은 나중(객체 생성 시, 사용 시)에 구체적인 타입으로 대체된다.
//	
//	public T selectContent() {
//		return content;
//	}
//	
//	
//}
//public class GenericUpdateTest1 {
//	public static void main(String[] args) {
//		Box<String> box = new Box<>();
//		box.content = "곰인형";
//		
//		String bear = box.selectContent();
//		System.out.println("담겨진 것은 "+bear);// Object casting을 할 필요없다.
//		
//		List<Integer> list = new ArrayList<>();
//		list.add(10);//Auto Boxing
//		list.add(20);
//		list.add(30);
//	
//		System.out.println(list);//UnBoxing
//	}
//}


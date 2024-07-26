package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Collection :: 객체를 저장하는 방법론
 * List |Map|Set| Iterable
 * 
 * 8버전 이후에 함수형 인터페이스를 Hasing하면서 제공되는 기능 추가.
 * 
 * Collection : boolean removeIf(Predicate)
 * List : void replaceAll()
 * Map : compute(),forEach(),merge()
 * */
public class FunctionalTest3 {

	public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	for(int i =0; i<10;i++) list.add(i);
	//Map 생성
	Map<Integer,String> map = new HashMap<>();
	map.put(111, "SCOTT");
	map.put(222, "BLAKE");
	map.put(333, "KING");
	
	
	//1.리스트에 담긴 객체를 뽑아서 정보 출력
//	Iterator<Integer> it = list.iterator();
//	while(it.hasNext()) {
//		System.out.println(it.next());
//	}
	System.out.println("1.리스트에 담긴 객체를 뽑아서 정보를 출력 ===> forEach");
	//forEach는 뽑아내서 출력만 하지 수정 기능은 없어서 Consumer를 쓴다.
	list.forEach(i-> System.out.print(i+" "));
//	list.forEach(System.out::print);위와 동일한 기능을 한다.
	
	//2. list에 담긴 값 중에서 2의 배수 혹은 3의 배수를 제거한 후 출력...removeIf(P)
	
	list.removeIf(i-> i%2==0||i%3==0);
	System.out.print(list);
	//3. list에 모든 값들을 10 곱한다.====>replaceAll()
	list.replaceAll(i -> i*10);
	System.out.println(list);
	//2.맵에 담긴 객체를 뽑아서 정보 출력
	System.out.println("--------------------------map--------------------------");
	System.out.println("\n4. Map에 있는 모든 key, value 값을 출력 ====> iterator()");
	Iterator<Integer> it = map.keySet().iterator();
	
	while(it.hasNext()) {
		int key = it.next();
		System.out.println("key :" + key + ","+"value : " + map.get(key));
	}
	System.out.println("\n5. Map에 있는 모든 key, value 값을 출력 ====> forEach()");
	
	map.forEach((i,s) -> System.out.println(i+s));
	}
	
}

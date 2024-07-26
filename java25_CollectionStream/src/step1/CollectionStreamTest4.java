package step1;
/*
 * 스트림 만드는 작업과정
 * 
 * 1. 스트림 생성
 * 2. 중간연산자
 * 3. 최종연산자
 * */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest4 {

	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> intStream = list.stream();
		
		
		
		intStream.forEach(System.out ::print);
		
		System.out.println();
		
		intStream = list.stream();// 추가 .. 다시 스트림을 연다.
		intStream.forEach(System.out ::print);//Error난다.. 이미 닫혔다. (위에서 최종연사을 이미 했다.}
		
		System.out.println("--------------------------------------------------------------");
		//Stream<T>
		Stream<Integer> intStream2 = Stream.of(1,2,3,4,5);
		System.out.println("intStream2 count :" + intStream2.count());
//		System.out.println("intStream2 count :" + intStream2.sum()); sum기능은 IntStream에만 있다.
		
		System.out.println("--------------------------------------------------------------");
		//IntStream
		
		int[] inArr = {1,2,3,4,5};
		
		IntStream intStream3 = Arrays.stream(inArr);
		
//		intStream3.forEach(System.out ::print);
//		System.out.println(intStream3.sum());
//		System.out.println(intStream3.average());
		System.out.println(intStream3.findFirst());
	}
}

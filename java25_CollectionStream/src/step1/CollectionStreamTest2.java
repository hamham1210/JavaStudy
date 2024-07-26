package step1;
/*
 * Stream의 특징
 * 1.Read Only -스트림은 데이터 소스로 부터 데이터를 읽어들이기만 할 뿐 변경하지 않는다.
 * 2.일회용이다. - Iterator처럼 일회용이다.최종연산이 진행되면 닫힌다.(필요하면 다시 생성해서 사용)
 * 3.최종연산 전까지 스트림의 중간연산이 수행되지 않는다. - 지연된 연산
 * 4.병렬처리 작업이 가능하다 - 멀티 쓰레드 지원
 * FP(함수형 언어)는 빅데이터(대용량 작업)를 빠르게 처리하기 위해서 발전되어온 기술이다.AI와 함께 발전
 * 그러기 위해서는 직렬적 작업보다는 병렬작업으로 많은 량의 데이터를 효율적으로 처리하는 기술이 필수
 * 5.Stream<T> VS IntStream
 * 				  DoubleStream
 * 				  LONGStream
 * 				  FloatStream
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest2 {

	public static void main(String[] args) {
		//1.문자열 리스트가 소스인 스트림을 생성
		
		List<String> fruit = new ArrayList<>();
		
		fruit.add("Apple");
		fruit.add("Banana");
		fruit.add("Apple");
		fruit.add("Melon");
		fruit.add("Grape");
		fruit.add("Orange");
		fruit.add("Melon");
		fruit.add("Grape");
		
		System.out.println("원본 리스트1:: "+ fruit);
		Stream<String> stream= fruit.stream();//1)스트림 생성
//		stream.distinct().limit(3).sorted().forEach(i->System.out.print(i+" "));
		List<String> list= stream.distinct().limit(3).sorted().collect(Collectors.toList());
		System.out.println(list);
		
		System.out.println("\n----------------------------------------------------------");
		//2.문자열 배열이 소스인 스트림
		String[] strArr = {"dd","aaa","cc","b"};
		Stream<String> strStream = Stream.of(strArr);
		strStream.forEach(System.out::println);//여기서 이미 최종연산 진행됬다.(스트림요소를 꺼냈다.)
		
//		long count = strStream.count();
//		System.out.println("남은 데이터 갯수 " + count);//스트림이 닫혔다. 다시 사용할 수 없다.
		
		//3.
		IntStream intStream = new Random().ints(1,46);
		//	intStream.forEach(i->System.out.print(i+" ")); 무한 반복
		intStream.distinct().limit(6).sorted().forEach(i->System.out.print(i+" "));
		
		//4.
		String[] strArr2 = {"dd","aaa","cc","b"};
		Stream<String> strStream2 = Stream.of(strArr);
		//해당 작업을 병렬처리로 만들 수 있다.
		int sum = strStream2.parallel().mapToInt(s-> s.length()).sum();
		System.out.println("모든 문자열의 합은"+sum);
	}

}

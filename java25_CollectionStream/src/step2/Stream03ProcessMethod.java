package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream03ProcessMethod {

	public static void main(String[] args) {
		
		List<String> strings = List.of("I","M","A","list","String");
		
		Stream<String> stream = strings.stream();
		
		stream = stream.limit(4);
		System.out.println(stream);//안나옴 최종연산이 들어가지 않아서 데이터가 없다.
		
		//1.stream에서 첫번째 데이터를 찾아서 출력하기
//		System.out.println(stream.findFirst().get());
		
		//2. stream 안에 있는 스트링 데이터의 갯수를 출력
//		System.out.println(stream.count());
		//3. stream 안에 있는 스트링 데이터를 다 출력 forEach
//		stream.forEach(i->System.out.print(i+" "));
		//4. stream 안에 있는 스트링 데이터를 수집
		stream.collect(Collectors.toList());
	}

}



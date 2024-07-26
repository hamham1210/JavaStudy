package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream02ProcessMethod {

	public static void main(String[] args) {
		
		System.out.println("==========1.중간처리 연산자 잘못사용하는 경우==========");
		int[] intArr = {1,2,3,4,5};
		
			Arrays.stream(intArr)
			.filter(i -> i % 2==0)
			.peek(System.out :: print);
		
		
		//중간처리 연산자는 지연된 연산자 이므로 최종처리가 없다면 출력이 안된다.
//		System.out.println("Result"+ sum);
		System.out.println("\n==========1.중간처리 연산자 peek()을 제대로 사용하는 경우==========");
		
	int sum =	Arrays.stream(intArr)
		.filter(i->i%2==0)
		.peek(i->System.out.print(i+" "))
		.sum();//최종처리
		System.out.println("\nResult"+sum);
		
	}

}



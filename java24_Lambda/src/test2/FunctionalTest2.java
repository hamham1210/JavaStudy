/*
 Predicate의 결합
defualt 메소드를 사용하는 내용

and() or() negate() 2개를 사용해서 하나의 Predicate로 결합가능

 함수형 인터페이스의 구셩요소
 1)추상메소드
 2)static 메소드
 3)defualt메소드
 하지만 가장 핵심은 추상메소드이다.
 *
 *
 * */

package test2;

import java.util.function.Predicate;

public class FunctionalTest2 {

	public static void main(String[] args) {
		Predicate<Integer> p = i-> 1<100;//100보다 작은 수
		Predicate<Integer> q = i-> 1<200;//200보다 작은 수
		Predicate<Integer> r = i-> i%2==0;
		
		//defult함수의 결합.
		Predicate<Integer> notP = p.negate();//i>=100;
		Predicate<Integer> all = notP.and(q).or(r);//i>=100 && i<200|| i%2==0
		Predicate<Integer> all2 = notP.and(q.or(r));//i>=100 && (i<200|| i%2==0)
		
		
		//Predicate를 사용할때는 test()사용
		System.out.println(all.test(2));
		System.out.println(all2.test(2));
	}
	
}

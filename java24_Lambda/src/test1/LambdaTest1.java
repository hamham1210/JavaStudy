package test1;
/*
 * 람다, 람다식
 * ::
 * 함수형 프로그래밍
 * 자바는 자바8버전부터 함수형 프로그래밍인 람다식을 제공
 * ::
 * 1) 익명함수(함수명이 없다.)
 * 2) 코드가 간경하고 성능적으로 불리한 부분이 있다.
 * 3) 병렬처리 가능하다.
 * 
 * <일반함수>
public int max(int a, int b) {
	return a>b? a:b
}

<람다식>
(int a, int b) -> {return a>b? a:b;}

(int a, int b) ->  a>b? a:b ;

( a,  b) ->  a>b? a:b ;

 * */
@FunctionalInterface
interface MyFunction{//추상메소드.. 단 하나의 인터페이스
	int max(int a, int b);//2개의 수중 더 큰 수를 변환하는 기능을 Template
}

public class LambdaTest1 {

	public static void main(String[] args) {
	//1. 익명클래스로 구현(선언부가 안보인다.)
	//MyFunction f = new ?implements MyFunction() 익명 클래스가 MyFunction을 상속받아서 객체를 생성
	MyFunction f = new MyFunction() {
		@Override
		public int max(int a, int b) {
			return a>b? a:b;
		}
		
	};
	int result1 = f.max(5, 3);
	System.out.println("Result1=>"+result1);
	
	//2.람다식으로 구현(매개변수 -> 구현부)
	MyFunction f2 =(a,b) -> a>b?a:b;
	int result2 = f2.max(5,3);
	System.out.println("Result2=>"+result2);
	}

}

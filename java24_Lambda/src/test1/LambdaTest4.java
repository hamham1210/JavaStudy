package test1;
/*
 * LambdaTest2에서 기능의 매개변수로 인터페이스를 주입
 * 더 간결한 코드로 작성해보기
 *	@FunctionalInterface
 *
 *	1) 매개변수 o, 반환타입 x
 *	2) 매개변수 x, 반환타입 o
 *	3) 매개변수 o, 반환타입 o
 *	4) 매개변수 o, 반환타입 boolean
 *
 * */

@FunctionalInterface
interface Calculable{
	void calculate(int a, int b);//추상 인터페이스는 하나의 추상 메소드를 가진다. 매개변수 2, 반환타입 없음.
}

public class LambdaTest4 {

	public static void main(String[] args) {
		//1. 함수형 인터페이스를 바로 사용... 람다식
		Calculable c1 = (a,b)->System.out.println(a+b);//함수형 인터페이스 구현체
		
		c1.calculate(10, 20);
		action((a,b)->{int result = a+b;
		System.out.println("Result =>"+result);
		});
		
		action((a,b)->{int result = a*b;
		System.out.println("Result2 =>"+result);
		});//재사용성이 뛰어남. 인터페이스를 구현해두면 구현부는 재사용성이 높음.
	}//main
	//2. static 메소드의 매개변수로 Hasing
	
	public static void action(Calculable c) {
		int a = 11;
		int b = 22;
		c.calculate(a, b);
	}
	
}


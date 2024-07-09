package com.edu.statictest;
/*
 * Access Modifier ::: public < protected < private
 * Usage Modifier ::: static(고정값), final, abstract
 * 
 * static+final 주로 함께 많이 쓰인다.(순서는 중요하지 않다.)
 * 
 * final ::: "내가 마지막이야"라는 의미를 가지는 키워드
 * final + 변수 -->"내가 마지막 변수" --> 상수값 지저
 * final + 클래스 --> "내가 마지막 클래스" --> 상속 금지
 * final + 메소드 --> "내가 마지막 메소드" --> 오버라이딩 금지
 */
public class StaticExamTest4 {

	public static void main(String[] args) {
		
		System.out.println(A.BASE_SALARY);

	}

}
final class B{// 상속금지
	
}

//class C extends B{
//	
//}

class D extends A{
	
}
class A{
	public final static int BASE_SALARY = 4000;
	public final String test() {
		return "Overriding 금지";
	}
}

package test1;
/*
 * 제한된 파라미터 타입
 * ::
 * 메소드 반환 타입, 메소드 매개변수 타입으로 가능....
 * 클래스 타입에서는 적용될 수 없다.
 * ::
 * <T extends Number>
 * Number는 모든 숫자 타입
 * 
 * T에 올 수 있는 클래스 타입은 Number의 자식 클래스...
 * Long, Integer, Double, Float, Btye, Short... Number 이런 값들을 다룰때 사용된다.
*/
public class GenericTest2 {
	//제한된 파라미터 타입을 갖는 제너릭 메소드 정의
	public static <T extends Number> boolean compare(T t1, T t2) {
		
		System.out.println("compare("+ t1.getClass().getSimpleName()+","+ t2.getClass().getSimpleName()+")");
		
		double v1 = t1.doubleValue();//UnBoxing
		double v2 = t2.doubleValue();
		return (v1 == v2);
	}
	public static void main(String[] args) {
		//제한된 파라미터 타입을 갖는 제너릭 메소드 정의
		//auto Boxing..
		boolean result =compare(10, 20);
		System.out.println(result);
		//auto Boxing..
		boolean result2 =compare(4.5, 4.5);
		System.out.println(result2);
		//해당 타입이 맞이 않기 떄문에 오류가 난다.
//		boolean result3 =compare("4", "4");

	}//main

}//class
/*
 * 
 * 제한된 파라미터 타입은 메소드 매개변수나 반환값으로 사용가능
 * ?-- 			모든 클래스 사용가능(?extends Object와 동일)
 * ? super Worker Worker의 모든 상위 타입만 사용가능
 * ? extend employee employee의 모든 하위 타입만 가능
 * */



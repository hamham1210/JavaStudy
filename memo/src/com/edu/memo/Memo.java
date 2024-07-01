package com.edu.memo;

public class Memo {

	int size;
	
	class Dog{
		
		Dog(){}//기본 생성자(필드 초기화, 파라미터가 없다.)
		Dog(int s, String b, String n){// 명시적 생성자(return 타입 없음)
			//필드 초기화
			size = s;
		}
	}
	public void setDog(int s, String b, String n) {//메소드
		//필드 초기화
		size = s;
	}
	//return 타입이 존재 할 때는 메소드 아니면 생성자
	//생성자는 member 메모리에 올라가는 구성요소가 아니다.
	
	
	/*
	Data Type 나누는 기준 
	1.어떤 종류의 데이터인가?
	2. 메모리 용량
	
	숫자 - 정수 1. byte(8bit) 2. short(16bit) 3. int(default)(32it) 4. long(64bit)
	    - 실수 1. flaot (32bit)2. double(default)(64bit)
	문자(한 문자만을 의미) char(16bit)
	논리 boolean (default = false )(1bit)
	<<Reference Data Type>>
	<<Class Data Type>>둘의 타입을 더 자주 쓴다.
	
	1. Primitive Type
	2. Class Class Type
		-API
		-Class Definition Class Type
	*/
	
	/*
	 * Has a relation
	 * 
	 * 1.가지는 클래스를 선언한다.
	 * 
	 * 2.생성자,setter로 연결한다.
	 * */
	
	/*
	기본형 값을 랩핑해서 제공함
	랩퍼 클래스.
	Byte
	Short
	Integer(제일 많이 쓰임)
	Long
	Float
	Double
	Character
	Boolean
	
	Integer g = new Integer();
	g.parseInt("1000")
	System.out.println(num);
	
	static을 씀 
	Integer.parselnt("1000");
	 
	 static은 바로 바로 해야하는 것들이 만들어져있음.
	 
	 next()|nextLine() 을 구분하기
	 --------------------------------
	 nextInt()
	 next()
	 nextInt()
	 --------------------------------
	 nextInt()
	 nextLine()
	 nextInt()
	 */

	/* 07.01
	 * 정보를 저장하는 모듈(클래스) = VO Class
	 * 기능만을 가지는 모듈
	 * 나머지 모듈을 시작할 수 있는 테스트 할 수 있는 모듈
	 * 
	 * => 세 단계를 가지는 프로그램 = Application
	 * 모듈 = 클래스
	 * 
	 * 모듈에서 기능은 쪼개서 함수화하는 것이 가독성을 높이기 좋다.
	 * 
	 */
	
	/*
	 * for = 반복 횟수(size)를 정확히 알고 있을 때 사용 
	 * while
	 * do while = size를 알 수 없을 때 empty(false)할때까지 다 뽑아낸다.
	 */
}

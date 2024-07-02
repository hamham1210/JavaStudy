package com.edu.oop;
/*
 * Notebook의 정보를 저장하고 있는 클래스
 * member는 class의 식구(field+ method)
 * VO(value object)클래스 == db와 제일 밀접하게 연관된 클래스
 * 
 * 값이 주입되는 통로
 * 1)생성자 == lifecycle을 같이 한다.생성과 소멸을 같이한다.
 * 2)setter() == 생성과 소멸 시점이 다르다.
 */
public class NoteBook {
	
	//field 선언
	public int serialNumber;
	public String brand;
	public int price;
	
//	//생성자 방식
//	public NoteBook(int serialNumber, String brand, double price) {
//	}
//	
	
	//기능 추가... 필드에 값을 할당, 주입, setter(inject)
	public void setNoteBookField(int serialNumber, String brand, double price){
//		this.serialNumber = serialNumber;
//		this.brand = brand;
//		this.price = price;
		
		/*
		 * field와 local 변수의 이름이 같을 때 이 둘을 구분하기 위해서 필드 앞에 this를 지정
		 * this는 해당 객체의 주소값을 참조하고 있다.
		 */
	}
	
	//기능 추가... 필도에 주입된 값을 받아옴, getter(reading)
	public String getNoteBookInfo() {
		return serialNumber+","+brand+","+price;
	}
	
	// method 정의 (선언 + 구현부)
	//void : 반환타입 - 해당 기능을 수행함수 반환되는 데이터가 없다는 의미를 반환타입
	public void printNoteBookInfo() {
		System.out.println(serialNumber+","+brand+","+price);
	}
}

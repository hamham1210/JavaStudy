package com.edu.oop.test;



/*
 필드에 직접 값을 할당하지 않고
 setxxxx(o,o,o)기능을 호출해서 필드초기화를 구동
 
	Clientside 현재는 그렇다
 */
public class NoteBookAppTest2 {

	
	public static void main(String[] args) {//JVM실행 및 main을 찾음
		//객체 생성 코드...
//		NoteBook n = new NoteBook();//메모리 올리고 == 클래스 객체 생성 
//		n.setNoteBookField(123, "LG Gram", 17000000.0);
		/*
		 1. 클래스 객체 내의 메소드 호출 (매개변수)아규먼트가 패싱되고서
		 2. 파라미터를 순서, 타입을 순서대로 받음
		 3. 받아온 데이터를 필드 초기화를 함.
		   */
//			n.printNoteBookInfo();	
//		System.out.println(n.getNoteBookInfo());//호출
	
	}

}

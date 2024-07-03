package com.edu.vo;
/*
 * Programmer가 여러 대의 NoteBook을 구매하기 위해서는
 * 반드시 필드에 NoteBook 타입이 아닌
 * NoteBook[]의 배열이 선언 되어여야한다.
 */
public class Programmer {

	//생성자로 주입
	String name;
	String mainSkill;
	float salary;
	String address;
	int bounus;
	/////////////////////////////Has a Relation///////////////////////////////////////////
	//setter 주입
	NoteBook[] noteBooks;
	
	public Programmer() {}

	//Programmer 객체 생성 시 name값만 할당하여 받음
	public Programmer(String name) {
		this.name = name;
	}
	
	
	//NoteBook 배열 값을 가져옴
	public NoteBook[] getNoteBooks() {
		return noteBooks;
	}
	//NoteBook 배열 값을 할당
	public void setNoteBooks(NoteBook[] noteBooks) {
		this.noteBooks = noteBooks;
	}

	public String getNoteBookInfo() {
		return name + ","+ mainSkill+","+salary;
	}
	//기능을 추가...
	//개발자의 연봉을 리턴하는 기능
	public float getAnnualSalary() {
		return salary*12 + bounus;
	}
	//개발자의 급여를 기존보다 50만원 더 인상하는 급여
	public void raiseSalary(int amount) {
		 
		 salary += amount;
	}
	
	
	
}//class

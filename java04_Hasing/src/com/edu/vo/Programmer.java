package com.edu.vo;

public class Programmer {

//	String name;
//	String mainSkill;
//	float salary;
//	String address;
//	int bounus;
//	
//	NoteBook n = new NoteBook();
//	
//	public void setProgrammerinfo(String name, String mainSkill,	float salary,String address,int bounus) {
//		this.name= name;
//		this.mainSkill = mainSkill;
//		this.salary = salary;
//		this.address = address;
//		this.bounus = bounus;
//	}
//	public String getProgrammerinfo() {
//		return name+","+mainSkill+","+salary+","+address+","+bounus+","+n.getNoteBookInfo();
//	}
	//생성자로 주입
	String name;
	String mainSkill;
	float salary;
	String address;
	int bounus;
	/////////////////////////////Has a Relation///////////////////////////////////////////
	//setter 주입
	NoteBook noteBook;
	
	public Programmer() {}
	public Programmer(String name, String mainSkill, float salary, String address, int bounus) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
		this.bounus = bounus;
	}
	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	public NoteBook getNoteBook() {
		return noteBook;
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

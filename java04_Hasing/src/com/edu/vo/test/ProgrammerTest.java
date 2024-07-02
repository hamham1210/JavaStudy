package com.edu.vo.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

/*
 * 1. 객체생성
 * 2. 메소드 호출 
 */
public class ProgrammerTest {
	
	
	
	
	public static void main(String[] args) {
		Programmer  james = new Programmer("James", "Java",100,"서울",50);
		Programmer  tomas = new Programmer("Tomas", "Java",200,"서울",100);
		
		
		tomas.setNoteBook(new NoteBook(222,"SAMSUNG",270));
		NoteBook tomasNoteBook = tomas.getNoteBook();
		System.out.println(tomasNoteBook.getNoteBookInfo());
		
		System.out.println(james.getAnnualSalary());
		
		tomas.raiseSalary(50);
		
		System.out.println(tomas.getAnnualSalary());
		/*
		 * 1.   james라는 개발자 생성
		 * 		tomas 라는 개발자를 생성
		 * 2.	james가 HP노트북을 구매
		 * 		tomas가 LG노트북을 구매
		 * 3. 	tomas가 구매한 노트북의 가격과 브랜드명을 출력
		 * 4.	james의 연봉을 출력
		 * 5. 	tomas의 급여를 인상... 최종적인 연봉을 출력
		 */
		
	}

}

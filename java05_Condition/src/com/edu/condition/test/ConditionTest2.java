package com.edu.condition.test;

import java.util.Scanner;

/*
 GradeIfTest 코드는 컴파일 시점에 실제값 88이 입력되는 코드... 프로그램이 아니다.
 실행시점에 값이 입력되도록 Scanner를 생성해서 값을 받아 보겠다.
 받을 값
 학생 이름| 해당 학생의 점수를 입력
 조건문을 그대로 작성
 출력 상황
 하승현, C grade
 */
public class ConditionTest2 {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("이름과 점수를 넣어주세요");
	String studentName = in.next();
	System.out.println("학생 이름 :"+ studentName);
	int score = in.nextInt();
	System.out.println("점수:"+ score);
	String grade;
	

	if(score >= 90 & score <= 100) {
	 grade = "A";
	}else if(score >= 80 & score <80) {
		 grade = "B";
	}else if(score >= 70 & score <70) {
		grade = "C";
	}else {
		grade = "Try again";
	}
	
	System.out.println("학생이름 : "+studentName+"  학점:"+grade);
	}

}

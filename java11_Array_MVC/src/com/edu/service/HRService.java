package com.edu.service;

import java.util.Arrays;

/*
 * 이름 짓는 방법
 * step1(제일 최악)
 * void addEngineer(Engineer e){}
 * void insertSalesMan(salesMan s){}
 * void registerAnalysis(Analysis a){}
 * 
 * step2(그나마 나은 것)
 * void addEngineer(Engineer e){}
 * void addSalesMan(SalesMan s){}
 * void addAnalysis(Analysis a){}
 * step3
 * void addEmployee(Engineer e){}
 * void addEmployee(SalesMan s){}
 * void addEmployee(Analysis a){}
 * step4
 * void addEmployee(Employee e){}
 */
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

/*
 * Enginner, SalesMan 각각의 직원들을 핸들링하는 기능만으로 구성된 서비스 클래스...
 */
public class HRService {

	Engineer[] engineers;
	int eidx;
	SalesMan[] salesMans;
	int sindx;

	public HRService(int size) {
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}//engineers,salesMans 생성자로 해당 배열을 생성하기 위해서(필드 레벨에서 추가함)

	// 서비스 기능들을 정의...
	// 1)선언부 먼저 작성 + 2) 나중에 구현부 작성 + Test에서 하나씩 호출
	// 엔지니어를 추가하는 기능
	public void addEmployee(Engineer e) {
		if(eidx == engineers.length)//기존 객체의 길이와 새로 들어온 길이가 다른지 비교
			System.out.println("엔지니어 등록이 불가능합니다.");
		else {
			engineers[eidx++] = e;//엔지니어 배열의 길이를 하나 늘리고 입력된 엔지니어 객체를 추가한다. 
			System.out.println(e.getName()+ "엔지니어 등록 성공");
		}
	}
	
	

	// 영업사원을 추가하는 기능
	public void addEmployee(SalesMan s) {
		if(sindx == salesMans.length)
			System.out.println("엔지니어 등록이 불가능합니다.");
		else {
			salesMans[sindx++] = s;
			System.out.println(s.getName()+ "엔지니어 등록 성공");
		}
	}

	// 엔지니어의 정보를 수정하는 기능
	public void updataEmployee(Engineer e) {
		for (Engineer engineer : engineers) {//for문이 엔지니어 배열을 도는 동안
			if(engineer == null)continue;
			if(engineer.getName().equals(e.getName())) {
				engineer.changeSalary(e.getSalary());
				engineer.developMainSkill(e.getMainSkill());
		}
		
		}
	}//객체를 넣어야지 수정된 값을 넣을 수 있다. 그러나 유니크한 키값(Primary key)은 바꾸면 안된다.

	// 영업사원의 정보를 수정하는 기능
	public void updataEmployee(SalesMan s) {
		for (SalesMan salesMan : salesMans) {
			if(salesMan == null)continue;
			if(salesMan.getName().equals(s.getName())) {
				salesMan.changeSalary(s.getSalary());
				salesMan.setCommition(s.getCommition());
		}
		
		}
	}

	// 특정한 엔지니어를 검색하는 기능... 이름으로
	public void searchEmployee(String name) {
		for(Engineer e : engineers) {
			if(e==null) break;
			System.out.println(e.getDetails());
			}
		}
	
	
	//사원들의 정보를 출력해주는 기능
	public void printEngineer() {
		for(Engineer e : engineers)
			System.out.println(e.getDetails());
	}
	public void printSalesMans() {
		for(SalesMan s : salesMans)
			System.out.println(s.getDetails());
	}
}

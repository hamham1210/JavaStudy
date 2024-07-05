package com.edu.singleton.test;

/*
 * client side ... BLAKE, SCOTT, SMITH 세명의 직원이 사내 사이트 접속... 직원가입을 요청
 */
public class EmployeeDAOTest {

	public static void main(String[] args) {
		EmployeeDAO.getInstance().register("Blake");;
	}

}

class EmployeeDAO{
	//1. private static으로 객체 생성
	private static EmployeeDAO dao = new EmployeeDAO();
	
	//2. 생성자 앞에 private
	private EmployeeDAO() {
		System.out.println("싱글톤으로 객체 하나만 일단 생성");
	}
	//3. public static한 성질로 만든 객체를 반환하는 기능
		public static EmployeeDAO getInstance() {
			return dao;
		}
		
	
	public void register(String name) {
		System.out.println("Register Service... "+ name+"...Register Success!!");
	}
	
	public void search(String name) {
		System.out.println("Search Service... OK!");
	}
}

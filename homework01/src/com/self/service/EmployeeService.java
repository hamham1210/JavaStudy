package com.self.service;

import com.self.vo.Engineer;
import com.self.vo.Manager;

import java.util.Arrays;

public class EmployeeService {

	public static final int MAX_EMPLOYEE = 100;
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	
	boolean flag = false;
	public EmployeeService(){
		ms = new Manager[MAX_EMPLOYEE];
		egs = new Engineer[MAX_EMPLOYEE];
	}
	public static  EmployeeService getInstance(){return emservice;}
	private static EmployeeService emservice = new EmployeeService();



	public void addEmployee(Manager m) {
		ms[midx++] = m;
	}
	public void addEmployee(Engineer eg) {
		egs[egidx++] = eg;
	}
	public void deleteEmployee(String name) {
		for(int i=0; i<midx; i++){
			if (ms[i].getName().equals(name)){
				for(int j = i; j<midx; j++){
					ms[j]= ms[j+1];
				}
				ms[midx]=null;
				midx--;
				break;
			}
		}
		for(int i=0; i<egidx; i++){
			if (egs[i].getName().equals(name)){
				for(int j = i; j<egidx; j++){
					egs[j]= egs[j+1];
				}
				egs[egidx]=null;
				egidx--;
				break;
			}
		}
	}

	public void updateEmployee(Manager m,String name) {
		for (int i=0; i < ms.length; i++){
			if (ms[i] != null && ms[i].getName().equals(name)){
				flag = true;
				ms[i]= m;
				break;
			}
			if (!flag){
				System.out.println("입력을 확인해주세요. 이름이 일치하지 않습니다.");
			}
		}
	}
	public void updateEmployee(Engineer eg,String name) {
		for (int i = 0; i < egs.length; i++){
			if (egs[i] != null && egs[i].getName().equals(name)){
				flag = true;
				egs[i] = eg;
				break;
			}
			if(!flag)
			{
				System.out.println("입력을 확인해주세요. 이름이 일치하지 않습니다.");
			}
		}

	}	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager mg = null;
		int temp = 0;
		Manager[] managers = new Manager[ms.length];

		for (Manager m : ms) {
			if (m == null) break;
			if (m.getName().contains(name)) {
				managers[temp++] = m;
				if (mg == null) {
					mg = m;
				}
			}
		}
		return mg;
	}
	
	public Manager[ ] findEmployee(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		for(Manager m : ms){
			if (m == null) break;
			if (m.getDeptno() == deptno){
				temp[deptno]=m;
				break;
			}
		}
		
		return temp;
	}
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		int temp = 0;
		Engineer[] engineers = new Engineer[egs.length];

		for (Engineer e : egs) {
			if (e == null) break;
			if (e.getName() != null &&e.getName().contains(name)) {
				engineers[temp++] = e;
				if (eg == null) {
					eg = e;
				}
			}
		}
			return eg;
    }

	public void printManagers() {
		if (midx==0){
			System.out.println("직원을 등록해주세요.");
			return;
		}
		for(int i=0; i<midx; i++){
			System.out.println(ms[i]);
		}
	}

	public void printEngineers() {
		if (egidx==0){
			System.out.println("직원을 등록해주세요.");
			return;
		}
		for (int i = 0; i < egidx; i++){
			System.out.println(egs[i]);
		}
	}

	public void salaryAverege(){
		double averge;
		double msalary =0;
		double esalary=0;
		for(Manager m : ms){
			if (m != null) {
				msalary += m.getSalary();
			}
		}
		for(Engineer e : egs){
			if (e != null) {
				esalary += e.getSalary();
			}
		}
		averge = (msalary+esalary)/(ms.length+egs.length);
		System.out.println("총급여 : "+ (msalary+esalary));
		System.out.println("급여평균 : "+ averge);
	}
	public void birthdayMonth(int month) {
		String[] birthdayPeople = new String[0];
		int count = 0;
		for (Manager m : ms) {
			if (m != null && m.getBirthDate().getMonth()==month) {
				birthdayPeople = Arrays.copyOf(birthdayPeople, birthdayPeople.length + 1);
				birthdayPeople[count] = m.getName();
				count++;
					}
				}
		for(Engineer e :egs){
				if (e != null && e.getBirthDate().getMonth()==month){
					birthdayPeople = Arrays.copyOf(birthdayPeople, birthdayPeople.length + 1);
					birthdayPeople[count] = e.getName();
					count++;
			}
		}
		if (birthdayPeople.length == 0) {
			System.out.println("이번달 생일자는 없습니다.");
		} else {
			System.out.println("이번달 생일자는 : " + String.join(", ", birthdayPeople));
		}
	}
	
}


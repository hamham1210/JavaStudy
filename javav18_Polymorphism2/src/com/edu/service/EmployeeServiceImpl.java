package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;

public class EmployeeServiceImpl implements EmployeeService {
	
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();//1
	private EmployeeServiceImpl() {}//2
	public static EmployeeServiceImpl getInstance() { //3
		return service;
	}//싱글톤
	
	
		
	//1. 모든 Employee[ ]안에 들어있는 객체 정보들을 출력
	public Employee[ ] getAllEmployee(Employee[ ] ea){	
		Employee[ ] temp = new Employee[ea.length];
		//Employee타입의 배열  temp를 선언. temp는 Employee타입으로 ea의 길이만큼의 크기를 가진다.
		int count = 0;
		//배열의 크기를 구하기 위한 count값 선언
		for(Employee e : ea)temp[count++] = e;			
		//for문으로 ea전체 만큼을 돌릴 것이다.그리고 해당 배열을 돌때 temp배열에 e를 넣고 count를 하나 올린다. 
		return temp;
		//모든 Employee값을 넣은 temp배열을 돌려준다.
	}
	
	//2.테스트 클래스에서 넘겨받은 empId의 값과 일치하는 객체를 리턴하는 기능
	public Employee findEmployee(Employee[ ] ea, int empId){
		Employee employee = null;
		//해당하는 값을 받을 Employee타입의 객체 생성
		for(Employee e : ea) {
			//for문으로 ea를 하나씩 돌려볼 것이다.
			if(e.getEmpId() == empId) {
				//e객체에서 ID값을 뽑아내서 찾으려고 하는 empId와 값이 맞는지 확인한다.
				employee = e;
				//맞는 값들을 위에 선언해두었던 employee에 값을 넣고
				break;
				//모든 행위를 다 하면 멈춘다.
			}
		}
		return employee;
		//찾은 것을 끝낸 employee객체들을 돌려준다.
				
	}
	
	//3. 테스트 클래스에서 넘겨받은  addr값과 일치하는 Employee 타입의 객체를 리턴받음

	public Employee[ ] findEmployee(Employee[ ] ea, String addr){
		
		int index = 0; 
		//배열의 길이를 알기 위한 index값을 선언
		for (Employee e: ea){
		if(e.getAddr().equals(addr)) { index++;
		}//직원수를 알기 위해서 for문을 돌면서 같은 값을 찾으면 사이즈를 늘림
		}
		Employee[] addrEmps = new Employee[index];
		//주소가 같은 값을 찾기 위해서 Employee 배열 타입의 객체 생성
		for (Employee e: ea){
			if(e.getAddr().equals(addr)) { 
				//e의 Addr값을 가져와서 함수의 인자값으로 받은 addr과 동일한지 확인.
				addrEmps[--index]=e;
				//e 가 존재하면 addrEmps배열에서 index값을 하나 빼고 e를 대입한다.
			}
			}
		
		return addrEmps;
	
	}
	//4. 특정한 Employee의 연봉을 리턴하는 기능...Engineer일때는 보너스 까지 생각
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		
		annualSalary = e.getSalary()*12;
		
		if (e instanceof Engineer)
		//Employee의 e값은 ENGineer의 형태를 가진다.
		{
			annualSalary = annualSalary+((Engineer)e).getBonus();
		}
		return annualSalary;
	}
	
	//5. 연간 총 인건비의 총액을 리턴하는 기능
	public int getTotalCost(Employee[ ] ea){
		int totalCost = 0;
		for(Employee e : ea) {
			totalCost += getAnnualSalary(e);
		}
		return totalCost;
		
	}
	
}






































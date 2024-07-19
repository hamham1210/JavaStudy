package com.edu.service.impl;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.zip.DataFormatException;

import com.edu.excepetion.DuplicateEmpIdExcetion;
import com.edu.service.EmployeeListService;
import com.edu.service.excepetion.RecordNotFoundException;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService{
	
	//추가
	private ArrayList<Employee> list;
	
	static private EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<Employee>();
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) throws DuplicateEmpIdExcetion{		
		boolean find = false;//flag 값 하나 선언
		for(Employee emp : list) {
			if(emp.getEmpId().equals(e.getEmpId())) {//이미 추가하려는 사람이 존재한다면
				find = true;
				System.out.println(e.getName()+"님은 이미 회원명단에 가입되어 있습니다.");
				throw new DuplicateFormatFlagsException(e.getName());
			}
		}//for
		
		if(find==false) { //추가하려는 사람이 리스트에 존재하지 않다면
			list.add(e);
			System.out.println(e.getName()+"님 회원으로 가입되셨습니다.");
		}
	}
	@Override
	public void deleteEmployee(String empId) throws RecordNotFoundException{		
		boolean find = false;//flag 값 하나 선언
		for(Employee emp : list) {
			if(emp.getEmpId().equals(empId)) {//삭제하려는 사람이 존재한다면
				find = true;
				System.out.println(emp.getName()+"님을 삭제합니다..");
				list.remove(emp);
				break;//반드시 해야한다. 삭제를 했기때문에.
			}
		}//for		
		if(find==false)System.out.println("삭제하려는 대상이 현재 회원중에는 존재하지 않습니다.");
		throw new RecordNotFoundException("삭제할 직원이 존재하지 않습니다.");
	}
	
	@Override
	public void updateEmployee(Employee e) throws RecordNotFoundException{		
		boolean find = false;
		for(Employee emp : list) {
			if(e.getEmpId().equals(emp.getEmpId())) { //수정하려는 대상이 존재한다면
				//
				//emp.setEmpId(null);//pk에 해당하는 값은 수정의 대상이 되면 안된다..pk를 제외한 나머지 정보들이 수정의 대상
				emp.setName(e.getName());
				emp.setAddr(e.getAddr());
				emp.setSalary(e.getSalary());
				
				if(emp instanceof Manager) {
					((Manager) emp).changeDept(((Manager) e).getDept());
				}//if
				if(emp instanceof Engineer) {
					((Engineer) emp).changeBonus(((Engineer) e).getBonus());
					((Engineer) emp).changeTech(((Engineer) e).getTech());
				}//if			
			}//if
			break;
		}//for
		if(find == false) {
			throw new RecordNotFoundException("삭제할 직원이 존재하지 않습니다.");
		}
	}//updateEmployee
	
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for(Employee emp : list) {
			if(emp.getAddr().equals(addr)) temp.add(emp);			
		}
		return temp;
	}
	
	@Override
	public void findEmployees() {
		for(Employee e : list)System.out.println(e);
	}
}

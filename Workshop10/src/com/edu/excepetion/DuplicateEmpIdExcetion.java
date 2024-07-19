package com.edu.excepetion;

public class DuplicateEmpIdExcetion extends Exception{
	public DuplicateEmpIdExcetion() {
	 this("EmpId에 해당 직원은 이미 등록된 상태입니다.");
	}

public DuplicateEmpIdExcetion(String message) {
	super(message);
	}


}

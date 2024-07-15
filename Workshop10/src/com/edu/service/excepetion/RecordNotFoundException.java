package com.edu.service.excepetion;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		 this("EmpId에 해당 직원은 이미 등록된 상태입니다.");
		}

	public RecordNotFoundException(String message) {
		super(message);
		}

}

package com.edu.exception;

public class DMLException extends Exception{
	public DMLException(String message){
		super(message);
	}
	
	public DMLException() {
		this("회원 추가, 수정, 삭제시 작업이 제대로 진행되지 않았습니다.");
	}
}

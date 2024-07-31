package com.dao.exception;

public class DMLException extends Exception {
	public DMLException(String message){
		super(message);
	}
	
	public DMLException() {
		this("Duplicate Number....이미 존재하는 사람입니다.");
	}
}

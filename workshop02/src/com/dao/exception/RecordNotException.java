package com.dao.exception;

public class RecordNotException extends Exception {
	public RecordNotException(String message){
		super(message);
	}
	
	public RecordNotException() {
		this("Duplicate Number....이미 존재하는 사람입니다.");
	}
}

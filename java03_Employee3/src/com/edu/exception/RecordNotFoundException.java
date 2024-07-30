package com.edu.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException(String message){
		super(message);
	}
	
	public RecordNotFoundException() {
		this("RecordNotFound....존재하지 않는 사람입니다...");
	}
}
//수정과 삭제를 할 때 사용. 기록된 것이 없을 때쓴다
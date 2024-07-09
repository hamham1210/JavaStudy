package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent {
	public void childAccess() {
		System.out.println(publicField);
		System.out.println(protectedfeield);
		System.out.println("defualtFidld, privateField는 접근 할 수 없습니다.");
	}
	public void access() {
		super.access();
		System.out.println("부모에 접근 가능한 필드 ::"+publicField);
		System.out.println("부모에 접근 가능한 필드 ::"+protectedfeield);
		//defult는 패키지가 같아야 접근 가능하다.
	}

}

package com.edu.parent;
/*
 * 상속관계에서 Access Modifier관계를 정리해보겠다.
 * 부모클래스
 */
public class Parent {
	public String publicField= "publicField";
	protected String protectedfeield = "protectedfeield";
	
	String defaultField = "defaulField";
	private String privateField = "privatedField";
	
	public void access() {
		System.out.println("Access Modifier Test...");
	}
}

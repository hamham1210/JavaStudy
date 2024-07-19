package com.edu.child;

import com.edu.parent.Flyer;

public class Airplane implements Flyer{
/*
 * 1step-- void fly();
 * 2step-- public void fly(){};  오버라이딩
 */
	@Override
	public void fly() {
		System.out.println("Airplane fly...");
	
	}

	@Override
	public void land() {
		System.out.println("Airplane land...");
	}

	@Override
	public void take_off() {
		
		System.out.println("Airplane take_off...");
	}
	

}

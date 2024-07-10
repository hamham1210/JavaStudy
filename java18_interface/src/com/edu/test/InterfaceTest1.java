package com.edu.test;
import com.edu.child.Bird;
/*
 * abstract가 있으면 객체생성의 대상이 되지 않는다.
 */
import com.edu.parent.Flyer;

public class InterfaceTest1 {

	public static void main(String[] args) {
		Flyer f = new Bird(); //Polymorphism
		/*
		 * 1. Object Casting
		 * 2. Virtual Method Invocation
		 */
		((Bird)f).layEggs();//1. Object Casting 자식 클래스를 캐스팅하여서 가져온다.
		f.land();//2
		
		Flyer[] f3 = new Flyer[3];//interface를 가지고 상속을 하여서 객체생성이 가능하다.
		
		//class간의 상속은 필드 중심으로 상속이 이뤄지고 interface간의 상속은 기능 중심으로 상속이 이뤄진다.
		//둘 다 상속의 부모이고 그 둘을 타입으로 객체를 생성가능하다.

	}

}

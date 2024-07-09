package com.edu.test;

import com.edu.child.Child;
import com.edu.parent.Parent;

public class AccessModifierTest {

	public static void main(String[] args) {
		Child c = new Child();
		Parent p = new Parent();
		p.access();//부모의 access호출
		
		c.childAccess();
		
		System.out.println("=========Overrind된 함수 호출==========");
		c.access();//자식의 access호출
	}

}

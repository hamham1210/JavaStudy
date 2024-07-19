package com.edu.child;

import com.edu.parent.Pizza;

public class CombinationPizza extends Pizza{

	@Override
	public void topping() {
		System.out.println("콤비네이션로 토핑 한 피자");
		
	}

	public CombinationPizza(int price, String storeName) {
		super(price, storeName);
		
	}

}

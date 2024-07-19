package com.edu.service.Impl;

import java.util.Iterator;

import com.edu.child.PizzaService;
import com.edu.parent.Pizza;

public class PizzaServiceImpl implements PizzaService{
	//싱글톤 1.
	private static PizzaServiceImpl service = new PizzaServiceImpl();
	private PizzaServiceImpl() {
		
	}
	
	public static PizzaServiceImpl getInstance() {
		return service;
	}
	@Override
	public void allMakePizza(Pizza[] pizzas) {
		for(Pizza p : pizzas) {
			System.out.println(p);
			p.sequencePizza();
			System.out.println("===================");
		}
	}

}

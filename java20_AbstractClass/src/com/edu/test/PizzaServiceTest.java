package com.edu.test;

import com.edu.child.CombinationPizza;
import com.edu.child.PotatoPizza;
import com.edu.parent.Pizza;
import com.edu.service.Impl.PizzaServiceImpl;

public class PizzaServiceTest {

	public static void main(String[] args) {
		PizzaServiceImpl service = PizzaServiceImpl.getInstance();
		Pizza[] pizzas = {
				new PotatoPizza(23000, "미스터 피자"),
				new CombinationPizza(30000, "PizzaHut"),
				new PotatoPizza(15000, "Kosta")
		};
		
		service.allMakePizza(pizzas);
	}

}

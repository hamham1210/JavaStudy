package self;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoffeOrder {

	public static void main(String[] args) {
		List<String> coffees = new ArrayList<>();
		
		coffees.add("Cappuccino");
		coffees.add("Americano");
		coffees.add("Espresso");
		coffees.add("Caramel Macchiato");
		coffees.add("Mocha");
		coffees.add("Cappuccino");
		coffees.add("Espresso");
		coffees.add("Latte");
		
		Stream<String> stream = coffees.stream();
		
		stream.filter(i-> i.endsWith("o")).sorted().distinct().forEach(i->System.out.print(i+" "));
		
	}

}

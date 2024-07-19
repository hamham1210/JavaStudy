package test1;

import java.util.List;



abstract class Animal{
	public void eat() {
		System.out.println("Animal eating...");
	}
}

class Dog extends Animal{
	
	public void eat() {
		System.out.println("Dog eating...");
	}
	void bark() {
		System.out.println("Dog Bark...");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("Cat eating...");
	}
	//eat(){}상속 받음
	void meow() {
		System.out.println("Cat Meow...");
	}
}
public class GenericWildCardTest4 {

	public static void main(String[] args) {
		
	List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());	
		takeAnimals(animals);
		
		List<Dog> dogs = List.of(new Dog(),new Dog());
//		takeAnimals(dogs);//에러난다... Dogs가 animals 할당되어야 하지 않냐? 다형성이 아닌가? 아니다!
		takeAnimals(dogs);
	}
	//wild card 적용하는 기능 정의
	public static void takeAnimals(List<?extends Animal> animals) {
		for(Animal a : animals) {
			a.eat();
		}
	}
}

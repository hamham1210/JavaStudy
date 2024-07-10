package com.edu.array.test;

public class TonysArrayTest2 {

	public static void main(String[] args) {
		Contact contactRef = null;
		int x = 0;
		while (x < 10) {
			contactRef = new Contact("PersonName...");
			System.out.println("Contact2 Refrence..."+contactRef);
			x++;

		}
		System.out.println(contactRef);
		contactRef.printName();
	}

}





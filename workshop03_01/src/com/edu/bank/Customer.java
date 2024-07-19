package com.edu.bank;

import java.util.Scanner;

public class Customer {
	String name;
	String address;
	Account account;
	Scanner in = new Scanner(System.in);
	public Customer() {}
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
		
	}

	public void makeCustomer() {

		System.out.print("고객 이름: ");
		String customerName = in.next();
		in.nextLine();
		System.out.print("주소: ");
		String customerAddress = in.next();
		setCustomer(customerName, customerAddress);
		System.out.println(getCustomerInfo());
	}
	
	
	public void setCustomer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public Account getaccount() {
		return account;
	}
	
	public String getCustomerInfo() {
		return "이름"+ name+ "/" + "주소"+address ;
	}
	



	


}

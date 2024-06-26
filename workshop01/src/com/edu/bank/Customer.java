package com.edu.bank;

public class Customer {
	String name;
	String address;
	Account account;
	public Customer() {}
	public Customer(String name, String address,Account account) {
		this.name = name;
		this.address = address;
		this.account = account;
	}

	

	public Account getAccount() {
		return account;
	}
	
	public String getCustomerInfo() {
		
		return name+ "/" + address + "/"+ account;

	}
	



	


}

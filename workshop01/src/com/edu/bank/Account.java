package com.edu.bank;

public class Account {
	
	int accNumber;
	String bankName;
	double balance;
	
	public Account() {}
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	public void setBalance(double amt) {
		balance = amt;
	}
	public void withdraw(double amt) {
		balance-=amt;
	}

	public void deposit(double amt) {
		balance+=amt;
	}
	public String getAccountInfo() {
	
	return accNumber +bankName + balance; 	
	}
	

	
	
	
}

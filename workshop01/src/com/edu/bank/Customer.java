<<<<<<< HEAD
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
=======
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

	

	public Account getaccount() {
		return account;
	}
	
	public String getCustomerInfo() {
		
		return "이름"+ name+ "/" + "주소"+address + "/"+ account.getAccountInfo();

	}
	



	


}
>>>>>>> branch 'new' of https://github.com/skyblue1012/JavaStudy.git

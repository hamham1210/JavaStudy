package com.edu.service;

import com.edu.vo.Customer;

public class BankService {
	public Customer[] customer;
	public int cidx;

	private static BankService dao = new BankService();
	
	public BankService() {
		customer = new Customer[1];
	}
	public static BankService getInstance() {
		return dao;
	}

	// 고객을 추가하는 기능
	public void addCustomer(Customer c) {
		if (cidx == customer.length) {
			System.out.println("추가할 고객이 없습니다.");
			return;
		} else {
			customer[cidx++] = c;
		}
	}

	// 고객 정보를 가져오는 기능
	public void getCustomer(int ssn) {
		for (Customer c : customer) {
			if (c == null)
				break;
			System.out.println(c.getaccount());
		}
	}

	// 모든 정보를 보여주는 기능
	public void showAll() {
		for(int i=0; i<cidx; i++) {
			System.out.println(customer[i]);
		}
	}

	// 고객 명수를 세는 기능
	public int countCustomer() {
		return cidx;
	}

}

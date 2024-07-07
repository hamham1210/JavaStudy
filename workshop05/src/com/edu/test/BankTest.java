package com.edu.test;

import java.util.Scanner;

import com.edu.service.BankService;
import com.edu.vo.Account;
import com.edu.vo.Address;
import com.edu.vo.Customer;

public class BankTest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.계좌 생성 2.계좌 확인 3. 현재 확인되는 사람수");
			int input = in.nextInt();
			switch (input) {
			case 1: {
				addCustomer();
				break;
			}
			case 2: {
				BankService.getInstance().showAll();
				break;
			}
			case 3: {
				BankService.getInstance().countCustomer();
				break;
			}
			default:
				System.out.println("입력을 확인해주세요.");
				break;
			}
		}
	}
	private static void addCustomer() {
		System.out.println("계좌 정보를 추가해주세요.");
		Scanner in = new Scanner(System.in);
		System.out.println("고객이름");
		String name = in.next();
		System.out.println("주민번호");
		int ssn = in.nextInt();
		System.out.println("초기금액");
		int balance = in.nextInt();
		System.out.println("우편번호");
		int zipCode = in.nextInt();
		System.out.println("지역");
		String region = in.next();
		System.out.println("도시");
		String city = in.next();
		
//		Customer c = new Customer(name,ssn,new Account(balance), new Address(zipCode,region,city));
//		BankService.getInstance().addCustomer(c);
	}

}

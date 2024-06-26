package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;


public class BankTest {
	
	

	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("James,Tomas의 계좌 개설");
		System.out.println("James의 계좌정보를 입력해주세요.");
		
		System.out.print("계좌 번호: ");
        int accountNumber = in.nextInt();
        System.out.print(accountNumber);
        in.nextLine();  // 버퍼 비우기
        
        System.out.print("계좌 소유자 이름: ");
        String accountHolder = in.nextLine();
        
        System.out.print("초기 잔액: ");
        double balance = in.nextDouble();
        Account jamesAccount = new Account(accountNumber, accountHolder, balance);
	
		 
		Customer james = new Customer("james","NewYork",jamesAccount);
		jamesAccount.getAccountInfo();
		
		System.out.println(james.getCustomerInfo());
		

	}



}

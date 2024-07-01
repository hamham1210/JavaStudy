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
        in.nextLine(); 
        System.out.print("은행 이름: ");
        String accountHolder = in.nextLine();
        
        System.out.print("초기 잔액: ");
        double balance = in.nextDouble();
        Account jamesAccount = new Account(accountNumber, accountHolder, balance);
        
		 
		Customer james = new Customer("james","NewYork",jamesAccount);
		
		System.out.println("James님의 계좌 정보를 확인해주세요. ");
		System.out.println(james.getCustomerInfo());
		
		System.out.println("입금할 금액을 입력하시오.: ");
		double input = in.nextDouble();
		james.getaccount().withdraw(input);
		
		System.out.println("출금할 금액을 입력하시오.: ");
		double output = in.nextDouble();
		james.getaccount().deposit(output);
		
		System.out.println("최종 계좌 정보를 확인해주세요. ");
		System.out.println(james.getCustomerInfo());
		
		in.close();
	}



}

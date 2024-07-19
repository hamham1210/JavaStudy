package com.edu.backward;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankMenuTest {
	
	public static void main(String[] args) {
		Account account = new Account();
		Customer cu= new Customer();
		
		Scanner in = new Scanner(System.in);
		do {
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1. 고객 생성 2. 계좌 개설 3. 입금 4. 출금 5. 잔액조회 6.고객정보조회 7.종료");
		
		int input = in.nextInt();
		
		switch (input) {
		case 1: 
			cu.makeCustomer();
			break;
		case 2:
			account.makeAccount();
			//계좌 개설정보 설정 고치기
			break;
		   case 3:
		    	System.out.print("입금액을 입력하세요 : ");
		    	int depositamt = in.nextInt();
		    account.deposit(depositamt);
		    	break;
		   case 4:
		    	System.out.print("출금액을 입력하세요 : ");
		    	int withdrawamt = in.nextInt();
		    	account.withdraw(withdrawamt);
		    	break;
		   case 5:
		    	System.out.println("잔액 : " + account.getBalance());
		    	break;
		    case 6:
		    	System.out.println(cu.getCustomerInfo());
		    	break;
		    case 7: 
			    System.out.println("프로그램 종료");
			    System.exit(0);
		
	}
		}while(true);

}
}

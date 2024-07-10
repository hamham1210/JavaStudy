package com.edu.bank;

/*
 * 생성자에 balance
 * 은행에 따라서 정책이 다르므로 해당 부부을 다르게 주입
 * deposit 은 1000원 이상에 입금하기
 * 이하 일 때는 안내문구와 다시 입금하기로 돌리기
 * withdraw 은 잔액 이하만 출금이 되도록 하기
 * 이상 일 때는 안내문구와 다시 출금하기로 돌리기
 */



public class Account {
	
	public int accNumber;

	public String bankName;

	public double balance;
	
	public Account() {}

	public Account(int accNumber, String bankName, double balance) {
		if (bankName.equals("KB")) {
			if (balance >= 10000) {
				this.accNumber = accNumber;
				this.bankName = bankName;
				this.balance = balance;
				System.out.println("KB계좌 개설 완료");
			} else {
				System.out.println("KB는 10000원 이하일때 계좌 개설이 불가합니다.");
				System.exit(0);
			}
		} else {
			this.accNumber = accNumber;
			this.bankName = bankName;
			this.balance = balance;
			System.out.println("타행계좌 개설 완료");

		}
	}
	
	

	public void setBalance(double amt) {
		balance = amt;
	}

	public void withdraw(double amt) {
		if (amt <= balance) {
			balance -= amt;
		} else {
			System.out.println("잔액보다 많은 금액은 출금하지 않아도 됩니다.");
		}
	}
	
	public void deposit(double amt) {
		if (amt >= 1000) {
			balance += amt;
		} else {
			System.out.println("입금액은 천원 이상부터입니다.");
		}
	}

	public String getAccountInfo() {

		return "계좌번호" + accNumber + "/" + "은행이름" + bankName + "/" + "계좌잔고" + balance;
	}

	public void minimumBalance() {

		if (bankName.equals("국민은행") && balance >= 10000) {

			System.out.println("계좌가 정상 개설되었습니다.");
		} else {
			System.out.println("입금액을 다시 입력해주세요.");
		}

	}
	

	
}

package com.edu.bank;
//Single Line Comment

/**
 * <pre>
 * {@code
 * 은행 계좌 정보를 저장하는 클래스
 *  
 * 이번 Java Document 주석 사용법 예시로 작성
 * 이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
 * 개발자가 자신의 코드를 보완설명하기 위해서 작업하는 방식이다.
 * 
 * }
 * 
 * </pre>
 * 
 은행 계좌 정보를 저장하는 클래스
 @author PHR
 @version Test Project version 1.0.1
 @since (만들어 온 날짜, JDK버전 등) JDK 17
 */
public class Account {
	/**
	 * 계좌번호 
	 */
	public int accNumber;
	/**
	 * 은행 명 
	 */
	public String bankName;
	/**
	 * 계좌에 남아있는 잔액 혹은 개설 시 필요한 조건으로서의 잔액
	 */
	public double balance;
	
	public Account() {}
	/**
	 * Account 명시적 생성자 
	 * @param accNumber
	 * @param bankName
	 * @param balance
	 */
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}
	/**
	 * 통장 개설 이후에 잔액을 다시 입력하는 기능.
	 * @param amt
	 * @deprecated Account 객체로 대체({@link Account#accNumber,#bankName,#balance}
	 */
	public void setBalance(double amt) {
		balance = amt;
	}
	/**
	 * 은행 잔고에서 출금액을 빼는 함수
	 * @param amt
	 */
	public void withdraw(double amt) {
		balance-=amt;
	}
	/**
	 * 
	 * 은행 잔고에 입금액을 넣는 함수
	 * @param amt
	 */
	public void deposit(double amt) {
		balance+=amt;
	}
	/**
	 *@return 계좌번호, 은행이름, 계좌잔고 정보를 돌려주는
	 */
	public String getAccountInfo() {
	
	return "계좌번호"+accNumber +"/"+"은행이름"+bankName + "/"+"계좌잔고"+balance; 	
	}
	
	

	
	
	
}

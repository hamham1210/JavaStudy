package com.self.vo;
/**
 * <pre>
 * {@code
 * 
 *  
 * 이번 Java Document 주석 사용법 예시로 작성
 * 이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
 * 개발자가 자신의 코드를 보완설명하기 위해서 작업하는 방식이다.
 * 
 * }
 * 소설의 정보를 저장하는 클래스
 @author PHR
 @version Test Project version 1.0.1
 @since (만들어 온 날짜, JDK버전 등) JDK 17
 */
public class Novel extends Book {
	/**
	 * 시놉시스
	 */
	private String synopsys;
/**
 * Novel의 명시적 생성자
 */
	public Novel() {
	}
/**
 * Novel 생성자
 * @param isbn
 * @param title
 * @param author
 * @param publiser
 * @param price
 * @param synopsys
 */

	public Novel(int isbn, String title, String author, String publiser, double price, String synopsys) {
		super(isbn, title, author, publiser, price);
		this.synopsys = synopsys;
	}


	public String getSynopsys() {
		return synopsys;
	}


	public void setsynopsys(String synopsys) {
		this.synopsys = synopsys;
	}

	@Override
	public String toString() {
		return super.toString()+" Novel [Synopsys =" + synopsys + "]";
	}	

	

}

package com.self.vo;
/**
 * <pre>
 * {@code
 *  
 * 이번 Java Document 주석 사용법 예시로 작성
 * 이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
 * 개발자가 자신의 코드를 보완설명하기 위해서 작업하는 방식이다.
 * 
 * }
 * 잡지 정보를 저장하는 클래스
 @author PHR
 @version Test Project version 1.0.1
 @since (만들어 온 날짜, JDK버전 등) JDK 17
 */
public class Magazine extends Book{
	/**
	 * 잡지 호수
	 */
	private int magazineNo;
/**
 * Magazine 명시적 생성자
 */
	public Magazine() {
	}
/**
 * Magazine  생성자
 * @param isbn
 * @param title
 * @param author
 * @param publiser
 * @param price
 * @param magazineNo
 */
	
	public Magazine(int isbn, String title, String author, String publiser, double price,int magazineNo) {
		super(isbn, title, author, publiser, price);
		this.magazineNo = magazineNo;
	}
/**
 * 잡지 호수를 돌려주는 함수
 * @return
 */
	public int getMagazineNo() {
		return magazineNo;
	}
/**
 * 잡지 호수를 가져오는 함수
 * @param magazineNo
 */
	public void setMagazineNo(int magazineNo) {
		this.magazineNo = magazineNo;
	}
/**
 * 잡지 정보를 돌려주는 함수
 */
	@Override
	public String toString() {
		return super.toString()+" Magazine [magazineNo =" + magazineNo + "]";
	}
	

}

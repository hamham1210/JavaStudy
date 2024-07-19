package com.edu.parent;
/*
 * 추상 클래스의 용도
 * 1. 공통의 피자를 만들어 내기 위한 공통적인 작업은 (필드, 메소드) 그대로 자식 클래스에게 물려주고
 * 2. 반면에 서로 다른 여러 종류의 피자가 만들어 질 수 있는 결정적인 부분은 추상메소드로 물려준다.
 * 	topping에 따라서 서로 다른 피자 종류가 만들어 진다.
 * 
 * 인터페이스와의 차이점 :: 추상성
 * 완벽한 추상성 --> 인터페이스 --> 사용자와 벤더 사이의 구약, 표준화
 * 부분적인 추상성 --> 추상 클래스 --> 자식들에 있어서 결정적인 다른 부분들은 미완으로 물려준다.(자식에서 완성하도록 강제한다.)
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;
	
	public Pizza() {
		this(15000,"PizzaHut");
	}
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	public void sequencePizza() {
		dogh();
		
		topping();
		
		bake();
		boxing();
		cutting();
	}
	
	public void dogh() {
		System.out.println("피자 반죽과 함께 도우를 잘 만들어 준다.");
	}
	
	public void bake() {
		System.out.println("180도 오븐에서 10분간 구워냅니다.");
	}
	public void boxing() {
		System.out.println("피자 포장");
	}
	public void cutting() {
		System.out.println("피자 커팅");
	}
	public abstract void topping() ;//추상 클래스에서 추상 메소드만 선언 시에는 public abstract 키워드 필수
	
	@Override
	public String toString() {
		return "상점이름,"+storeName+" 가격, "+price;
	}
}

package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		Product[] products = { new Product("신라면", 1200, 5, "농심"), new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "LG"), new Product("짐빔", 130000, 1, "JIM"), };

		System.out.println("===========상품 정보를 출력합니다.============\n");
		for (Product product : products) {
			System.out.println(product.getDetails());
			if (product.getMaker().equals("하이타이")) {
				int price = product.getPrice() - 2000;
				System.out.println("하이타이 2000원 할인된 가격은 " + price + "원입니다.");
			}

		}

	}

}

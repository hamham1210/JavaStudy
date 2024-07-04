package com.edu.service;
/*
 * Outlet 에서 상품을 구매하는 고객의 기능을 정의하고 있는 클래스...
 * 서비스 클래스는 기능만으로 이뤄지는 클래스
 * vo, test, service클래스를 작성하게 되면 드디어 구조적인 Application을 자바 SE기반으로 작성
 */

import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletService {

	Product[] product;
	Customer[] customer;

	// 1. 특정 고객이 구입한 상품을 반환하는 기능
	public Product[] getAllProduct(Customer vo) {
		return vo.getProducts();
	}

	// Customer 클래스
	// 2. 특정 고객이 구입한 상품의 Maker들 만을 반환하는 기능
	public String[] getAllProductMaker(Customer vo) {
		String[] temp = new String[vo.getProducts().length];
		int idx = 0;
		for (Product p : vo.getProducts()) {
			temp[idx++] = p.getMaker();

		}
		return temp;
	}// 리턴 타입은 오류에 안 걸린다. (메소드 이름과 인자 값이 다르면 다른 메소드와 같다)
		// 3. Outlet 안에 있는 고객 중에서 특정한 고객을 검색하는 기능

	public Customer findACustomer(Customer[] customers, int ssn) {
		Customer customer = null;
		for (Customer c : customers)
			if (c.getSsn() == ssn)
				customer = c;
		return customer;
	}
	// 4. Outlet 안에 있는 고객 중에서 동일한 주소를 가지고 고객들을 반환하는 기능

	public Customer[] findCustomer(Customer[] customers, String addr) {

		Customer[] temp = new Customer[customers.length];
		int idx = 0;
		for (Customer c : customers) {
			if (c.getAddress().equals(addr)) {
				temp[idx++] = c;
			}
		}
		return temp;
	}

	/*
	 * 메소드 오버로딩 = 하는 일은 같지만 처리하는 데이터는 다르게 하는 기법.(규칙 1. 메소드이름은 같고 2. 인자값list은
	 * 다르다.(인자값의 타입이 다르게한다.) 3. return타입은 상관없다.) /인자 값이 다르므로 충돌이 안 난다. 서비스 클래스에서 기능의
	 * 일관성을 유지하는 중요한 기법이다. -인자값이 다른 경우는 by를 써라. 넓은 의미의 오버로딩
	 */
	// 5. 특정 고객이 구입한 물건 중에서 최고가에 해당하는 물건의 가격을 리턴하는 기능
	public int maxPrice(Customer vo) {
		
		int max = 0;
		for (Product p : product) {
			if (p.getPrice() > max) {
				max = p.getPrice();
			}
		}
		return max;
	}

	// 6. 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 반환하는 기능
	public Product[] getMorePriceProduct(Customer[] customers, int price) {
		int size = 0;
		for (Customer c : customers) {
			if (c.getProducts() != null)
				size += c.getProducts().length;
		}

		Product[] temp = new Product[size];
		int idx = 0;
		for (Customer c : customers) {
			if (c.getProducts() == null)
				continue;
			for (Product p : c.getProducts()) {
				if (p.getPrice() >= price) {
					temp[idx++] = p;
				}

			}
		}

		return temp;
	}
}
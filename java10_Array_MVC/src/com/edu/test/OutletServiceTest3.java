package com.edu.test;

import com.edu.service.OutletService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletServiceTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] products1 = { new Product("신라면", 1200, 5, "농심"), new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "LG"), new Product("짐빔", 130000, 1, "JIM"), };

		Product[] products2 = { new Product("Terra", 2200000, 5, "농심"), new Product("맥심커피", 20000, 10, "농심"),
				new Product("휘센 에어컨", 14000000, 1, "대우")  };
		Customer c1 = new Customer(111,"이정재","방배동");
		Customer c2 = new Customer(111,"정우성","신사동");
		
		Customer[] customers = {c1, c2};
		OutletService service = new OutletService();
		Customer[] customer = null;
		Product[] pros = service.getAllProduct(customer[0]);
	}

}

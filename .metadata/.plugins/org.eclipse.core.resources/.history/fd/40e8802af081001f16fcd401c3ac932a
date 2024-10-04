package com.service.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.MyProduct;

@Service
public class MyService {
	
	@Autowired
	private MyProductDAO productdao;
	
	public void addProduct(MyProduct product) {
		productdao.addProduct(product);
	}

	public MyProduct findProductByName(String name) {
		return productdao.findProductByName(name);
	}

	public MyProduct findProductByMaker(String maker) {
		return productdao.findProductByMaker(maker);
	}

	public List<MyProduct> findProducts() {
		return productdao.findProducts();
	}
}

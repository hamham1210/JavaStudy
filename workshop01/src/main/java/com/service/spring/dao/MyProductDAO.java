package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAO {
	public static final String NS = "ns.sql.MyProductMapper.";

	@Autowired
	private SqlSession session;

	public void addProduct(MyProduct product) {
		session.insert(NS + "addProduct", product);
	}

	public MyProduct findProductByName(String name) {
		return session.selectOne(NS+"findProductByName",name);
	}

	public MyProduct findProductByMaker(String maker) {
		return session.selectOne(NS+"findProductByMaker",maker);
	}

	public List<MyProduct> findProducts() {
		return session.selectList(NS+"findProducts");
	}
}
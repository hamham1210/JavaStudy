package com.services.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.service.spring.domain.MyProduct;


public class MyBatisUnitTest {
	
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MyProduct pvo = new MyProduct("통돌이 세탁기","삼성",2300000);
		System.out.println("====================1. 상품 등록================");
		session.insert("ns.sql.MyProductMapper.addProduct",pvo);
		System.out.println("====================2. 상품명으로 검색================");
		MyProduct name = session.selectOne("ns.sql.MyProductMapper.findProductByName","세탁기");
		System.out.println("상품명으로 검색 결과 :"+name);
		System.out.println("====================3. 제조사명으로 검색================");
		MyProduct maker = session.selectOne("ns.sql.MyProductMapper.findProductByMaker","애플");
		System.out.println("상품명으로 검색 결과 :"+maker);
		System.out.println("====================4. 모든 상품 검색================");
		List<MyProduct> list= session.selectList("ns.sql.MyProductMapper.findProducts");
		System.out.println("상품 리스트");
		for(MyProduct i : list) {
			System.out.println(i); 
		}
	}
}
package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest2 {

	public static void main(String[] args) throws IOException {
		
		SqlSessionFactory factory =FactoryService.getFactory();
		//3)SqlSession 생성
		SqlSession session=factory.openSession();
		session.selectList("Sawonmapper.sawonList")
				.forEach(c->System.out.println(c));
		

		session.commit();
		session.close();
	}

}
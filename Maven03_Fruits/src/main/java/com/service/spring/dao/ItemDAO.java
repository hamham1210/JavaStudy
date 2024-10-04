package com.service.spring.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Item;
/*
 * POJO기반
 * */
@Repository
public class ItemDAO {

	public static final String NS = "ns.sql.FruitMapper.";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	public Item getItem(Integer itemid)throws Exception{
		return sqlSession.selectOne(NS+"getItem",itemid);
	}
	
	public List<Item> getItemList() throws Exception{
		return sqlSession.selectList(NS+"getItemList");
	}
	
}
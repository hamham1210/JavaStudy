package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Repository
public class PhoneDAO {
	
	@Autowired
	private SqlSession session;
	
	public static String NS = "ns.sql.Phone.";
	
	public void insert(Phone vo) {
		session.insert(NS+"insert",vo);
	}
	
	public Phone selectByOne(Phone vo) {
		return session.selectOne(NS+"select",vo);
	}
	
	public List<Phone> selectByList(){
		return session.selectList(NS+"select");
	}
	
	public UserInfo selectUser(UserInfo vo) {
		return session.selectOne(NS+"selectUser",vo);
	}
	
	public void delete(List<Phone> list) {
		session.delete(NS+"delete",list);
	}
	
	public void update(Phone vo) {
		session.update(NS+"update",vo);
	}
}

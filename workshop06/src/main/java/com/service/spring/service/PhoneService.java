package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Service
public class PhoneService {
	@Autowired
	private PhoneDAO dao;
	
	public void insert(Phone vo) {
		dao.insert(vo);
	}
	
	public Phone selectByOne(Phone vo) {
		return dao.selectByOne(vo);
	}
	
	public List<Phone> selectByList(){
		return dao.selectByList();
	}
	
	public UserInfo selectUser(UserInfo vo) {
		return dao.selectUser(vo);
	}
	
	public void delete(List<Phone> list) {
		dao.delete(list);
	}
	
	public void update(Phone vo) {
		dao.update(vo);
	}
}

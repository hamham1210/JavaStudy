package com.service.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.service.spring.dao.MemberDAO;
import com.service.spring.domain.Member;

@Repository
public class MemberService {

	@Autowired
	private MemberDAO memverDAO;
	
	
	public Member SelectUser(Member vo) {
		return memverDAO.SelectUser(vo);
	}
	
	
}

package com.service.mybatis.unit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {
	
	public static void main(String[] args) {
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session=factory.openSession();
		
		//1. memberList 전체 보기
		System.out.println("::1. memberList 전체 보기");
		List<MemberVO> list= session.selectList("MemberVOmapper.memberList");
		
		list.stream().forEach(c->System.out.println(c));
		
		//2.k가 들어간 member찾기
		System.out.println("::2.k가 들어간 member찾기");
		List<MemberVO> list2=session.selectList("MemberVOmapper.getMember","k");
		list2.forEach(c->System.out.println(c));
		//3. user_id가 kosta이신 분을 지우기
		System.out.println("::3. user_id가 kosta이신 분을 지우기");
		session.delete("MemberVOmapper.deleteMember","kosta");
		session.commit();
		System.out.println("kosta님 삭제 완료");
	}

}

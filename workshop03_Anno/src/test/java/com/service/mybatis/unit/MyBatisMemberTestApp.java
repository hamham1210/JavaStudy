package com.service.mybatis.unit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {
	
	public static void main(String[] args) {
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session=factory.openSession();
		MemberVO test = new MemberVO("test","pass","test","서울시");
//		//1. registerMember 멤버 등록하기
//		System.out.println("::1. registerMember 멤버 등록하기");
//		System.out.println(session.insert("MemberVOmapper.registerMember",test));
//		session.commit();
//		//2. updateMember 멤버 업데이트 하기
//		System.out.println("::2. updateMember 멤버 업데이트 하기");
//		test = new MemberVO("test","pass","홍종각","종각동");
//		System.out.println(session.update("MemberVOmapper.updateMember",test));
//		session.commit();
		//3. deleteMember 멤버 삭제하기
//		System.out.println("::3. deleteMember 멤버 삭제하기");
//		System.out.println(session.delete("MemberVOmapper.deleteMember",test.getId()));
//		session.commit();
		System.out.println("::4. memberList 동적쿼리(이름으로 검색)");
		test=new MemberVO("id","pass","test","주소");
		List<MemberVO> list= session.selectList("MemberVOmapper.showAllMember",test);
		list.stream().forEach(c->System.out.println(c));
		System.out.println("::5. 이름으로 찾기");
		MemberVO mem = session.selectOne("MemberVOmapper.getMember","아무개");
		System.out.println(mem);
		System.out.println("::6. 아이디가 존재하는지 찾기");
		boolean exist = session.selectOne("MemberVOmapper.idExist","시험");
		System.out.println("시험씨의 존재 여부 : "+exist);
		System.out.println("::7. 로그인 기능");
		test = new MemberVO("wang","1234");
		MemberVO exittest = session.selectOne("MemberVOmapper.login",test);
		System.out.println(exittest);
	}

}

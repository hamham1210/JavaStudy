package com.service.mybatis.unit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;

public class MyBatisMemberTestApp {
	
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {	"/bean/userservice12.xml"	 });
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		MemberVO test = new MemberVO("test","pass","test","서울시");
		//1. registerMember 멤버 등록하기
		System.out.println("::1. registerMember 멤버 등록하기");
		memberService.registerMember(test);
	
		//2. updateMember 멤버 업데이트 하기
		System.out.println("::2. updateMember 멤버 업데이트 하기");
		test = new MemberVO("test","pass","홍종각","종각동");
		memberService.updateMember(test);
	
		//3. deleteMember 멤버 삭제하기
		System.out.println("::3. deleteMember 멤버 삭제하기");
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		memberDAO.deleteMember("test");
		
		System.out.println("::4. memberList 동적쿼리(이름으로 검색)");
		test=new MemberVO("test","pass","홍종각","종각동");
		List<MemberVO> list= memberService.showAllMember(test);
		list.stream().forEach(c->System.out.println(c));
		
		System.out.println("::5. 이름으로 찾기");
		MemberVO mem = memberService.getMember("홍종각");
		System.out.println(mem);
		
		System.out.println("::6. 아이디가 존재하는지 찾기");
		boolean exist = memberService.idExist("test");
		System.out.println("시험씨의 존재 여부 : "+exist);
		System.out.println("::7. 로그인 기능");
		test = new MemberVO("test","pass");
		boolean exittest = memberService.login(mem);
		System.out.println(exittest);
	}

}

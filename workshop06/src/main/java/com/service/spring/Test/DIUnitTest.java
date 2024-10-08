package com.service.spring.Test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;


public class DIUnitTest {

	String[] context = {"/bean/businessBean.xml","/bean/presentationBean.xml"};
	ApplicationContext factory = new ClassPathXmlApplicationContext(context);
	
	PhoneService service=(PhoneService)factory.getBean("phoneService");
	//폰 기종 삽입
	@Test
	public void Test() {
		System.out.println("==========1.폰 기종 삽입===========");
		Phone vo = new Phone("A152s","애플16",2500000,"30");
		service.insert(vo); 
		
		System.out.println("==========2.전체 목록 확인=========");
		List<Phone> list= service.selectByList();
		for(Phone p : list) {
			System.out.println(p);
		}
		System.out.println("==========3.상세 검색하기=========");
		System.out.println(service.selectByOne(vo));
		  System.out.println("==========4.유저 검색하기========="); UserInfo uo = new
		  UserInfo("admin","admin"); System.out.println("로그인 기능");
		  System.out.println(service.selectUser(uo)); System.out.println("유저검색기능");
		  UserInfo uo2 = new UserInfo("java");
		  System.out.println(service.selectUser(uo2));
		  System.out.println("==========5.폰 상세 내역 업데이트========="); vo.setPrice(9000);
		  System.out.println("가격인상 확인"); service.update(vo);
//		  System.out.println("==========6.기종 삭제하기========="); 
//		  service.delete(list);
//		  System.out.println("삭제 내역 확인");
//		  List<Phone> list2= service.selectByList();
//		  for(Phone p : list2) { System.out.println(p); }
		
		
	}
}

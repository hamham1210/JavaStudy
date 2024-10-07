package com.service.spring.UnitTest;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;



public class DIUnitTest {
//	ApplicationContext factory = 
//			new ClassPathXmlApplicationContext("/bean/businessBean.xml");
//	
//	BoardService service=(BoardService)factory.getBean("boardService");
//	@Test
//	public void Test() throws IOException {
//		
//		
//		
//		Member mem = new Member("sawon","하바리","1234","종각동");
//		Board testBoard = new Board("메이븐 끝장내기","메이븐을 하기위한 절차 ...",mem);
//		
//		
//		try {
//			/*
//			 * System.out.println("글 작성 test"); service.write(testBoard);
//			 */
//			System.out.println("글작성 확인");
//			List<Board> list= service.getBoardList();
//			for(Board b:list)System.out.println(b);
//			System.out.println("내용보기");
//			System.out.println(service.showContent(2));
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	
}

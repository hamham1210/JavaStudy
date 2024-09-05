package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;
/*
 * Conponent란?
 * 인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 * 폼값 받아서
 * dao리턴 받고 비지니스 로직 호출 데이터 반환
 * 
 * */
public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("find_ok");
			mv.addObject("message", "스프링 프레임워크 쓰는중"+rvo.getName());
			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {

		}
		return new ModelAndView(path);
	}

}

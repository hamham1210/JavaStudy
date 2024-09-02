package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
		
		//결과 페이지 login_result.jsp
		//1. login페이지에서 폼값을 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path="index.html";
		//2. DAO리턴받고 비지니스 로직 호출.. 결과값 반영
		try {
			Member rvo= MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			/*
			 * Session에 바인딩 하는 경우
			 * 1)로그인 로직...
			 * 2)정보수정 로직...
			 * */
			
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet..JSESSIONID::"+ session.getId());
				path="login_result.jsp";
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			path= "login_fail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
		
		//3. 세션 받아와서 바인딩(vo!=null일때만)
		//4.네비게이션
	}

}

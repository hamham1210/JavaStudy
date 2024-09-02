package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로직은 여기서 작성.. 한글처리 안해도 된다.(필터등록을 했기때문)
		// command값 받아온다.
		String command = request.getParameter("command");
		String path="index.html";
		if (command.equals("find")) {
		path=find(request, response);
			
		} else if (command.equals("login")) {
			path=login(request, response);

		} else if (command.equals("register")) {

			path=register(request, response);
		} else if (command.equals("showAll")) {
			path=showAll(request, response);

		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String find(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);

			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {

		}
		return path;
	}

private String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
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
		return path;
		
		
		//3. 세션 받아와서 바인딩(vo!=null일때만)
		//4.네비게이션
}

private String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

	String id = request.getParameter("id");
	String password = request.getParameter("pass");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	Member pvo = null;
	String path="index.html";
	System.out.println("여기까지 성공1");
	try {
	if(name.equals("")||password.equals("")) {
		 pvo = new Member(id,password);
		 System.out.println("여기까지 성공2");
	}else {
		pvo = new Member(id,password,name,address);
		System.out.println("여기까지 성공2");
	}
		MemberDAOImpl.getInstance().registerMember(pvo);
		System.out.println("여기까지 성공3");
		path = "register_result.jsp";
		System.out.println("직원등록 성공");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return path;
}
private String showAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	String path="allView.jsp";
	try {
		ArrayList<Member> list=	MemberDAOImpl.getInstance().showAllMember();
		
		request.setAttribute("list", list);
		
		} catch (SQLException e) {
			System.out.println(e);
		}
	return path;
}
}
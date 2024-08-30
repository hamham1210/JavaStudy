package sevlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//Dao리턴 받아서... 비지니스 로직 호출..vo객체 반환했다고 치고
		Member rvo = new Member(id,password,"홍종각","종각");
		
		//바인딩... 세션.. 얻어와야한다.
		//클라이언트가 요청하는 순간 req,res와 함께 서버상에 만들어진다.
		//세션 안에는 클라언트(브라우저)를 구분하기 위한 고유한 값...JSESSIONID..getId()
		HttpSession session = request.getSession();
		System.out.println("LoginServlet JSESSIONID::"+session.getId());
		
		session.setAttribute("vo", rvo);
		//네비게이션
		response.sendRedirect("BuyServlet");
	}

}

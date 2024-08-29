package web.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//쿠키 생성
		Cookie c = new Cookie("hyerin","내가만든쿠키");
		Cookie c2 = new Cookie("minji","너를위해구웠지");
		//쿠키 정보 저장 시간 지정
		c.setMaxAge(24*60*60);//하루 저장
		c2.setMaxAge(24*60*60*2);//이틀 저장
		//클라이언트로 보냄
		response.addCookie(c);
		response.addCookie(c2);
		
		//페이지이동
		response.sendRedirect("getCookie.jsp");
	}

}
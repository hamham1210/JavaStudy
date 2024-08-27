package web.Servlet.greet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GreetServlet extends HttpServlet {
	private String greet="";
	private String name="";
	public void GreetServlet() {
		
	}
	@Override
	public void init()throws ServletException {
		System.out.println("2. ServletConfig생성... init()호출");
		greet = getInitParameter("Greet");//필드 초기화
		System.out.println("get message ::"+greet);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 클아이언트 요청시 호출 폼값만 받아온다.");
		//클라이언트의 요청을 처리...
		
		PrintWriter out = response.getWriter();
		name = request.getParameter("name");//필드 초기화
		
		out.println("<html><body><h3>");
		out.println("<h3>"+name+"Hello Welcome to Olymphic Games</h3>");
		out.println("</h3></body></html");
		
}
	
}

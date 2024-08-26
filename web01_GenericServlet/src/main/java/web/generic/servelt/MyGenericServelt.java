package web.generic.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServelt extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html><body><h2>");//브라우저로 ()안에 있는 내용을 출력
		out.println("Hello MyGenericServlet~~!!");
		out.println("</h2></body></html>");
	}
//req 요청정보 담는 객체..db로 
//res 응답할 정보를 담는 객체..브라우저로 출력
	/*
	 * 1. Context Path... was 안으로 배포
	 * 2.서버 가동
	 * 3.브라우저로 요청
	 * 
	 * http://localhost:8888/web01_GenericServlet/
	 * */
}

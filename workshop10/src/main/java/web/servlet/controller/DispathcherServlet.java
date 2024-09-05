package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class DispathcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	
	/*
	 * 이전 방식과 다른 점
	 * hidden태그로 요청을 제각각 받지 않는다.
	 * 들어온 요청의 주소를 직접 인식시킨다.
	 * */
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response){
		
		String RequestURI= request.getRequestURI();//contextpath를 받는다. 
		//결과 예시 web20_factoryPattern/find.do
		System.out.println("RequestURI="+RequestURI);
		String ContextPath = request.getContextPath();
		//결과 예시 web20_factoryPattern
		//find.do만 추출하자.
		String command = RequestURI.substring(ContextPath.length()+1);
		//결과 예시 find.do
		System.out.println("command="+command);
		//1.HandlerMapping의 createComponent 함수를 호출.. 이때 위에서 받은 command값을 넣어준다.
		Controller controller=	HandlerMapping.getFactory().createComponent(command);
		System.out.println("controller="+controller);
		//Controller반환 command를 주고
		//2.Controller의 메소드 호출...ModelAndView반환
		//네비게이션
		ModelAndView mv =null;
		String path = "index.jsp";
		try {
		mv =controller.handleRequest(request, response);
		//3.mv안에 있는 값을 찾는다.
		System.out.println("ModelAndView="+mv);
		path = mv.getPath();
		
			if(mv!=null) {
			if(mv.isRedict()) response.sendRedirect(path);
			else {
				request.getRequestDispatcher(path).forward(request, response);
			}
			}}catch(Exception e) {
				System.out.println(e);
			}
			
 	}

}

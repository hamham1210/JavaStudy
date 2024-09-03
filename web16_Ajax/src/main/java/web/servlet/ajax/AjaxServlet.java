package web.servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/front.do")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼값 받아서
		String id = request.getParameter("id");
		//DAO 비지니스 로직 호출 시 인자값으로
		
		//vo반환값 받아서...바인딩
		
		
		//쓰레드 통제해서 시간 제어하기
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		//네비게이션...result.jsp
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}

}

package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ParameterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//2.PrintWriter객체 반환
		PrintWriter out = response.getWriter();
		//3. 폼값 받아서
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String word = request.getParameter("searchWord");
		//4. 웹 브라우저로 출력
		StringBuffer sb = new StringBuffer();
		sb.append("<h2> job :").append(String.valueOf(job)).append("</h2>");
		sb.append("<h2> pageNO :").append(String.valueOf(pageNo)).append("</h2>");
		sb.append("<h2> searchWord :").append(String.valueOf(word)).append("</h2>");

	
	out.println("<h2>실습중입니다</h2>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//2.PrintWriter객체 반환
				PrintWriter out = response.getWriter();
		//3. 폼값 받아서...
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		String[] hobby=request.getParameterValues("hobby");
		String[] favorite = request.getParameterValues("favorite");
		String desc = request.getParameter("desc");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h3> name :").append(name).append("</h3>");
		sb.append("<h3> email :").append(email).append("</h3>");
		sb.append("<h3> gender :").append(gender).append("</h3>");
		/*
		 * sb.append("<h3> hobby :").append(hobby).append("</h3>");
		 * sb.append("<h3> favorite :").append(favorite).append("</h3>");
		 */
		sb.append("<h3> desc :").append(desc).append("</h3>");
	
		out.println(sb.toString());
	}

}

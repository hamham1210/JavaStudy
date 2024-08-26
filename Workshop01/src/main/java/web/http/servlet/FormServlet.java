package web.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FormServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("userId");
		String password = request.getParameter("userPass");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>"+username+"님<br><br>");
		out.println("로그인 성공^^");
		out.println("</h3></body></html>");
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}

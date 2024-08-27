package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LifeCycle"},
loadOnStartup = 1
)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init()throws ServletException {
		System.out.println("LifeCycle init블록입니다.");
	}
	@Override
	public void destroy() {
		System.out.println("LifeCycle destroy블록입니다.");
	}
	
	 public LifeCycleServlet() {
	System.out.println("LifeCycle 생성자블록입니다.");
	     
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycle doGet블록입니다.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>안녕하세요, LifeCycleServlet입니다.</h2>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycle doPost블록입니다.");
	}

}

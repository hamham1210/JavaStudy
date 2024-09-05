package web.servlet.controller.container;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI= request.getRequestURI();
	
		System.out.println("RequestURI="+RequestURI);
		String ContextPath = request.getContextPath();
		
		String command = RequestURI.substring(ContextPath.length()+1);
		
		System.out.println("command="+command);
		
		Controller controller =	HandlerMapping.getFactory().createComponent(command);
		
		ModelAndView mv =null;
		String path = "index.jsp";
		mv = controller.handleRequest(request, response);
		
		path = mv.getPath();
		
		if(mv!=null) {
			if(mv.isRedict()) response.sendRedirect(path);
			else {
				request.getRequestDispatcher(path).forward(request, response);
			}
			}
			
	}
}

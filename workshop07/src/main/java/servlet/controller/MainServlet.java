package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import servlet.model.User;
import servlet.model.UserImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Login")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MainServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path = "loginError.jsp";
		User user = new User();
		try {
			user = UserImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			if(user !=null) {
				session.setAttribute("user", user);
				System.out.println("LoginServlet JSESSION:"+session.getId());
				path="loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}

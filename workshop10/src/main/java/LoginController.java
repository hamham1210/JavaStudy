import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.User;
import servlet.model.UserImpl;
import web.servlet.controller.Controller;
import web.servlet.controller.ModelAndView;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path = "loginError.jsp";
		User user = new User();
		HttpSession session = request.getSession();
		try {
			user = UserImpl.getInstance().login(id, pass);
			
			if(user !=null) {
				session.setAttribute("user", user);
				System.out.println("LoginServlet JSESSION:"+session.getId());
				path="loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

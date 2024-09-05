package web.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.controller.container.Controller;
import web.servlet.controller.container.ModelAndView;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="login.jsp";
		try {
			//세션을 죽이는 로직(invalidate는 태그로 대체 불가해서)
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") !=null) {//로그인이 되어져 있다면...
				session.invalidate();
				path="logout.jsp";
			}
			} catch (Exception e) {
				System.out.println(e);
			}
		return new ModelAndView(path);
	}

}

package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.controller.container.Controller;
import web.servlet.controller.container.ModelAndView;
import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);

			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

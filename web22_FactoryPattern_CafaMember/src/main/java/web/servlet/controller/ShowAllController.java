package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.controller.container.Controller;
import web.servlet.controller.container.ModelAndView;
import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class ShowAllController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="allView.jsp";
		try {
			ArrayList<Member> list=	MemberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			
			} catch (SQLException e) {
				System.out.println(e);
			}
		return new ModelAndView(path);
	}

}

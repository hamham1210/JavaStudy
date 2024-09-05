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

public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = null;
		String path="index.html";
		System.out.println("여기까지 성공1");
		try {
		if(name.equals("")||password.equals("")) {
			 pvo = new Member(id,password);
			
		}else {
			pvo = new Member(id,password,name,address);
			
		}
			MemberDAOImpl.getInstance().registerMember(pvo);
			
			path = "register_result.jsp";
			System.out.println("직원등록 성공");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
		
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
			 System.out.println("여기까지 성공2");
		}else {
			pvo = new Member(id,password,name,address);
			System.out.println("여기까지 성공2");
		}
			MemberDAOImpl.getInstance().registerMember(pvo);
			System.out.println("여기까지 성공3");
			path = "register_result.jsp";
			System.out.println("직원등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}

package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookImpl;
import servlet.model.User;
import servlet.model.UserImpl;

@WebServlet("/front.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	protected void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String path="book.html";
		if(command.equals("register")) {
			path=register(request,response);
		}else if (command.equals("showAllBook")) {
			path=showAllBook(request,response);
		}else if(command.equals("login")) {
			path=login(request,response);
		}else if(command.equals("searchBook")) {
			path=searchBook(request,response);
	
		}else if(command.equals("searchTitle")) {
			path=searchTitle(request,response);
	
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	

	
	private String searchTitle(HttpServletRequest request, HttpServletResponse response) {
		String path="book.html";
		String title= request.getParameter("title");
		System.out.println(title);
		try {
			Book book = BookImpl.getInstance().searchTitle(title);
			request.setAttribute("book", book);
			path="booklist.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "detail.jsp";
	}

	private String showAllBook(HttpServletRequest request, HttpServletResponse response) {
		String path="book.html";
		
		try {
			ArrayList<Book> list = BookImpl.getInstance().showAllBook();
			request.setAttribute("list", list);
			path="booklist.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return path;
	}
	
	private String searchBook(HttpServletRequest request, HttpServletResponse response) {
		String path="book.html";
		String cond = request.getParameter("bookCategory");
		String condDesc = request.getParameter("condDesc");
		System.out.println(cond+","+condDesc);
		try {
			ArrayList<Book> list = BookImpl.getInstance().searchBook(cond,condDesc);
			request.setAttribute("list", list);
			path="booklist.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}
	
private String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String path="book.jsp";
		String[] isbn = request.getParameterValues("bookNo");
		String title = request.getParameter("bookTitle");
		String category = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publisher = request.getParameter("bookPublisher");
		String Date = request.getParameter("bookDate");
		String Author = request.getParameter("bookAuthor");
		String price = request.getParameter("bookPrice");
		String Summary = request.getParameter("bookSummary");
		String newisbn = "";
		if (isbn.length <= 4) {
			newisbn = isbn[0] + "-" + isbn[1] + "-" + isbn[2];
			System.out.println(newisbn);
			for (String part : isbn) {
			    System.out.println("ISBN 부분: " + part);
			}
		}
		HttpSession session = request.getSession();
		System.out.println("BookServlet JSESSION:"+session.getId());
		if (session.getAttribute("user") != null) {
			try {
				Book book = new Book(newisbn, title, category, nation, Date, publisher, Author, Integer.parseInt(price),
						Summary);
				BookImpl.getInstance().registerBook(book);
				request.setAttribute("book", book);
				request.setAttribute("msg", "책 정보가 정상적으로 저장되었습니다.");
				path="bookSuccess.jsp";
			} catch (SQLException e) {
				System.out.println(e);
				request.setAttribute("msg", "책 등록 중 오류발생... 정보저장 실패!");
				path="bookSuccess.jsp";
			}
		}
		return path;
		
	}
}
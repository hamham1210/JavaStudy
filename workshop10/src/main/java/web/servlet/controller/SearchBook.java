package web.servlet.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookImpl;
import web.servlet.controller.Controller;
import web.servlet.controller.ModelAndView;

public class SearchBook implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		return new ModelAndView(path);
	}

}

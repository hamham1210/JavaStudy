import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookImpl;
import web.servlet.controller.Controller;
import web.servlet.controller.ModelAndView;

public class SearchTitle implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="book.jsp";
		String title= request.getParameter("title");
		System.out.println(title);
		try {
			Book book = BookImpl.getInstance().searchTitle(title);
			request.setAttribute("book", book);
			path="detail.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

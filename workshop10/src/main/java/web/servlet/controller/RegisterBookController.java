package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookImpl;

public class RegisterBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="index.jsp";
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
				path="Error.jsp";
			}
		}
		return new ModelAndView(path);
	}

}

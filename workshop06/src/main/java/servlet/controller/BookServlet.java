package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookImpl;

@WebServlet("/BookServlet")
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

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
		if (isbn.length >= 4) {
			newisbn = isbn[0] + "-" + isbn[1] + "-" + isbn[2];
		}
		HttpSession session = request.getSession();
		System.out.println("BookServlet JSESSION:"+session.getId());
		if (session.getAttribute("user") != null) {
			
			try {
				Book book = new Book(newisbn, title, category, nation, Date, publisher, Author, Integer.parseInt(price),
						Summary);
				BookImpl.getInstance().registerBook(book);
				request.setAttribute("book", book);
				request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println(e);
			}
		} else {
			response.sendRedirect("login.html");
		}

	}
}

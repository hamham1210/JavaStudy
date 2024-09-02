package servlet.controller;

import java.awt.print.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProccess(request, response);
	}
	
	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] isbn= request.getParameterValues("bookNO");
		String title = request.getParameter("bookTitle");
		String category = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String Date = request.getParameter("bookPublisher");
		String Author = request.getParameter("bookAuthor");
		String price =request.getParameter("bookPrice");
		String Summary=request.getParameter("bookSummary");		
		Book book = new Book();
//		BookImpl.getinstance().registerBook();
	}

}

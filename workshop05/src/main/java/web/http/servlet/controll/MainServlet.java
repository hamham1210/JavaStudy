package web.http.servlet.controll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.servlet.model.Product;
import web.http.servlet.model.ProductDAOImpl;


@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}

	
	protected void doProcces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		Product pvo = new Product(name,Integer.parseInt(price),description);
		
		try {
			ProductDAOImpl.getInstance().registerProduct(pvo);
			
			response.sendRedirect("List");
		} catch (SQLException e) {
			
			System.out.println(e);
		}
		
		
	}
}

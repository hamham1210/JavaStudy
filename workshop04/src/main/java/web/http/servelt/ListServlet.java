package web.http.servelt;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.vo.Product;


@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Product> list = null;
    public ListServlet() {
		list= new ArrayList<Product>();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.Dao에서 list를 보여주는 메소드 호출 및 데이터 반환
		 * 2.바인딩
		 * 3.네비게이션
		 * */
		Product p1 = new Product(1,"AAA",450000,"A++");
		Product p2 = new Product(2,"BBB",50000,"B++");
		Product p3 = new Product(3,"CCC",5000,"C++");
		list.add(p1);list.add(p2);list.add(p3);
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	

}

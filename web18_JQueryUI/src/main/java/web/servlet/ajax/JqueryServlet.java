package web.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JqueryServlet
 */
@WebServlet("/front.do")
public class JqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		if (command.equals("subject")) {

			subject(request, response);
		} else if (command.equals("company")) {

			company(request, response);
		}
	}

	private void subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "빅데이터|파이슨|자바|모델링|스프링MVC";

		PrintWriter out = response.getWriter();

		out.print(result);// ajax successfunction의 인자값이 된다.

	}

	private void company(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "<ul><li>토마토 시스템</li><br><li>고양이시스템</li><br><li>이찬영 시스템</li><br><ul>";
		PrintWriter out = response.getWriter();

		out.print(result);
	}

}

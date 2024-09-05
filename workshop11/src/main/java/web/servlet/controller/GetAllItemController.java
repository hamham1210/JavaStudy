package web.servlet.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.servlet.controller.container.Controller;
import web.servlet.controller.container.ModelAndView;
import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class GetAllItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path="index.jsp";
		try {
			ArrayList<Item> list = ItemDao.getInstance().getAllItem();
			request.setAttribute("list", list);
			path="itemList.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
	
		return new ModelAndView(path);
	}

}

package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.controller.container.Controller;
import web.servlet.controller.container.ModelAndView;
import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class GetItemController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "itemList.jsp";
		String itemid= request.getParameter("id");
		try {
		Item item =	ItemDao.getInstance().getItem(Integer.parseInt(itemid));
		request.setAttribute("item", item);
		path ="itemView.jsp"; 
		} catch (NumberFormatException | SQLException e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}

}

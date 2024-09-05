package web.servlet.controller.container;

import web.servlet.controller.GetAllItemController;
import web.servlet.controller.GetItemController;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
	}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("itemList.do")) {
			controller = new GetAllItemController();
		}else if(command.equals("itemView.do")) {
			controller = new GetItemController();
		}
		
		return controller;
		
	}
	
}

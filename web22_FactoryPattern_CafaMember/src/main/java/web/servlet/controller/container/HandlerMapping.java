package web.servlet.controller.container;

import web.servlet.controller.FindController;
import web.servlet.controller.LoginController;
import web.servlet.controller.LogoutController;
import web.servlet.controller.RegisterController;
import web.servlet.controller.ShowAllController;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
	}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller = new FindController();
		}else if(command.equals("login.do")) {
			controller = new LoginController();
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}else if(command.equals("register.do")){
			controller = new RegisterController();
		}else if(command.equals("showall.do")){
			controller = new ShowAllController();
		}
		
		return controller;
		
	}
	
}

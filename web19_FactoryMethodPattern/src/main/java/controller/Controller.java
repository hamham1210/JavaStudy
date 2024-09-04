package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	String handle(HttpServletRequest reuqest,HttpServletResponse response);
	
}

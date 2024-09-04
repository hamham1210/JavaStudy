package client;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;

public class FrontController {
	static HttpServletRequest request = null;
	static HttpServletResponse response = null;
	public static void main(String[] args) {
		//폼으로 받은 값으로 생각하자...
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("커맨드 값 입력");
		String commmand = sc.next();
		
		//1.
		Controller controller = ControllerFactory.getinstance().createController(commmand);
		//2.
		String path = controller.handle(request, response);
		//3.
		System.out.println(path);
	}

}

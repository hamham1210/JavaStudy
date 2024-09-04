package controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {};
	
	public static ControllerFactory getinstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller conn = null;
		
		if(command.equals("register")) {
			conn = RegisterController.getinstance();
			System.out.println("레지스터 컨트롤러 인스턴스 생성");
	}else if(command.equals("find")){
		conn = FindController.getinstance();
		System.out.println("파인드 컨트롤러 인스턴스 생성");
	}
		return conn;
	}
	
	
}

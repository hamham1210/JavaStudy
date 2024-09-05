package web.servlet.controller;

//Component를 생성하는 일종의 공장
//서블릿이 전해주는 command 값에 따라서 Component를 생성
//그리고 다시 서블릿에게 생성한 Component를 반환할때는 Controller인터페이스 타입으로 반환
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
	}
	public static HandlerMapping getFactory() {
		return factory;
	}
	//Component생성하는 기능...
	public Controller createComponent(String command) {
		Controller controller = null;
		String path = "index.jsp";
		if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("FindController 생성");
		}else if(command.equals("register.do")) {
			controller = new RegisterBookController();
			System.out.println("RegisterBookController 생성");
		}else if(command.equals("SearchBook.do")) {
			controller = new SearchBook();
			System.out.println("searchBookController 생성");
		}
		else if(command.equals("searchTitle.do")) {
			controller = new SearchTitle();
			System.out.println("searchTitleController 생성");
		}
		else if(command.equals("showAllBook.do")) {
			controller = new ShowAllBookController();
			System.out.println("showAllBook 생성");
		}
		return controller;
	}
	
}

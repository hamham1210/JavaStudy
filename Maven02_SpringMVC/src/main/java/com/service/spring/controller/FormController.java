package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.vo.User;

@Controller
public class FormController {
	//html 폼의 값이 자동으로 컨트롤러에 바인딩 ...
	@RequestMapping("/form.do")
	public ModelAndView form(User user) {
		/*1.폼값 받아서
		 * 	String name= request.getParameter("userName");
		 * 	request.getParameter("userAddr");
		 * 	requset.getParameter("id");
		 * 2. pvo생성
		 * 	User pvo = new User();
		 * 	pvo.set()으로 주입이 일어난다.
		 * */
		return new ModelAndView("result","info",user);
	}
}
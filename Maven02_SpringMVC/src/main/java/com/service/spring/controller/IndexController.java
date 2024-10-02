package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Controller를 작성하는 방법
 * 1. Controller 인터페이스를 상속
 * 2. POJO로 만드는 방법!!!-->@Annotation --><bean>이 부분이 생략
 * */
@Controller
public class IndexController {
	@RequestMapping("/index.do")//함수와 해당 url을 매핑
	public ModelAndView doIndex() {
		/*
		 * 1. 폼값 받아서
		 * 2. DAO리턴 받고 비지니스 로직 호출
		 * 3. 바이딩--> ServletRequest에 자동 바인딩
		 * 4. 네비게이션 -->forwarding
		 * */
		
		return new ModelAndView("result","info","Plain Old Java Object");
	}
}

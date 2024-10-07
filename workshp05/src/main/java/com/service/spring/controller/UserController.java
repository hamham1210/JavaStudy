package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user,HttpServletRequest request) throws Exception{
		
		System.out.println("sql전 user"+user);
		String path ="index";
		if(user !=null) {
		userService.getUser(user);
		System.out.println("sql후 user"+user);
		request.getSession().setAttribute("user", user);
		}
		return new ModelAndView(path,"user",user);
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout() throws Exception{
		
		
		return new ModelAndView();
	}

}
















package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("login.do")
	public String doLogin(Member pvo,HttpSession sesssion,Model model) {
		String msg ="로그인 시 에러 발생";
		String path = "Error";
		
		try {
		Member rvo=	service.SelectUser(pvo);
		if(rvo!=null) {
			sesssion.setAttribute("mvo", rvo);
			path = "member/login_result";
			msg="로그인 성공";
		}
		}catch(Exception e) {
			model.addAttribute(msg);
		}
		return path;
	}
	
	@RequestMapping("logout.do")
	public String doLogout(HttpSession sesssion) {
		sesssion.invalidate();
		
		return "redirect:index.jsp";
	}
	
}

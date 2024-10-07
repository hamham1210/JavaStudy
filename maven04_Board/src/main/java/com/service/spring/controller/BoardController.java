package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("write.do")
	public ModelAndView write(Board bvo, HttpSession session) {
		
		Member mvo= (Member)session.getAttribute("mvo");
		
		String path = "Error";
		if(mvo==null) {
			path= "redirect:index.jsp";
		}
		try {
			bvo.setMemberVO(mvo);
			System.out.println(bvo);
			service.write(bvo);
			path = "board/show_content";
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path,"bvo",bvo);
		
	}
}

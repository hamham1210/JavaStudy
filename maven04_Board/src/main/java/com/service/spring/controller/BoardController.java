package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	@Autowired
	private BoardDAO dao;
	
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
	
	@RequestMapping("list.do")
	public String list(Model model) {
		String path = "Error";
		String message = "전체목록 보기 중 오류가 났습니다.";
		try {
		List<Board> list =service.getBoardList();
		model.addAttribute("list",list);
		path= "board/list";
		}catch(Exception e){
			model.addAttribute("message",message);
			System.out.println(e);
		}
		return path;
	}
	@RequestMapping("showContent.do")
	public String showDetail(Model model, HttpSession session,Board vo) {
		String path="Error";
		String message="상세 목록 보기 중 오류가 났습니다.";
		Member mvo= (Member)session.getAttribute("mvo");
		try {
			if(mvo!=null) {
				service.updateCount(vo.getNo());
				Board bvo= service.showContent(vo.getNo());
				System.out.println(bvo);
				model.addAttribute("bvo",bvo);
				path="board/show_content";
			}else {
				path="redirect:index.jsp";
			}
		}catch(Exception e) {
			model.addAttribute("message",message);
			System.out.println(e);
		}
		return path;
	}
	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model) {
		String path = "Error";
		String message="삭제 중 오류 발생";
		try {
			dao.deleteBoard(no);
			path = "redirect:list.do";
		}catch(Exception e) {
			model.addAttribute("message",message);
			System.out.println(e);
		}
		return path;
	}
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model) {
		String path = "Error";
		String message="수정 중 오류 발생";
		try {
			Board bvo = service.showContent(no);
			model.addAttribute("bvo",bvo);
			path = "board/update";
		} catch (Exception e) {
			model.addAttribute("message",message);
			System.out.println(e);
		}
		return path;
	}
	
	@RequestMapping("updateBoard.do")
	public String doUpdate(Board vo, Model model,HttpSession session) {
		String path = "Error";
		String message="수정 중 오류 발생";
		System.out.println("작성자의 정보"+vo);
		try {
			service.updateBoard(vo);
			Board board = service.showContent(vo.getNo());//를 호출함으로서 유저 정보를 다시 가져온다.
			model.addAttribute("bvo",board);
			System.out.println("보드의 정보"+board);
			path = "board/show_content";
		} catch (Exception e) {
			model.addAttribute("message",message);
			System.out.println(e);
		}
		return path;
	}
}

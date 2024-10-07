package com.service.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("bookList.do")
	public ModelAndView getBooks() throws Exception {
		List<Book> list = bookService.getBooks();

		return new ModelAndView("book/bookList", "list", list);
	}

	@PostMapping("bookRegister.do")
	public ModelAndView register(String isbn1, String isbn2, String isbn3, Book book, HttpServletRequest request)
			throws Exception {
		System.out.println("register BookVO before:: " + book);// ?
		String newIsbn = isbn1 + "-" + isbn2 + "-" + isbn3;
		System.out.println("isbn 확인" + newIsbn);
		book.setIsbn(newIsbn);

		String msg = "책 등록에 실패하였습니다.";
		String path = "redirect:Error.jsp";
		try {
			bookService.insertBook(book);
			msg = "책이 정상 등록되었습니다.";
			path = "redirect:result.jsp";
		} catch (DuplicateKeyException e) {
			System.out.println("register...실패...키중복" + e);
			msg = "기존에 등록된 정보입니다.";
		} catch (SQLException e) {
			System.out.println("책등록 실패" + e);
		}
		request.getSession().setAttribute("msg", msg);
		// 현재 리다이렉트 방식으로 진행하기 때문에 해당 메시지를 출력하기 위해서는 리다이렉트 해야한다.
		return new ModelAndView(path);
	}

	@GetMapping("bookSearch.do")
	public ModelAndView search(String searchField, String searchText) throws Exception {

		List<Book> list = null;
		String path = "redirect:Error.jsp";
		String msg = "도서 검색 중 오류가 발생했습니다.";

		try {
			switch (searchField) {
			case "TITLE":
				list = bookService.searchByTitle(searchText);
				break;
			case "PUBLISHER":
				bookService.searchByPublisher(searchText);
				break;
			case "PRICE":
				bookService.searchByPrice(Integer.parseInt(searchText));
				break;
			default:
				list = bookService.getBooks();
				break;
			}
			path="book/booklist";
			msg="도서검색을 정상적으로  수행했습니다.";
		} catch (Exception e) {
			System.out.println("책 검색 중 에러"+e);
		}
		return new ModelAndView(path,"list",list);
	}

	@GetMapping("bookView.do")
	public ModelAndView bookview(String isbn) throws Exception {
		Book book = null;
		String path = "redirect:Error.jsp";
		String msg = "isbn으로 검색 중 오류가 발생했습니다.";
		try {
			book = bookService.searchByIsbn(isbn);
			msg="isbn으로 검색 성공";
			path="book/bookView";
		} catch (Exception e) {
			System.out.println("Bookview 수행 중 에러 발생"+e);
		}
		return new ModelAndView(path,"book",book);
	}

}//

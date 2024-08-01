package com.dao.test;
import java.sql.SQLException;


import java.util.List;

import com.dao.dao.BookDAO;
import com.dao.exception.DMLException;
import com.dao.exception.DuplicateNumException;
import com.dao.exception.RecordNotException;
import com.edu.vo.Book;


public class Test {

	public static void main(String[] args) throws DMLException, DuplicateNumException  {
		BookDAO dao = BookDAO.getInstance();
		Book book = new Book();

		//3. Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능을 구현한다.
//		printAllBooks(dao.showBookList());
		//4. 이름이 ‘ 김XX ’인 저자의 도서명, isbn, 출판사를 출력하는 기능을 작성한다.
		printAllBooks(dao.searchBookByLastname("김"));
		//5. Author 테이블에 있는 저자명 별로 출간된 도서들을 도서명, 출판사, 가격,저자명을 출력하는 기능을 구현한다
		 printAllBooks(dao.searchByName());
		/*6. Book 테이블에 있는 title와 publisher를 이용하여 서로의 관계를 다음과 같이
		 출력되도록 기능을 구현한다. ( ‘IoT세상은 미래닷컴에서 출판했다’)*/

		List<Book> list= dao.printTitle();
		for (Book b : list){
			System.out.println(b.getTitle()+"은 "+ b.getPublisher()+"에서 출판했다.");
		}

	
	}
	
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	
	
	

}

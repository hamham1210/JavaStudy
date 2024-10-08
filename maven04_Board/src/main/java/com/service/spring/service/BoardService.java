package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	
	
	
	public int write(Board board) {
		System.out.println("no,date 설정 전"+board);
		int row =boardDao.write(board);
		String date = boardDao.selectByNoForDate(board.getNo());
		board.setWriteDate(date);
		
		System.out.println("date 설정 후"+board);
		return row;
	}
	
	public List<Board> getBoardList(){
		return boardDao.getBoardList();
	}
	
	public Board showContent(int no) {
		return boardDao.showContent(no);
	}
	public String selectByNoForDate(int no) {
		return boardDao.selectByNoForDate(no);
	}
	
	public void updateCount(int no) {
		boardDao.updateCount(no);
	}
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
}

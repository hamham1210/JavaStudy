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
	
	
	
	public void write(Board board) {
		boardDao.write(board);
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

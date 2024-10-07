package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	public static final String NS = "ns.sql.Board.";
	public void write(Board board) {
		sqlsession.insert(NS+"write", board);
	}
	
	public List<Board> getBoardList(){
		return sqlsession.selectList(NS+"getBoardList");
	}
	
	public Board showContent(int no) {
		return sqlsession.selectOne(NS+"showContent",no);
	}
	
	public String selectByNoForDate(int no) {
		return sqlsession.selectOne(NS+"selectByNoForDate",no);
	}
	
	public void deleteBoard(int no) {
		sqlsession.delete(NS+"deleteBoard",no);
	}
	public void updateCount(int no) {
		sqlsession.update(NS+"updateCount",no);
	}
	public void updateBoard(Board board) {
		sqlsession.update(NS+"updateBoard",board);
	}
}

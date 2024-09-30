package spring.service.member.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.member.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;
	// mapper의 이름 상수값으로 선언
	public static final String NS = "MemberVOmapper.";

	

	@Override
	public void registerMember(MemberVO mem) {
		sqlSession.insert(NS+"registerMember",mem);
	}

	@Override
	public void updateMember(MemberVO mem) {
		sqlSession.update(NS+"updateMember",mem);
	}


	@Override
	public List<MemberVO> showAllMember(MemberVO mem) {
		List<MemberVO> list = sqlSession.selectList(NS+"showAllMember",mem);
		return list;
	}

	@Override
	public MemberVO getMember(String name) {
		MemberVO mem =sqlSession.selectOne(NS+"getMember",name);
		return mem;
	}

	@Override
	public boolean idExist(String id) {
		boolean exist = sqlSession.selectOne(NS+"idExist",id);
		return exist;
	}

	@Override
	public boolean login(MemberVO mem) {
		boolean login = sqlSession.selectOne(NS+"login",mem);
		return login;
	}

}

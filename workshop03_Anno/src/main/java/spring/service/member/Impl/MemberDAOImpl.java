package spring.service.member.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	//component-scan을 쓸 경우 setter로 의존성 주입대신 @으로 의존성 주입
		@Autowired
		private SqlSession sqlSession;
		//mapper의 이름 상수값으로 선언
		public static final String NS="MemberVOmapper.";
	@Override
	public int registerMember(MemberVO mem) {
		int result = sqlSession.insert(NS+"registerMember",mem);
		return result;
	}

	@Override
	public int updateMember(MemberVO mem) {
		int result = sqlSession.update(NS+"updateMember",mem);
		return result;
		
	}

	@Override
	public int deleteMember(String id) {
		int result = sqlSession.delete(NS+"deleteMember",id);
		return result;
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO mem) {
		List<MemberVO> list = sqlSession.selectList(NS+"showAllMember",mem); 
		return list;
	}

	@Override
	public MemberVO getMember(String name) {
		MemberVO mem = sqlSession.selectOne(NS+"getMember",name);
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

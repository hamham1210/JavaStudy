package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO mem);
	int updateMember(MemberVO mem);
	int deleteMember(String id);
	List<MemberVO> showAllMember(MemberVO mem);
	MemberVO getMember(String name);
	boolean idExist(String id);
	boolean login(MemberVO mem);
}

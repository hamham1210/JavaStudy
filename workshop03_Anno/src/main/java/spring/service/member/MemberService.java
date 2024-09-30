package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	void registerMember(MemberVO mem);
	void updateMember(MemberVO mem);
	List<MemberVO> showAllMember(MemberVO mem);
	MemberVO getMember(String name);
	boolean idExist(String id);
	boolean login(MemberVO mem);
}

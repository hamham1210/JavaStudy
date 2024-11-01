package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.web.spring.domain.Member;




public interface MemberRepository extends JpaRepository<Member, Long>{

	
	 @Query(value = "select m from Member m where m.id = :id")
	Member duplicateCheck(@Param("id") String id);


	Member findById(String id);//id에 해당하는 멤버를 검색... Query method
	
	//Optional<Member> findById(Long memberNo);이미 상속되어 있는 함수

	
	boolean existsById(String id);//id에 해당하는 멤버의 존재 여부 확인...
	
	
	
}

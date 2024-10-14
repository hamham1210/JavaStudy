package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

/*
 * Spring Data JPA Repository...이전의 DAO와 같은 역할
 * 인터페이스가 나오면 해당 인터페이스를 구현한 실체 클래스를 다시 상속받아서 작성해야 하지만
 * Spring Data JPA 기술은 인터페이스를 구현하는 빈 클래스를 자동으로 생성시켜준다.
 * */
public interface CustomRepository extends JpaRepository<Custom, Integer>{
//아무것도 작성 안해도 기본적인 CRUD가 다 들어있다.
	//JPA Query Method ...추가
	/*
	 * JPA Query Method
	 * 1. 대부분 findBy로 시작
	 * 2. 이름 규칙만 잘 정해주면 자동으로 SQL구문이 실행
	 * 3. ORM방식이기 때문에 함수명은 CamelCase가 기본이다.
	 * */
	Optional<List<Custom>> findByName(String name);
	//	findByLastnameAndFirstname
	Optional<Custom> findByNameAndEmail(String name,String email);
	// findByLastnameOrFirstname
	List<Custom> findByNameOrEmail(String name,String email);
	
	//고객의 아이디 값이 1-3사이의 아이디를 가지는 고객을 검색
	Optional<Custom> findByCustomIdBetween(int startCustomId,int endCustomId);
	
	//고객의 아이디가 3보다 작은 아이디를 가지는 고객을 검색
	Optional<Custom> findByCustomIdLessThan(int customId);
	
	//고객의 등록일자가 어제(LocalDateTime) 이후로 등록한 고객을 검색...
	Optional<Custom> findByregDateAfter(LocalDateTime day);
	//이후
	Optional<Custom> findByregDateBefore(LocalDateTime day);
	
	//고객의 이름이 null값인 고객을 검색
	List<Custom> findByNameIsNull();
	//null이 아닌 고객
	List<Custom> findByNameIsNotNull();
	
	//select customId,password,name,email,regDate from custom where name like ?
	List<Custom> findByNameLike(String name);
	//와일드카드 적용이 안된다. 해당 값에 %,_를 지정해줘야한다.
	List<Custom> findByNameEndingWith(String name);//와일드 카드 적용된다.
	//내림차순 적용
	List<Custom> findByOrderByCustomIdDesc();
	//기본적으로 오름차순
	//고객아이디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 검색
	//이런식으로 조건검색 뒤에 OrderBy절은 다 붙일 수 있다.
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	
	
	//고객아이디가 1이거나 3이거나 5인 고객을 검색...in
	List<Custom> findByCustomIdIn(Collection<Integer> ids);
	//Not은  null과 비교하지 않는다. .. null은 출력되지 않는다.
	List<Custom> findByNameNot(String name);
}

package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Board;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Boot06JpaEntitiesApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private CustomRepository customrepository;
	@Autowired
	private BoardRepository boardrepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// 1.모든 Role정보를 받아온다.
		// rolerepository.findAll().forEach(c->System.out.println(c));
		// 2.모든 custom정보를 받아온다.,
		// customrepository.findAll().forEach(c->System.out.println(c));
		/*
		 * findAll() --> select *from custom 한번의 쿼리로 전체 custom을 받아온다. c.getRoles() -->
		 * select * from custom_role join where custom_id=? 를 테이블 row수 만큼 한다.
		 * 
		 * 이러한 문제상황을 우리는 N+1문제라 한다. 만약에 Custom레코드 수가 많다면 심각한 성능 저하에 빠진다.
		 * 
		 * 연관관계가 설정된 엔터티를 조회할 경우, findAll, 데이터의 갯수(n)만큼 조인 select절이 계속적으로 실행된다.
		 * 
		 * Custom --> custom_role -->role 여기 안에 있는 데이터를 한 번의 쿼리문으로 받아올 수 있지만
		 * 
		 */
//		customrepository.findAll().forEach(c->{
//			System.out.println(c);
//			System.out.println(c.getRoles()); 
//			
//		});
		// 3.모든 Board정보를 받아온다.
		// findAll에서는 Board정보만 받아오고 싶지만 fetchType이 Eager로 잡혀져 있어서 함께 나온다... LAZY로 고쳐서
		// 해결하기
		// boardrepository.findAll().forEach(c->System.out.println(c));
//		boardrepository.findAll().forEach(b -> {
//			System.out.println(b);
//			System.out.println(b.getCustom());
//			System.out.println("============================================================");
//		});
		//보드 정보만  받아보고 싶을 때는 LAZY로 고쳐야한다. 그후 custom정보는 별도로 get으로 받는다.
		Board b = boardrepository.findById(1L).get();
		System.out.println(b);
		System.out.println(b.getCustom());
		/*
		 * findAll인 경우 - fetchType EAGER,LAZY방식 모두 다 조인이 안걸린다.
		 * 하지만 한건의 데이타를 가지고 오는 경우... findById()
		 * EAGER방식에서는 LEFT조인이 걸린다.
		 * 전체검색/ 한건 검색이 서로 다르게 동작한다.
		 * 엔터티가 결합된 관계에서 굳이 함께 가져와야하는 필요가 없는 경우!!
		 * LAZY방식으로 가져온다.
		 * 반면에 데이터를 함께 가져와야하는 경우(게시판 글정보와 함께 글쓴이의 정보)엔
		 * 특히 한 건의 데이타를 직접적으로 받아와야하는 경우에는 EAGER
		 * */
		//Optional[Board [boardId=1, title=다정한 브라운씨의 정체!, content=그의 정체를 파해치는 기사, count=0, regDate=2024-10-11T00:00]]
		//Optional[Board [boardId=1, title=다정한 브라운씨의 정체!, content=그의 정체를 파해치는 기사, count=0, regDate=2024-10-11T00:00]]
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot06JpaEntitiesApplication.class, args);
	}

}

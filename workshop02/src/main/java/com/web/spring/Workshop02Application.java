package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.User;
import com.web.spring.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Workshop02Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//  save(), findById(), findAll(), delete(), 쿼리 메소드 3개
		System.out.println("===============객체생성================");
		User u1 = new User("test","1234","테스트");
		User u2 = new User("MC","7777","브라운");
		User u3 = new User("sawonsol","1234","김솔음");
		User u4 = new User();
		u4.setId("Unkown");
		u4.setPassword("0000");
		System.out.println("===============객체삽입================");
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);
		System.out.println("===============모든 유저 찾기================");
		userRepository.findAll().forEach(c->System.out.println(c));
		System.out.println("===============이름으로 찾기================");
		User findUser= userRepository.findById("test").orElseThrow();
		System.out.println(findUser);
		System.out.println("===============유저 test 삭제================");
		User delete= userRepository.findById("test").orElseThrow();
		userRepository.delete(delete);
		System.out.println("==============='김'이 포함된 유저찾기================");
		userRepository.findByNameContaining("김").forEach(c->System.out.println(c));
		System.out.println("===============이름이 null이 아닌 유저 찾기================");
		userRepository.findByNameIsNotNull().forEach(c->System.out.println(c));
		System.out.println("==============='유저 이름 기준으로 상위 2개 찾기'================");
		userRepository.findTop2ByName("김솔음").forEach(c->System.out.println(c));
	}

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Workshop02Application.class, args);
	}
}

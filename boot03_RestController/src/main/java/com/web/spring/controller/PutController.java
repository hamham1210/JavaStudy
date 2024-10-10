package com.web.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import com.web.spring.dto.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/v1")
public class PutController {
/*
 * ResponseEntity를 사용하면 좋은 잇점
 * 1. 결과 데잌터와 함께 상태 코드값을 지정할 수 있다.
 * 2. 에러코드와 성공여부 상태 코드 값을 섬세하게 지정해서 클라이언트에게 전달 할 수 있다.
 * 
 * 
 * */
	
	@PutMapping("/members")
	public ResponseEntity<?> updateMember(@RequestBody Member pvo){
		/*
		 * 201.. create
		 * 200.. Success
		 * 202...Update
		 * 빌드 패턴....
		 * */
		
		
		return ResponseEntity
				.status(202)
				.body(pvo);
	}
}

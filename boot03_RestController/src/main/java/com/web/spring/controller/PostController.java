package com.web.spring.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("api/v1")
public class PostController {

	
	//데이타 전달이 목적.. request객체의 Body에 담겨져서 전달되는 값을 받는다.
	//Get방식의 경우 url에서 요청이 가능하지만 Post,insert,put방식의 경우는 Postman을 이용해서 client를 대신해서 요청을 보내는 것이다.
	@PostMapping("/members")
	public String insertMember(@RequestBody Member pvo) {
		//Service함수 호출... insert dao ... 
		
		return pvo.toString();
	}
	
	@PostMapping("/members2")
	public String insertMember2(@RequestBody Map<String,String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(map->{
			sb.append(map.getKey()+" : "+map.getValue());
		});
		
		
		return sb.toString();
	}
	
	
}

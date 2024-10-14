package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;
/*
 * 단순한 페이지를 요청하는 Get방식의 Controller를 다뤄보겠다.
 * 
 * 
 * 
 * */

@RestController
public class GetController {

	@GetMapping("/members")
	public String getMember(String id) {
		// 서비스 함수 호출 결과로 id에 해당하는 Member객체를 리턴 받았다고 치고
		Member rvo = new Member("Kosta", "1234", "홍종각", "종각");

		return rvo.toString();

	}

	// 2.http://http://localhost:9000/member?name=홍종각&address=종각
	@GetMapping("/member")
	public String getMember(@RequestParam String name, @RequestParam String address) {
		return name + "님이 사는 곳은 " + address;

	}
	// 2.http://http://localhost:9000/member/james
	/*
	 * @GetMapping("/member/{name}") public String getMembers(@PathVariable String
	 * name) { return "Hello, "+name;
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/member/{name}") public String getMembers(@PathVariable String
	 * myName) { return "Hello, " + myName;
	 * 
	 * }
	 */
	
	@GetMapping("/member/{name}")
	public String getMembers(@PathVariable("name") String myName) {
		return "Hello, " + myName;

	}
}
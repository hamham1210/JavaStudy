package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller //SSR
@RestController //CSR
public class HelloController {

	@GetMapping("/")
	public String index() {
		System.out.println("Hello Spring boot!!");
		return "Hello index!!";
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello~~ SpringBoot~~!!";
	}
}

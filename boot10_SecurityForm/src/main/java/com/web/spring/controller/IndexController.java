package com.web.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.spring.config.SecurityConfig;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Slf4j
public class IndexController {

	
	@GetMapping("/")
	public String index() {
		log.info("index=========>");
		return "Spring Security Filter";
	}
	
	@GetMapping("loginPage")
	public String loginPage() {
		log.info("loginPage=========>");
		return"Spring Custom Form....";
	}
	
	@GetMapping("home")
	public String home() {
		log.info("home=========>");
		return"home....";
	}
	
}

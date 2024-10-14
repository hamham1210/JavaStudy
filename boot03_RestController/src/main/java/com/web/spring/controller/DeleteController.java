package com.web.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.transport.ResponseContext;

@RestController
@RequestMapping("api/v1")
public class DeleteController {

	@DeleteMapping("/member/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {

		//return new ResponseEntity<>(HttpStatus.OK);//생성자 방식
		
		return ResponseEntity
				.status(200)
				.body(id+"delete ok~~");
	}
}
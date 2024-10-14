package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.web.spring.dto.Product;

@RestController
@RequestMapping("a1/api")
public class TestController {

	@GetMapping("/product")
	public ResponseEntity<String> select(@RequestParam Integer num, @RequestParam String name) {
		Product vo = new Product(); 
		vo.setNo(num);
		vo.setName(name);
		vo.setDetail("test");
		return ResponseEntity
				.status(200)
				.body(vo.toString());
	}
	//http://localhost:9999/a1/api/product?num=1234&name=사과
	@GetMapping("/product/{num}")
	public ResponseEntity<String>  getProduct(@PathVariable Integer num) {
		Product vo = new  Product();
		vo.setNo(num);
		vo.setName("사과");
		vo.setDetail("test");
		return ResponseEntity
				.status(200)
				.body(vo.toString());
	}
	//http://localhost:9999/a1/api/product/num
	@PostMapping("/product")
	public ResponseEntity<String> getProduct(@RequestBody Product pvo) {
		List<Product> list = new ArrayList<>();
		Product vo1 = new Product(1234,"사과","종각에서 자란 사과"); 
		Product vo2 = new Product(2222,"키위","종각에서 자란 키위"); 
		Product vo3 = new Product(3333,"파인애플","종각에서 자란 파인애플"); 
		list.add(pvo);
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		StringBuilder sb = new StringBuilder();
		 list.forEach(product -> sb.append(product.toString()).append("\n"));  // 각 제품의 정보를 줄바꿈하여 추가

		    return ResponseEntity
		    		.status(200)
		    		.body(sb.toString());// 모든 제품 정보가 있는 문자열 반환
	}
	//http://localhost:9999/a1/api/product
	
	@PostMapping("/product2")
	public ResponseEntity<Product> insertProduct(@RequestBody Product pvo) {
		
		
	
		System.out.println(pvo);
		return ResponseEntity
				.status(200)
				.body(pvo);
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product pvo){
		/*
		 * 201.. create
		 * 200.. Success
		 * 202...Update
		 * 빌드 패턴....
		 * */
		
		return ResponseEntity
				.status(200)
				.body(pvo);
	}
	
	@DeleteMapping("/product/{num}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer num){
		
		return ResponseEntity
				.status(200)
				.body(num+"delete ok");
		
	}
	
	
}
package com.web.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //꽉찬 생성자
@Getter 
@Setter
@ToString
public class Product {

	private Integer no;
	private String name;
	private String detail;
}

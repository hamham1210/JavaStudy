package com.web.spring.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

	
	@Id
	@Column(name = "pro_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proNo;
	
	@Column(length = 200)
	private String model;
	
	@Column(length = 100)
	private String maker;
	
	@CreationTimestamp
	private LocalDateTime regDate;

	@ManyToOne
	@JoinTable(name="pro_no",
			joinColumns = @JoinColumn(name="pro_no"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private User user;
	
	@Override
	public String toString() {
		return "Product [proNo=" + proNo + ", model=" + model + ", maker=" + maker + ", regDate=" + regDate + "]";
	}
	
}

package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
	private String productName;
	private Integer quantity;
	private Double price;
	private Integer userId;
	
	
	

}

package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer productId;
	private Integer userId;
	private String productName;
	private Integer quantity;
	private Double price;
	

}

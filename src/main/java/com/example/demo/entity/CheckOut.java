package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CheckOut {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer transactionId;
	private Integer userId;
	private Integer productId;
	private LocalDate date;
	private Double price;
	private Integer quantity;
	

}

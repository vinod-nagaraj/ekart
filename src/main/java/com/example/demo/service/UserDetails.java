package com.example.demo.service;

import com.example.demo.dto.Loginrequest;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;

public interface UserDetails {
	
	public ResponseDto registration(RegistrationRequest registrationRequest);
	public ResponseDto login(Loginrequest loginrequest);
	public ResponseDto list(ProductRequest productRequest);
	public ResponseDto purchase(Integer userId,Integer productId,String productName,Integer quantity,Double price );

}

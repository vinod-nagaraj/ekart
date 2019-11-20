package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Loginrequest;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDetails userDetails;

	@PostMapping("/registration")
	public ResponseEntity<ResponseDto> registration(@RequestBody RegistrationRequest registrationRequest) {
		ResponseDto responseDto = userDetails.registration(registrationRequest);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
	
		
		@PostMapping("/registration/login")
		public ResponseEntity<ResponseDto> login(@RequestBody Loginrequest loginRequest) {
			ResponseDto responseDto = userDetails.login(loginRequest);
			return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
		
		@GetMapping("/purchase")
		public ResponseEntity<ResponseDto>list(@RequestBody ProductRequest productRequest){
			ResponseDto responseDto = userDetails.list(productRequest);
			return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
		}
}

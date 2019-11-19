package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDetails userDetails;

	@PostMapping("/users")
	public ResponseEntity<ResponseDto> registration(@RequestBody RegistrationRequest registrationRequest) {
		ResponseDto response = userDetails.registration(registrationRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}

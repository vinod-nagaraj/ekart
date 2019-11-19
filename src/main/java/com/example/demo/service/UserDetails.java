package com.example.demo.service;

import com.example.demo.dto.Loginrequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;

public interface UserDetails {
	
	public ResponseDto registration(RegistrationRequest registrationRequest);
	public ResponseDto login(Loginrequest loginRequest);

}

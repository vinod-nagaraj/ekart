package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Loginrequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.CheckOutRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Validations;

@Service

public class UserDetailsImpl implements UserDetails {
@Autowired
UserRepository userRepository;

@Autowired
ProductRepository productRepository;

@Autowired
CheckOutRepository checkOutRepository;

@Override
public ResponseDto registration(RegistrationRequest registrationRequest) {
	Optional<List<User>>userMobile = UserRepository.findBymobNum(registrationRequest.getmobNum());
	
	if (userMobile.isPresent() && !userMobile.get().isEmpty())
		throw new UserException("Already present");

	if (!Validations.mobileValid(registrationRequest.getMobNum() + ""))
		throw new UserException("Mobile number not valid");
}

@Override
public ResponseDto login(Loginrequest loginRequest) {
    Optional<List<User>>userLogin = UserRepository
    		.findBymobNumandPassword(loginRequest.getPassword(), loginRequest.getmobNum());
    if (!userLogin.isPresent())
		throw new UserException("no user found.");
}
}

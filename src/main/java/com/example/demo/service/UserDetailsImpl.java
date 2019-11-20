package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Loginrequest;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.CheckOut;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.CheckOutRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

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
	User user = new User();
	BeanUtils.copyProperties(registrationRequest, user);
	userRepository.save(user);
	ResponseDto responseDto = new ResponseDto();
			responseDto.setMessage("Added successfully");
			responseDto.setStatusCode(HttpStatus.CREATED.value());
			return responseDto;
}

@Override
public ResponseDto login(Loginrequest loginRequest) {
	Optional<List<User>>userLogin = userRepository.findBymobNumandPassword(loginRequest.getUserName(), loginRequest.getPassword());
	if (!userLogin.isPresent())
		throw new UserException("not found");
	ResponseDto responseDto =new ResponseDto();
	responseDto.setUserId(userLogin.get().get(0).getUserId());
	responseDto.setMessage("login successfull");
	responseDto.setStatusCode(HttpStatus.CREATED.value());
	return responseDto;
}

@Override
public ResponseDto list(ProductRequest productRequest) {
	Optional<List<Product>> productList = productRepository.findByProductId(productRequest.getProductName(),productRequest.getPrice());
	if (!productList.isPresent())
		throw new UserException("no records");
	ResponseDto responseDto = new ResponseDto();
	responseDto.setMessage("success");
	responseDto.setStatusCode(HttpStatus.CREATED.value());
	return responseDto;
}

@Override
public ResponseDto purchase(Integer userId, Integer productId, String productName, Integer quantity, Double price) {
	new Product();
	new User();
	Optional<List<Product>> purchaseList = productRepository.findByProductId();
	if(!purchaseList.isPresent())
		throw new UserException("empty list");
	CheckOut checkout=new CheckOut();
	BeanUtils.copyProperties(purchaseList, checkout);
	checkOutRepository.save(checkout);
	ResponseDto responseDto = new ResponseDto();
	responseDto.setMessage("success");
	responseDto.setStatusCode(HttpStatus.CREATED.value());
	return responseDto;
}




}


package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {

	private String userName;
	private String password;
	private Integer mobNum;
	private String email;
}

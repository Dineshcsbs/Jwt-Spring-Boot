package com.jwt.token.DTO;

import lombok.Data;

@Data
public class UserSignUpDTO {
	private String name;
	private String email;
	private String phoneNumber;
	private String gender;
	private String password;
}

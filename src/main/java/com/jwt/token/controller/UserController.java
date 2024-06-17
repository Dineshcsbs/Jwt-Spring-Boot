package com.jwt.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.token.DTO.UserSignUpDTO;
import com.jwt.token.commonfiles.ApiResponse;
import com.jwt.token.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ApiResponse createAccount(@RequestBody UserSignUpDTO userSign) {
		return userService.createAccount(userSign);
	}
}

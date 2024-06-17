package com.jwt.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.token.DTO.LoginDTO;
import com.jwt.token.commonfiles.ApiResponse;
import com.jwt.token.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/")
	public ApiResponse loginUser(@RequestBody LoginDTO login) {
		return loginService.loginUser(login);
	}
	@GetMapping("/")
	public String verify(@RequestHeader String token) {
		return loginService.verify(token);
	}
}

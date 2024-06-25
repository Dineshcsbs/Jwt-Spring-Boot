package com.Jwt.AuthToken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jwt.AuthToken.dto.LoginUserDto;
import com.Jwt.AuthToken.dto.RefreshTokenDto;
import com.Jwt.AuthToken.dto.RegisterUserDto;
import com.Jwt.AuthToken.entities.User;
import com.Jwt.AuthToken.request.LoginResponse;
import com.Jwt.AuthToken.request.RefreshTokenResponse;
import com.Jwt.AuthToken.services.AuthenticationService;
import com.Jwt.AuthToken.services.JwtService;
import com.Jwt.AuthToken.services.UserService;

@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private UserService userService;

	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/admin-signup")
	public ResponseEntity<User> adminRegister(@RequestBody RegisterUserDto registerUserDto) {
		return ResponseEntity.ok(authenticationService.adminSignup(registerUserDto));
	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
		User authenticatedUser = authenticationService.authenticate(loginUserDto);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		String refreshToken = jwtService.generateRefreshToken(authenticatedUser);

		LoginResponse loginResponse = LoginResponse.builder().expiresIn(jwtService.getExpirationTime()).token(jwtToken)
				.refreshToken(refreshToken).expiresIn(jwtService.getExpirationTime()).build();

		return ResponseEntity.ok(loginResponse);
	}

	@PostMapping("/refresh")
	public ResponseEntity<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {

		User user = userService.findByUser(jwtService.extractUsername(refreshTokenDto.getToken()));

		String jwtToken = jwtService.generateToken(user);

		RefreshTokenResponse loginResponse = RefreshTokenResponse.builder().accessToken(jwtToken).build();
		return ResponseEntity.ok(loginResponse);
	}

}
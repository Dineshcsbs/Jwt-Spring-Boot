package com.Jwt.AuthToken.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Jwt.AuthToken.dto.LoginUserDto;
import com.Jwt.AuthToken.dto.RegisterUserDto;
import com.Jwt.AuthToken.entities.User;
import com.Jwt.AuthToken.enums.Role;
import com.Jwt.AuthToken.repositories.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Autowired
	private  AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User signup(RegisterUserDto input) {

		User user = User.builder().fullName(input.getFullName()).email(input.getEmail())
				.password(passwordEncoder.encode(input.getPassword())).role(Role.USER).build();

		return userRepository.save(user);
	}

	public User adminSignup(RegisterUserDto admin) {
		User user = User.builder().fullName(admin.getFullName()).email(admin.getEmail())
				.password(passwordEncoder.encode(admin.getPassword())).role(Role.ADMIN).build();
		return userRepository.save(user);
	}

	public User authenticate(LoginUserDto input) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

		return userRepository.findByEmail(input.getEmail()).orElseThrow();
	}

}
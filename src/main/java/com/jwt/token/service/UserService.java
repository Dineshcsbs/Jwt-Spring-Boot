package com.jwt.token.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.token.DTO.UserSignUpDTO;
import com.jwt.token.commonfiles.ApiResponse;
import com.jwt.token.commonfiles.UserRoles;
import com.jwt.token.entity.User;
import com.jwt.token.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	


	public ApiResponse createAccount(UserSignUpDTO userSign) {
		ApiResponse apiResponse=new ApiResponse();
		User user=new User();
		user.setName(userSign.getName());
		user.setEmail(userSign.getEmail());
		user.setPassword(userSign.getPassword());
		user.setGender(userSign.getGender());
		user.setPhoneNumber(userSign.getPhoneNumber());
		user.setUserRole(UserRoles.user);
		user.setCreateaAt(new Date());
		user.setLastLogin(new Date());
		apiResponse.setData(user);
		userRepository.save(user);
		return apiResponse;
	}

}

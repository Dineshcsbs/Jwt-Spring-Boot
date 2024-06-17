package com.jwt.token.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.token.DTO.LoginDTO;
import com.jwt.token.commonfiles.ApiResponse;
import com.jwt.token.entity.User;
import com.jwt.token.repository.UserRepository;
import com.jwt.token.tokencreation.Token;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
	
	public ApiResponse loginUser(LoginDTO login) {
		ApiResponse apiResponse=new ApiResponse();
		User user=userRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());	
		if(user.getId()==null) {
			apiResponse.setData("Not a user");
			return apiResponse;
		}
		Token token1=new Token();
		String token=token1.tokenCreation(user);
		apiResponse.setData(token);
		user.setLastLogin(new Date());
		userRepository.save(user);
		return apiResponse;
	}

	public String verify(String token) {
		Token token1=new Token();
//		String 
		return token1.tokenVerify(token);
	}
	

}

package com.Jwt.AuthToken.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jwt.AuthToken.entities.User;
import com.Jwt.AuthToken.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
    
    public User findByUser(String userName) {
    	return userRepository.findByEmail(userName).orElseThrow(null);
    }
}
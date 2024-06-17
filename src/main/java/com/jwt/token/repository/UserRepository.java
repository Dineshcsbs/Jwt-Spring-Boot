package com.jwt.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.token.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmailAndPassword(String email, String password);
	

	
}

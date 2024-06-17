package com.jwt.token.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//@Table(name="sign_up")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String gender;
	private String password;
	private String userRole;
	private Date createaAt;
	private Date lastLogin;
}

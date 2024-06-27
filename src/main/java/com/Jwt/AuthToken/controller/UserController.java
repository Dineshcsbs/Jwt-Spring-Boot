package com.Jwt.AuthToken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/user")
@RestController
public class UserController {

    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String authenticatedUser() {

    	System.out.println("User Login");
        return "User Login";
    }
     
}
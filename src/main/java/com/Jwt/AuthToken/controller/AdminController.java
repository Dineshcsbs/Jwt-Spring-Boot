package com.Jwt.AuthToken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @GetMapping("/")
//    @PreAuthorize("hasRole('ADMIN')")
    public String authenticatedUser() {
        return "Admin Login";
    }
}
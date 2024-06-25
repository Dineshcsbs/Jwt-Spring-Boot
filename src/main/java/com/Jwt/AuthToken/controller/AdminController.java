package com.Jwt.AuthToken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jwt.AuthToken.services.UserService;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
	@Autowired
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<String> authenticatedUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok("Admin login success");
    }
    

//    @GetMapping("/")
//    public ResponseEntity<List<User>> allUsers() {
//        List <User> users = userService.allUsers();
//
//        return ResponseEntity.ok(users);
//    }
}

package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.UserRepo;
import com.api.model.User;
import com.api.security.JwtTokenUtil;



@RestController
@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
    private UserRepo userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Username and password validate karna
        User foundUser = userRepository.findByUserName(user.getUsername()).orElse(null);
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return jwtTokenUtil.generateToken(foundUser.getUsername());  // Return JWT Token
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}

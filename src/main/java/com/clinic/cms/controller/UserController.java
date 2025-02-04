package com.clinic.cms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.cms.dto.AuthenticationRequest;
import com.clinic.cms.dto.AuthenticationResponse;
import com.clinic.cms.entity.Users;
import com.clinic.cms.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
//	private UserRepository userRepo;
	public UserController(UserService service) {
        this.service = service;
    }
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
//		System.out.println("Register User");
		return this.service.register(user);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authRequest) {
		System.out.println("Login User");
//		return new AuthenticationResponse();
		return service.verify(authRequest);
	}
}

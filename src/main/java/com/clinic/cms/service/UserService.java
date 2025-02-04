package com.clinic.cms.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinic.cms.dto.AuthenticationRequest;
import com.clinic.cms.dto.AuthenticationResponse;
import com.clinic.cms.entity.Users;
import com.clinic.cms.repository.UserRepository;

import lombok.Data;

@Service
@Data
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	public AuthenticationResponse verify(AuthenticationRequest authRequest) {
		
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated()) {
			final String jwt= jwtService.generateToken(authRequest.getUsername());
			AuthenticationResponse authenticationResponse= new AuthenticationResponse();
			Users optionalUser = userRepo.findByUsername(authRequest.getUsername());
//			System.out.println("Login User"+optionalUser);
	    	if(optionalUser != null) {
		    	authenticationResponse.setJwt(jwt);
		    	authenticationResponse.setUserRole(optionalUser.getUserRole());
		    	authenticationResponse.setUserId(optionalUser.getId());
	    	}
	    	System.out.println(authenticationResponse);
	    	return authenticationResponse;
		}
		
		throw new UsernameNotFoundException("User not found");
	}
}

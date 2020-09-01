package com.libraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.dto.AuthRequest;
//import com.libraryManagement.model.UserDetailsImpl;
import com.libraryManagement.service.UserDetailsServiceImplementation;
import com.libraryManagement.utility.JwtTokenUtil;

@RestController
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserDetailsServiceImplementation userDetailsServiceImpl;

//	@RequestMapping("/hello")  
//	public String hello() {   
//	 return "auth controller"; 
//	 }

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		Authentication authentication;
		try {
			System.out.println();
			authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			System.out.println("in catch"+ex);
			throw new Exception("invalid username or password");
		}
		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authRequest.getUserName());
//		String Token = jwtTokenUtil.generateToken((UserDetailsImpl)authentication.getPrincipal());
		return jwtTokenUtil.generateToken(authentication);
//		return Token;

	}

}

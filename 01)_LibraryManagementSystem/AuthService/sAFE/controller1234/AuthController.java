package com.libraryManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
}

	@RequestMapping("/auth")  
	public String hello() {   
	 return "auth controller"; 
	 }

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

}

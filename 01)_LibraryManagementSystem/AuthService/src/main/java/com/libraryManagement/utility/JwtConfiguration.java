package com.libraryManagement.utility;

import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class JwtConfiguration {
	
	@Value("${security.jwt.uri:/auth-service/**}")
	private String Uri;
//	
//	@Value("${security.jwt.header:Authorization}")
//	private String header;
//	
//	@Value("${security.jwt.prefix:Bearer }")
//	private String prefix;
//	
//	@Value("${security.jwt.expiration:#{24*60*60}}")
//	private int expiration;
	
	
	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;
	
//	 @PostConstruct
//	  protected void init() {
//	    secret = Base64.getEncoder().encodeToString(secret.getBytes());
//	  }
	
	public String getUri() {
		return Uri;
	}
//
//	public String getHeader() {
//		return header;
//	}

//	public String getPrefix() {
//		return prefix;
//	}
//
//	public int getExpiration() {
//		return expiration;
//	}

	public String getSecret() {
		return secret;
	}

}

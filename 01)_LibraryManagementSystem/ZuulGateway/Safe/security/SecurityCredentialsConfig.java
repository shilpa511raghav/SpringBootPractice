package com.libraryManagement.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtConfiguration jwtConfig;
	
	@Autowired
	private JwtAuthenticationEntryPoint authEntryPoint;
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.exceptionHandling().authenticationEntryPoint(authEntryPoint)
			.and()
			.addFilterAfter(new JwtAuthorizationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
//			.antMatchers(jwtConfig.getUri()).permitAll()
			.antMatchers("/v2/api-docs",
	                "/swagger-resources/configuration/ui",
	                "/swagger-resources",
	                "/swagger-resources/configuration/security",
	                "/swagger-ui.html",
	                "/webjars/**").permitAll()
//			.antMatchers("/api/user/**").hasRole("ADMIN")
//			.antMatchers("/api/**").permitAll()
			.antMatchers(HttpMethod.POST,jwtConfig.getUri()).permitAll()
		.anyRequest().authenticated();
	}
	
//	@Bean
//  	public JwtConfiguration jwtConfigure() {
//    	   return new JwtConfiguration();
//  	}

}

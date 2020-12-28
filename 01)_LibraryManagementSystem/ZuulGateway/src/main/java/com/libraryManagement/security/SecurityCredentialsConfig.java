package com.libraryManagement.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtConfiguration jwtConfig;
	
	@Autowired
	private JwtAuthenticationEntryPoint authEntryPoint;
	
	private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            
            // other public endpoints of your API may be appended to this array
    };

		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
//		.formLogin().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.exceptionHandling().authenticationEntryPoint(authEntryPoint)
			.and()
			
			.addFilterAfter(new JwtAuthorizationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			
//			.antMatchers("/api/user/**").hasRole("ADMIN")
//			.antMatchers("/auth-service/**").permitAll()
			.antMatchers("/actuator/**").permitAll()
			.antMatchers(jwtConfig.getUri()).permitAll()
			.anyRequest().authenticated();
	}
	
	
//	@Override
//	  public void configure(WebSecurity web) throws Exception {
//	    // Allow swagger to be accessed without authentication
//	    web.ignoring().antMatchers("/v2/api-docs")//
//	        .antMatchers("/swagger-resources/**")//
//	        .antMatchers("/swagger-ui.html")//
//	        .antMatchers("/configuration/**")//
//	        .antMatchers("/webjars/**")//
//	        .antMatchers("/public");
//	       
//	        
//	  }
	
//	@Bean
//  	public JwtConfiguration jwtConfigure() {
//    	   return new JwtConfiguration();
//  	}

}

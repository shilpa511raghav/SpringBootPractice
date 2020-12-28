package com.libraryManagement.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.SignatureException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	private JwtConfiguration jwtConfig;

	public JwtAuthorizationFilter(JwtConfiguration jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwttoken = null;
		Claims claims = null;
		String username = null;

		// get the header
		String header = request.getHeader(jwtConfig.getHeader());

		// validate the header
		if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
//			filterChain.doFilter(request, response);
			System.out.println("couldn't find bearer string, will ignore the header");
		} else {
			// if header then get token
			jwttoken = header.replace(jwtConfig.getPrefix(), ""); // .trim();
			try {

				claims = Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(jwttoken).getBody();
				username = claims.getSubject();

			} catch (IllegalArgumentException e) {
				System.out.println("an error occured during getting username from token" + e);

			} catch (ExpiredJwtException e) {
				System.out.println("the token is expired and not valid anymore" + e);
			} catch (SignatureException e) {
				System.out.println("Authentication Failed. Username or Password not valid." + e);
			} catch (MalformedJwtException e) {
				System.out.println("token is not formed correctly- malformed token." + e);

			}

		}

		if (username != null) {

			final Collection authorities = Arrays.stream(claims.get("AUTHORITIES_KEY").toString().split(","))
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

			System.out.println("authorites are: " + authorities);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, "",
					authorities);
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			// Authenticate user
			SecurityContextHolder.getContext().setAuthentication(authToken);

		} else {
			System.out.println("no context and token clear it");
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}

}

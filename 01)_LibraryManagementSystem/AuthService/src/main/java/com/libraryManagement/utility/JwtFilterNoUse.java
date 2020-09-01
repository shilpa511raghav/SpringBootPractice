package com.libraryManagement.utility;
//package com.libraryManagement.utility;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.libraryManagement.service.CustomUserDetailsService;
//
//import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtTokenUtil jwtUtil;
//
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest httpSrvltRequest, HttpServletResponse httpSrvltResponse,
//			FilterChain filterChain) throws ServletException, IOException {
//		final String authorizationHeader = httpSrvltRequest.getHeader("Authorization");
//
//		String jwtToken = null;
//		String username = null;
//
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			jwtToken = authorizationHeader.substring(7);
//			username = jwtUtil.extractUsername(jwtToken);
//
//		}
//	
//		// extract username from token
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails myUserDetail = userDetailsService.loadUserByUsername(username);
//
//			// validate token
//			if (jwtUtil.validateToken(jwtToken, myUserDetail)) {
//
//				// validating userdetail
//				UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(
//						myUserDetail, null, myUserDetail.getAuthorities());
//				usernamePassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpSrvltRequest));
//				SecurityContextHolder.getContext().setAuthentication(usernamePassAuthToken);
//
//			}
//
//		}
//		filterChain.doFilter(httpSrvltRequest, httpSrvltResponse);
//
//	}
//
//}

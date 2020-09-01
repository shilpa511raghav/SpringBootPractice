package com.libraryManagement.service;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libraryManagement.model.MyUserModel;
//import com.libraryManagement.model.UserDetailsImpl;
import com.libraryManagement.repository.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUserModel myuser = userRepository.findByUsername(username);
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
            	.commaSeparatedStringToAuthorityList("ROLE_" + myuser.getRole());
//		return new User(myuser.getUsername(), myuser.getPassword(),myuser.getRole());
//		return UserDetails.create(myuser);
		return new User(myuser.getUsername(), myuser.getPassword(), grantedAuthorities);
	}

}

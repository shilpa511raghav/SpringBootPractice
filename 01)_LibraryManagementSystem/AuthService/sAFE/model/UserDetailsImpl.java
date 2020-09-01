//package com.libraryManagement.model;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class UserDetailsImpl implements UserDetails{
//	private String username;
//	private String password;
//	private String email;
//	private Collection<? extends GrantedAuthority> authorities;
//	
//	public UserDetailsImpl(String username, String password,String email,Collection<? extends GrantedAuthority> authorities){
//        this.username=username;
//        this.password=password;
//        this.email = email;
//        this.authorities=authorities;
//    }
//
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	public static UserDetailsImpl create(MyUserModel user) {
//		List<GrantedAuthority> authorities= new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole()));
//		return new UserDetailsImpl(user.getUsername(), user.getPassword(),user.getEmail(), authorities);
//	}
//
//}

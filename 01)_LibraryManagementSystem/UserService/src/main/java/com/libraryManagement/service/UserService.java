package com.libraryManagement.service;

import java.util.List;

import com.libraryManagement.exception.ResourceNotFoundException;
import com.libraryManagement.model.UserModel;

public interface UserService {
	
	List<UserModel> getList();
	
	UserModel addUsers(UserModel newUser);
	
	UserModel getById(int id) throws ResourceNotFoundException;
	
	void deleteUser(int id) throws ResourceNotFoundException;
	
	UserModel updateUser(UserModel updateInfo) throws ResourceNotFoundException;

}

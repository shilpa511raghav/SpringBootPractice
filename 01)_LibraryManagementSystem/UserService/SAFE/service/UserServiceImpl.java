package com.libraryManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.exception.ResourceNotFoundException;
import com.libraryManagement.model.UserModel;
import com.libraryManagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserModel> getList() {
		return userRepository.findAll();
	}

	@Override
	public UserModel addUsers(UserModel newUser) {
		return userRepository.save(newUser);
	}

	@Override
	public UserModel getById(int id) throws ResourceNotFoundException {
		Optional<UserModel> userData = userRepository.findById(id);
		if(userData.isPresent()){
			System.out.println("jdghgfygdfhgd"+userData.isPresent());
			return userData.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id"+id);
					
		}
	}

	@Override
	public void deleteUser(int id) throws ResourceNotFoundException {
		Optional<UserModel> eachUser = userRepository.findById(id);
		if(eachUser.isPresent()) {
			userRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("record not found with id "+id);
		}
		
	}

	@Override
	public UserModel updateUser(UserModel updateInfo ) throws ResourceNotFoundException {
		Optional<UserModel> userdataToUpdate = userRepository.findById(updateInfo.getUid());
		
			if (userdataToUpdate.isPresent()) {
				UserModel updateUserInfo = userdataToUpdate.get();
				updateUserInfo.setName(updateInfo.getName());
				updateUserInfo.setEmail(updateInfo.getEmail());
				updateUserInfo.setPassword(updateInfo.getPassword());
				updateUserInfo.setRole(updateInfo.getRole());
				updateUserInfo.setUsername(updateInfo.getUsername());
				updateUserInfo.setRoleId(updateInfo.getRoleId());
				userRepository.save(updateUserInfo);
				return updateUserInfo;
		}else {
			throw new ResourceNotFoundException("record not found with id "+updateInfo.getUid());
		}
	}

}

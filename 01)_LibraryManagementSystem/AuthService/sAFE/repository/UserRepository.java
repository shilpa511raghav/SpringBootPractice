package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.model.MyUserModel;

public interface UserRepository extends JpaRepository<MyUserModel, Integer> {

	MyUserModel findByUsername(String username);

}

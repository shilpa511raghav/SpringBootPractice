package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libraryManagement.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}

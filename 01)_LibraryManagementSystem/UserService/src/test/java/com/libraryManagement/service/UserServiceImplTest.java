package com.libraryManagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.libraryManagement.model.UserModel;
import com.libraryManagement.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {
	
	@Mock
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testGetList() {
//		fail("Not yet implemented");
//		when(userRepository.findAll()).thenReturn(Stream.of(new UserModel()));
	}

}

package com.powergym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powergym.model.User;
import com.powergym.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User loginUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}

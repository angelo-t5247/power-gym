package com.powergym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powergym.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);
}

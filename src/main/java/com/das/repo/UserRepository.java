package com.das.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.das.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//Optional<User> findByUsername(String username);
	
	User findByEmail(String email);

}

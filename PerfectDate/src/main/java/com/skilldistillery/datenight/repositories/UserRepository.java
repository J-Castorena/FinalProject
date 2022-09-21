package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserById(int userId);
	User findByUsername(String username);
}

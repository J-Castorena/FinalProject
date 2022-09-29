package com.skilldistillery.datenight.repositories;

<<<<<<< HEAD
=======

>>>>>>> 8aba65c6a17869e20ba3e82db9c31972e6e04ae5
import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserById(int userId);
	
	User findByUsername(String username);
	
	
}

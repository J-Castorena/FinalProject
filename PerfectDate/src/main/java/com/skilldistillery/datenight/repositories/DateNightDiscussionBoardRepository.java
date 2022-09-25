package com.skilldistillery.datenight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.DateNightDiscussionBoard;

public interface DateNightDiscussionBoardRepository extends JpaRepository<DateNightDiscussionBoard, Integer> {

	List<DateNightDiscussionBoard> findByDateNightId(int dateNightId);
	
	List<DateNightDiscussionBoard> findByUserId(int userId);

	
}

package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.DateNightDiscussionBoard;

public interface DateNightDiscussionBoardService {
	
	List<DateNightDiscussionBoard> listAllDiscussions();
	
	List<DateNightDiscussionBoard> listDiscussionsByUserId(int userId);
	
	List<DateNightDiscussionBoard> listDiscussionsByDateNightId(int dateNightId);
	
	DateNightDiscussionBoard createDateNightDiscussionBoard(String username, int id, DateNightDiscussionBoard discussion);

	DateNightDiscussionBoard updateDateNightDiscussionBoard(int id, DateNightDiscussionBoard discussion, String username);

	boolean deleteDateNightDiscussionBoard(int id);
	
}

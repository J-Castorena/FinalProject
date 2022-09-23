package com.skilldistillery.datenight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.DateNightDiscussionBoard;
import com.skilldistillery.datenight.repositories.DateNightDiscussionBoardRepository;

@Service
public class DateNightDiscussionBoardServiceImpl implements DateNightDiscussionBoardService {
	
	@Autowired
	private DateNightDiscussionBoardRepository discussionRepo;
	
	@Override
	public List<DateNightDiscussionBoard> listAllDiscussions(){
		return discussionRepo.findAll();
		}

}

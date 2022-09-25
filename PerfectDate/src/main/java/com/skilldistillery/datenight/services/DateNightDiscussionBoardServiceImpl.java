package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.DateNightDiscussionBoard;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.DateNightDiscussionBoardRepository;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class DateNightDiscussionBoardServiceImpl implements DateNightDiscussionBoardService {
	
	@Autowired
	private DateNightDiscussionBoardRepository discussionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<DateNightDiscussionBoard> listAllDiscussions(){
		return discussionRepo.findAll();
		}

	@Override
	public List<DateNightDiscussionBoard> listDiscussionsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DateNightDiscussionBoard> listDiscussionsByDateNightId(int dateNightId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateNightDiscussionBoard createDateNightDiscussionBoard(
			String username, 
			int id, 
			DateNightDiscussionBoard discussion) {
		Optional<User> userOp = userRepo.findById(id);
		if (userOp.isPresent()) {
			User user = userOp.get();
			discussion.setUser(user);
			discussionRepo.saveAndFlush(discussion);
			return discussion;
			}
		return null;
	}

	@Override
	public DateNightDiscussionBoard updateDateNightDiscussionBoard(int id, DateNightDiscussionBoard discussion, String username) {
		DateNightDiscussionBoard existing = findById(discussion.getId(), username);
		if (existing == null ) {
			return null;
		}
		System.err.println(discussion.getMessage());
		existing.setUser(discussion.getUser());
		existing.setMessage(discussion.getMessage());
		existing.setDiscussions(discussion.getDiscussions());
		return discussionRepo.saveAndFlush(existing);
	}

	private DateNightDiscussionBoard findById(int id, String username) {
		DateNightDiscussionBoard d = null;
		Optional<DateNightDiscussionBoard> discussionOp = discussionRepo.findById(id);
		if (discussionOp.isPresent()) {
			d = discussionOp.get();
			}
		if (d.getUser().getUsername().equals(username)) {
		return d;
	} else {
		return null;
	}
	}

	@Override
	public boolean deleteDateNightDiscussionBoard(int id) {
		discussionRepo.deleteById(id);
		return !discussionRepo.existsById(id);
	}

}

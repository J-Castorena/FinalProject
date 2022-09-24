package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.DateNight;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.DateNightRepository;
import com.skilldistillery.datenight.repositories.UserRepository;
@Service
public class DateNightServiceImpl implements DateNightService {

	@Autowired
	private DateNightRepository dateNightRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<DateNight> index() {
		return dateNightRepo.findAll();
	}

	@Override
	public DateNight dateNightById(Integer id) {
		return dateNightRepo.findDateNightById(id);
	}

	@Override
	public DateNight createDateNight(String username, DateNight dateNight) {
		User user = userRepo.findByUsername(username);
		if(user != null) {
			dateNight.setUser(user);
			return dateNightRepo.saveAndFlush(dateNight);
		}
		return null;
	}

	@Override
	public DateNight updateDateNight(DateNight dateNight, int id, String username) {
		User loggedInUser = userRepo.findByUsername(username);
		Optional<DateNight> updatedDateNight = dateNightRepo.findById(id);
		if (updatedDateNight.isPresent() && (loggedInUser.getRole().equals("admin"))) {
			return dateNightRepo.saveAndFlush(dateNight);

		}
		return null;
	}

	@Override
	public boolean deleteDateNight(String username, Integer id) {
		boolean dateNightDeleted = false;
		if (dateNightRepo.existsById(id)) {
			dateNightRepo.deleteById(id);
			dateNightDeleted = true;
		}
		return dateNightDeleted;
	}

}

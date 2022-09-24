package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.DateNight;

public interface DateNightService {
	
	List<DateNight> index();

	DateNight dateNightById(Integer id);

	DateNight createDateNight(String username, DateNight dateNight);

	DateNight updateDateNight(DateNight dateNight, int id, String username);

	boolean deleteDateNight(String username, Integer id);
}

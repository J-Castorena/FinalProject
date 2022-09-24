package com.skilldistillery.datenight.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.DateNight;
import com.skilldistillery.datenight.services.DateNightService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost"})
public class DateNightController {
	
	@Autowired
	private DateNightService dateNightService;
	
	@GetMapping("datenights")
	public List<DateNight> showAllWods() {
		return dateNightService.index();
	}
	
	@GetMapping("datenights/{id}")
	public DateNight dateNightById(@PathVariable Integer id) {
		return dateNightService.dateNightById(id);
	}

	@PostMapping("datenights")
	public DateNight addDateNight(@RequestBody DateNight dateNight, HttpServletRequest req, HttpServletResponse res, Principal principal) {

		try {
			dateNightService.createDateNight(principal.getName(), dateNight);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL(); // finds URL that submitted request
			url.append("/").append(dateNight.getId()); // adds dateNight id from newly created dateNight
			res.setHeader("Location", url.toString()); // sets location in http header to find new dateNight
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			dateNight = null;
		}
		return dateNight;

	}

	@PutMapping("datenights/{id}")
	public DateNight editDateNight(@RequestBody DateNight dateNight, @PathVariable int id, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		DateNight updateDateNight = null;
		try {
			updateDateNight = dateNightService.updateDateNight(dateNight, id, principal.getName());
			if (updateDateNight == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			System.err.println("Error updating date night");
		}
		return dateNight;
	}

	@DeleteMapping("datenights/{id}")
	public void deleteDateNight(@PathVariable Integer id, HttpServletResponse res, Principal principal) {
		try {
			boolean dateNightIsDeleted = dateNightService.deleteDateNight(principal.getName(), id);
			if (dateNightIsDeleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}

		} catch (Exception e) {
			res.setStatus(400);
		}

	}
}

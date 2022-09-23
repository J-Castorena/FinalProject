package com.skilldistillery.datenight.controllers;

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

import com.skilldistillery.datenight.entities.AdditionalImage;
import com.skilldistillery.datenight.services.AdditionalImageService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class AdditionalImageController {

	@Autowired
	private AdditionalImageService additionalImgService;
	
	@GetMapping("additionalImages")
	public List<AdditionalImage> showAllAdditionalImages() {
		return additionalImgService.index();
	}

	@GetMapping("additionalImages/{id}")
	public AdditionalImage additionalImageById(@PathVariable Integer id) {
		return additionalImgService.additionalImageById(id);
	}

	@PostMapping("additionalImages")
	public AdditionalImage addAdditionalImage(@RequestBody AdditionalImage additionalImage, HttpServletRequest req, HttpServletResponse res) {

		try {
			additionalImgService.createAdditionalImage(additionalImage);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL(); // finds URL that submitted request
			url.append("/").append(additionalImage.getId()); // adds additionalImage id from newly created additionalImage
			res.setHeader("Location", url.toString()); // sets location in http header to find new additionalImage
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			additionalImage = null;
		}
		return additionalImage;

	}

	@PutMapping("additionalImages")
	public AdditionalImage editAdditionalImage(@RequestBody AdditionalImage additionalImage, HttpServletResponse res) {
		try {
			AdditionalImage updateAdditionalImage = additionalImgService.updateAdditionalImage(additionalImage);
			if (updateAdditionalImage == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			additionalImage = null;
		}
		return additionalImage;
	}

	@DeleteMapping("additionalImages/{id}")
	public void deleteAdditionalImage(@PathVariable Integer id, HttpServletResponse res) {
		try {
			boolean additionalImageIsDeleted = additionalImgService.deleteAdditionalImage(id);
			if (additionalImageIsDeleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}

		} catch (Exception e) {
			res.setStatus(400);
		}

	}

}

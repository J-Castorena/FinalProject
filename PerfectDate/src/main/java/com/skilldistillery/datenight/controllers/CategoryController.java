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

import com.skilldistillery.datenight.entities.Category;
import com.skilldistillery.datenight.services.CategoryService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost"})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("categories")
	public List<Category> showAllCategories() {
		return categoryService.index();
	}

	@GetMapping("categories/{id}")
	public Category categoryById(@PathVariable Integer id) {
		return categoryService.categoryById(id);
	}

	@PostMapping("categories")
	public Category addCategory(@RequestBody Category category, HttpServletRequest req, HttpServletResponse res) {

		try {
			categoryService.createCategory(category);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL(); 
			url.append("/").append(category.getId()); 
			res.setHeader("Location", url.toString()); 
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			category = null;
		}
		return category;

	}

	@PutMapping("categories")
	public Category editCategory(@RequestBody Category category, HttpServletResponse res) {
		try {
			Category updateCategory = categoryService.updateCategory(category);
			if (updateCategory == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			category = null;
		}
		return category;
	}

	@DeleteMapping("categories/{id}")
	public void deleteCategory(@PathVariable Integer id, HttpServletResponse res) {
		try {
			boolean categoryIsDeleted = categoryService.deleteCategory(id);
			if (categoryIsDeleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}

		} catch (Exception e) {
			res.setStatus(400);
		}

	}

}

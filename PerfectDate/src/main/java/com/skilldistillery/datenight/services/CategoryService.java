package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.Category;

public interface CategoryService {

	List<Category> index();
	
	List<Category> getByName(String name);

	Category categoryById(Integer id);

	Category createCategory(Category category);

	Category updateCategory(Category category);

	boolean deleteCategory(Integer id);
}

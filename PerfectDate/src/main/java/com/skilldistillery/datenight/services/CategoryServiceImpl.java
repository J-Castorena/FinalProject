package com.skilldistillery.datenight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Category;
import com.skilldistillery.datenight.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<Category> index() {
		return categoryRepo.findAll();
	}
	
	@Override
	public List<Category> getByName(String name) {
		return categoryRepo.findByName(name);
	}

	@Override
	public Category categoryById(Integer id) {
		return categoryRepo.findCategoryById(id);
	}
	
	@Override
	public Category createCategory(Category category) {
		return categoryRepo.saveAndFlush(category);
	}

	@Override
	public Category updateCategory(Category category) {
		Category categoryToUpdate = categoryRepo.findCategoryById(category.getId());
		if (categoryToUpdate != null) {
			categoryToUpdate.setName(category.getName());
			categoryRepo.saveAndFlush(categoryToUpdate);
			return (categoryToUpdate);

		}
		return null;
	}

	@Override
	public boolean deleteCategory(Integer id) {
		boolean categoryDeleted = false;
		if (categoryRepo.existsById(id)) {
			categoryRepo.deleteById(id);
			categoryDeleted = true;
		}
		return categoryDeleted;
	}


}

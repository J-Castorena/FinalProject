package com.skilldistillery.datenight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.datenight.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query(value="SELECT * FROM category WHERE id = :categoryId", nativeQuery = true)
	Category findCategoryById(@Param("categoryId") Integer categoryId);
	
	List<Category> findByName(String name);
}

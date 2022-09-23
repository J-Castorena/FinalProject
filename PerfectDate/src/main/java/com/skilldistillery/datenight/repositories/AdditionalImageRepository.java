package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.AdditionalImage;

public interface AdditionalImageRepository extends JpaRepository<AdditionalImage, Integer>{

	@Query(value="SELECT * FROM additional_image WHERE id = :additionalImageId", nativeQuery = true)
	AdditionalImage findAdditionalImageById(@Param("additionalImageId") Integer additionalImageId);
}

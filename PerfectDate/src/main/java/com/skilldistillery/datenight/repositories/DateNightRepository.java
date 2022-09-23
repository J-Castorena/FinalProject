package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.datenight.entities.DateNight;

public interface DateNightRepository extends JpaRepository<DateNight, Integer>{
	
	@Query(value="SELECT * FROM date_night WHERE id = :dateNightId", nativeQuery = true)
	DateNight findDateNightById(@Param("dateNightId") Integer dateNightId);

}

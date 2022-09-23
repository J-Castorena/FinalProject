package com.skilldistillery.datenight.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateNightTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private DateNight dateNight;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPADateNightApp");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		dateNight = em.find(DateNight.class, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dateNight = null;
	}

	@Test
	void test_DateNight_entity_mapping() {
		assertNotNull(dateNight);
		assertEquals("Glenwood Hot Spring Pool", dateNight.getName());
	}
	
	@Test
	void test_DateNight_User_MTO_mapping() {
		assertNotNull(dateNight.getUser());
		assertEquals("Smith", dateNight.getUser().getLastName());
	}
	
	@Test
	void test_DateNight_Address_OTO_mapping() {
		assertNotNull(dateNight.getAddress());
		assertEquals("CO", dateNight.getAddress().getState());
	}
	
	@Test
	void test_DateNight_CategoryList_MTM_mapping() {
		assertNotNull(dateNight.getCategories());
		assertTrue(dateNight.getCategories().size() > 0);
		
	}
	@Test
	void test_DateNight_DateNightDiscussionBoardList_OTM_mapping() {
		assertNotNull(dateNight.getDiscussions());
//		assertTrue(dateNight.getDiscussions().size() > 0);
		
	}
	@Test
	void test_DateNight_ReviewsList_OTM_mapping() {
		assertNotNull(dateNight.getReviews());
		assertTrue(dateNight.getReviews().size() > 0);
		
	}
}






























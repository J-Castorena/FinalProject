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

class ReviewTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Review review;

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
		review = em.find(Review.class, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		review = null;
	}
	
	@Test
	void test_Review_entity_mapping() {
		assertNotNull(review.getId());
		assertEquals(5, review.getRating());
	}
	
	@Test
	void test_Review_User_MTO_mapping() {
		assertNotNull(review.getUser());
		assertEquals("Liam", review.getUser().getFirstName());
	}
	
	@Test
	void test_Review_DateNight_MTO_mapping() {
		assertNotNull(review.getDateNight());
		assertEquals("Glenwood Hot Spring Pool", review.getDateNight().getName());
	}
	
	@Test
	void test_Review_AdditionalImageList_OTM_mapping() {
		assertNotNull(review.getImages());
		assertTrue(review.getImages().size() > 0);
		assertEquals("hotspring", review.getImages().get(0).getCaption());
	}
}





























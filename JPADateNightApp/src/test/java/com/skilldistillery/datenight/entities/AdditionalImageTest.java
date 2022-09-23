package com.skilldistillery.datenight.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AdditionalImageTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private AdditionalImage additionalImage;
	
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
		additionalImage = em.find(AdditionalImage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		additionalImage = null;
	}

	@Test
	void test_AdditionalImage_entity_mapping() {
		assertNotNull(additionalImage);
		assertEquals("winery", additionalImage.getCaption());
	}

	@Test
	void test_AdditionalImage_Review_ManyToOne_mapping() {
		assertNotNull(additionalImage.getReview());
		assertEquals(2, additionalImage.getReview().getId());
	}
}

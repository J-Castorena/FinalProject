package com.skilldistillery.datenight.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateNightDiscussionBoardTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private DateNightDiscussionBoard discussion;

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
		discussion = em.find(DateNightDiscussionBoard.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		discussion = null;
	}
	
	@Test
	void test_DateNightDiscussionBoard_entity_mapping() {
		assertNotNull(discussion);
		assertEquals("Is this place still rad?", discussion.getMessage());
		
	}
	@Test
	void test_DateNightDiscussionBoard_User_MTO_mapping() {
		assertNotNull(discussion.getUser());
		assertEquals("Liam", discussion.getUser().getFirstName());
	}

	@Test
	void test_DateNightDiscussionBoard_dateNightId_MTO_mapping() {
		assertNotNull(discussion.getDateNightId());
		assertEquals("Yonah Mountain Vineyards", discussion.getDateNightId().getName());
	}
	@Test
	void test_DateNightDiscussionBoard_DateNightDiscussionBoard_MTO_mapping() {
		assertNotNull(discussion.getDiscussions());
		assertTrue(discussion.getDiscussions().size() > 0);
	}
}










































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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test_User_entity_mapping() {
		assertNotNull(user);
		assertEquals("liam", user.getUsername());
	}

	@Test
	void test_User_Address_OTM_mapping() {
		assertNotNull(user.getAddress());
		assertEquals("Atlanta", user.getAddress().getCity());
	}

	@Test
	void test_User_BlogsList_OTM_mapping() {
		assertNotNull(user.getBlogs());
		assertTrue(user.getBlogs().size() > 0);

	}

	@Test
	void test_User_DateNightList_OTM_mappings() {
		assertNotNull(user.getDateNights());
		assertTrue(user.getDateNights().size() > 0);

	}

}

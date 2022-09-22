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

class BlogTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Blog blog;
	
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
		blog = em.find(Blog.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		blog = null;
	}

	@Test
	void test_Blog_entity_mapping() {
		assertNotNull(blog);
		assertEquals("Good massage place", blog.getTitle());
	}

	@Test
	void test_Blog_User_MTO_mapping() {
		assertNotNull(blog.getUser());
		assertEquals("Smith", blog.getUser().getLastName());
		
	}
	
	@Test
	void test_Blog_BlogCommentList_OTM_mapping() {
		assertNotNull(blog.getBlogComments());
		assertTrue(blog.getBlogComments().size() > 0);
	}
}























